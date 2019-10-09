package EnglishRuler;
//AF
/*
Program draws vertical linear using recursion
Main parameters: length of ruler and number of nesting levels
 */

public class EnglishRuler {
    public static String str = "-";
    public static String empty = " ";

    public static void main(String[] args){
        int value1 = 3;
        int value2 = 6;
        int nest = value2;
        drawRuler(value1, value2, 0, nest);
    }

    public static void drawRuler(int length, int majorLength, int counter, int nest) {
        if( counter!=0 )
            drawInterval(majorLength - 1, nest);

        drawLine(majorLength, counter, nest);
        counter++;
        if(counter > length){
            return ;
        }
        else{
            drawRuler(length, majorLength, counter, nest);
        }
    }

    private static void drawInterval(int centralLength, int nest) {
        if (centralLength >= 1) {
            drawInterval(centralLength - 1, nest);
            drawLine(centralLength, nest);
            drawInterval(centralLength - 1, nest);
        }
    }

    private static void drawLine(int tickLength, int tickLabel, int nest) {
        int size = nest*2;
        int section = (size -(tickLength*2))/2;
        System.out.print(empty.repeat(section));
        System.out.print(str.repeat(tickLength*2));
        System.out.print(empty.repeat(section));
        if (tickLabel >= 0)
            System.out.print(" " + tickLabel);
        System.out.println();
    }

    private static void drawLine(int tickLength, int nest) {
        drawLine(tickLength, -1, nest);
    }
}
