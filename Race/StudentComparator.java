import java.util.Comparator;

class StudentComparator implements Comparator<Cyclist> {

    public int compare(Cyclist s1, Cyclist s2) {
        if (s1.time < s2.time)
            return 1;
        else if (s1.time > s2.time)
            return -1;
        return 0;
    }
}
