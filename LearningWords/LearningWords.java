import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LearningWords{
    public static double p = 0.50;
    public static Integer n = 10;
    public static Integer k = 3;

    public static List<String> word = new LinkedList<String>();
    public static Set<String> knownWords = new HashSet<String>();
    public static Set<String> learnedWords = new HashSet<String>();
    public static Set<String> forgottenWords = new HashSet<String>();

    public static void main(String[] args) throws IOException{

        readWordFromFile();
        for( int i = 0 ; i < n ; i++){
            if( i > k ) {
                while (forgottenWords.size() < 2) {
                    if (knownWords.size() < 1) {
                        break;
                    }
                    String string = randWordSet(knownWords);
                    forgottenWords.add(string);
                }
            }

            while(learnedWords.size() < 2 ){
                String string = randWord(word);
                learnedWords.add(string);
                knownWords.add(string);
            }

            Iterator itr = forgottenWords.iterator();
            while(itr.hasNext()) {
                if ( isForgotten() ) {
                    knownWords.remove(itr.next());
                    forgottenWords.remove(itr.next());
                }
            }
            System.out.println("New words" + learnedWords);
            System.out.println("Forgotten words" + forgottenWords);
            System.out.println(knownWords);

            learnedWords.clear();
            forgottenWords.clear();
        }
    }

    public static boolean isForgotten(){
        return ( new Random().nextDouble() <= p);
    }

    public static String randWord(List<String> list){
        Random rand = new Random();
        String randomElement = list.get(rand.nextInt(list.size()));
        return randomElement;
    }

    public static String randWordSet(Set<String> set){
        List<String> list = new ArrayList<>(set);
        Random rand = new Random();
        String randomElement = list.get(rand.nextInt(list.size()));
        return randomElement;
    }

    public static void readWordFromFile() throws IOException {
        word = Files.readAllLines(Paths.get("C:\\Users\\afranas\\Desktop\\1500.txt"), StandardCharsets.UTF_8);
    }
}

