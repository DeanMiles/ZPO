import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get("src/dane.txt"))) {

            int sumTwoBestEarningsPolish = stream
                    .filter(line -> line.contains("PL"))
                    .map(line -> Integer.parseInt(line.split(" ")[3]))
                    .sorted(Collections.reverseOrder())
                    .limit(2)
                    .mapToInt(i -> i)
                    .sum();

            System.out.println("Sum of two the best-earning Poles: : " + sumTwoBestEarningsPolish);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Stream<String> stream = Files.lines((Paths.get("src/dane.txt")))) {
            int sumTwoWorstEarningsPolish = stream
                    .filter(line -> line.contains("PL"))
                    .peek(System.out::println)
                    .map(line -> Integer.parseInt(line.split(" ")[3]))
                    .sorted()
                    .limit(2)
                    .mapToInt(i -> i)
                    .peek(System.out::println)
                    .sum();

            System.out.println("Sum of two the worst-earning Poles: " + sumTwoWorstEarningsPolish);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Stream<String> stream = Files.lines(Paths.get("src/dane.txt"))) {
            Map<String, Long> myMap = stream
                    .map(line -> line.split(" ")[2])
                    .collect(Collectors.groupingBy(line -> line.toString(),  LinkedHashMap::new, Collectors.counting()));

            System.out.println(myMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
