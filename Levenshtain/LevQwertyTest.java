import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LevQwertyTest {

    @Test
    void levQwertyTest() {
        assertEquals(LevQwerty.LevQwertyFun("kot", "kita"), 1.5,
                "substitution + insertion should return 1.5");
        assertEquals(LevQwerty.LevQwertyFun("pies", "koes"), 1.5,
                "substitution + insertion should return 1.5");
        assertEquals(LevQwerty.LevQwertyFun("kwiat", "kwist"), 0.5,
                "deletion should return 0.5");
        assertEquals(LevQwerty.LevQwertyFun("mapa", "maro"), 2.0,
                "deletion should return 2.0");
        assertEquals(LevQwerty.LevQwertyFun("drab", "dal"), 2.0,
                "deletion should return 2.0");
    }

    @Test
    void costOfSubstitutionTest() {
        assertEquals(LevQwerty.costOfSubstitution('d', 'b'), 1.0,
                "insertion should return 1");
        assertEquals(LevQwerty.costOfSubstitution('u', 'i'), 0.5,
                "substytution should return 1");
    }
}