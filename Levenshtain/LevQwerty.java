import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LevQwerty {

    public static HashMap<Character, String> LevQwertyMap = new HashMap<Character, String>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input first word");
        String firstWord = scan.nextLine();
        System.out.println("Input second word");
        String secondWord = scan.nextLine();
        if(firstWord.length()==0 || secondWord.length()==0){
            System.out.println("Wrong input");
        }else{
        System.out.println(LevQwertyFun(firstWord, secondWord));
        }

    }

    static double LevQwertyFun(String x, String y) {
        if (x.isEmpty()) {
            return y.length();
        }else if (y.isEmpty()) {
            return x.length();
        }
        double substitution = LevQwertyFun(x.substring(1), y.substring(1)) + costOfSubstitution(x.charAt(0), y.charAt(0));
        double insertion = LevQwertyFun(x, y.substring(1)) + 1;
        double deletion = LevQwertyFun(x.substring(1), y) + 1;

        return min(substitution, insertion, deletion);
    }

    static double costOfSubstitution(char a, char b) {
        prepareLevQueryHashMap();
        if(LevQwertyMap.get(a).contains(String.valueOf(b))){
            return 0.5;
        }
        if(a==b){
            return 0;
        }
        else{
            return 1;
        }
    }

    private static double min(double... numbers) {
        return Arrays.stream(numbers).min()
                .orElse(Double.MAX_VALUE);
    }

    static void prepareLevQueryHashMap(){
        LevQwertyMap.put('q', "w");
        LevQwertyMap.put('w', "qe");
        LevQwertyMap.put('e', "wr");
        LevQwertyMap.put('r', "et");
        LevQwertyMap.put('t', "ry");
        LevQwertyMap.put('y', "tu");
        LevQwertyMap.put('u', "yi");
        LevQwertyMap.put('i', "uo");
        LevQwertyMap.put('o', "ip");
        LevQwertyMap.put('p', "o");
        LevQwertyMap.put('a', "s");
        LevQwertyMap.put('s', "ad");
        LevQwertyMap.put('d', "sf");
        LevQwertyMap.put('f', "dg");
        LevQwertyMap.put('g', "fh");
        LevQwertyMap.put('h', "gj");
        LevQwertyMap.put('j', "hk");
        LevQwertyMap.put('k', "jl");
        LevQwertyMap.put('l', "k");
        LevQwertyMap.put('z', "x");
        LevQwertyMap.put('x', "zc");
        LevQwertyMap.put('c', "xv");
        LevQwertyMap.put('v', "cb");
        LevQwertyMap.put('b', "vn");
        LevQwertyMap.put('n', "bm");
        LevQwertyMap.put('m', "n");
    }
}
