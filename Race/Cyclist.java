public class Cyclist {
    public String surname;
    public Integer time;

    public Cyclist(String surname, Integer time){
        this.surname = surname;
        this.time = time;
    }

    @Override
    public String toString(){
        return surname + " " + time.toString();
    }
}
