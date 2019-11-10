import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class CountsTest {
    private static HashMap<String, Integer> counts;
    private String word;
    {
        counts = new HashMap<>();
        this.word = "word";
        counts.merge(word, 1, Integer::sum);
    }

//    @Before
//    public void setUp() {
//        this.counts = new HashMap<>();
//        this.word = "word";
//        counts.merge(word, 1, Integer::sum);
//    }

    @Test
    public void testCountsContainsKey() {
        HashMap<String, Integer> tmp = new HashMap<>(counts);
        Counts myCounts = new Counts();
        Integer expectedResult = 2;
        assertEquals(expectedResult, myCounts.countsContainsKey(tmp, word));
    }

    @Test
    public void testCountsGetAndCheckNull() {
        HashMap<String, Integer> tmp = new HashMap<>(counts);
        Counts myCounts = new Counts();
        Integer expectedResult = 2;
        assertEquals(expectedResult, myCounts.countsGetAndCheckNull(tmp, word));
    }

    @Test
    public void testCountGetOrDefault() {
        HashMap<String, Integer> tmp = new HashMap<>(counts);
        Counts myCounts = new Counts();
        Integer expectedResult = 2;
        assertEquals(expectedResult, myCounts.countGetOrDefault(tmp, word));
    }

    @Test
    public void testCountPutIfAbsent() {
        HashMap<String, Integer> tmp = new HashMap<>(counts);
        Counts myCounts = new Counts();
        myCounts.countPutIfAbsent(tmp, word);
        Integer expectedResult = 3;
        assertEquals(expectedResult, myCounts.countPutIfAbsent(tmp, word));
    }
}