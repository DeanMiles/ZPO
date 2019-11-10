import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTime {
    public static SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");

    public static void main(String[] args){
    //taskA data
    String inputString1 = "01 09 1939";
    String inputString2 = "08 05 1945";
    //taskB data
    String inputString3 = "2016-01-01";
    Integer numberOfDays = 68;
    //taskC data
    LocalTime time = LocalTime.of(11,45);
    LocalTime time2 = LocalTime.of(22,30);
    Integer searchedSumNumber = 15;
    //taskD data
    LocalDate date = LocalDate.of(1997,06,13);
    LocalDate currentDate = LocalDate.now();

    //tasks exec
    taskA(inputString1, inputString2);
    taskB(inputString3, numberOfDays);
    taskC(time, time2, searchedSumNumber);
    taskD(date, currentDate);
    }

    public static void taskA(String string1, String string2){
        try {
            Date date1 = myFormat.parse(string1);
            Date date2 = myFormat.parse(string2);
            long diff = date2.getTime() - date1.getTime();
            System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void taskB(String string1, Integer numberOfDays){
        LocalDate dateTime = LocalDate.parse(string1);
        LocalDate dateTim = dateTime.plusDays(numberOfDays);
        System.out.println("Day of month " + dateTim.getDayOfMonth());
        System.out.println("Month " + dateTim.getMonth());
    }

    public static void taskC(LocalTime time, LocalTime time2, int number){
        int counter = 0 ;
        do{
            if( (sumOfDigits(time.getHour()) + sumOfDigits(time.getMinute())) == number ){
                counter++;
            }
            time = time.plusMinutes(1);
        }while(!time.equals(time2) );
        System.out.println("Number of occurrences searched sum of time: " + counter);
    }

    public static void taskD(LocalDate time, LocalDate time2){
        int counter = 0 ;
        do{
            if( (time.getDayOfMonth() == 29 ) && time.getMonthValue() == 2 ){
                counter++;
            }
            time = time.plusDays(1);
        }while( !time.equals(time2) );
        System.out.println("Number of occurrences searched date(29.02): " + counter);
    }

    public static int sumOfDigits(int number){
        int sum = 0, value = 0;
        while(number>0){
            value = number%10;
            sum += value;
            number /= 10;
        }
        return sum;
    }
}
