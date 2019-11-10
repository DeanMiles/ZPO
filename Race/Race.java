import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import static java.lang.Thread.sleep;

public class Race extends JFrame {

    static JFrame frame;
    static JTable tab= new JTable(12, 2);
    public static List<String> surnameList = new LinkedList<String>();
    public static PriorityQueue<Cyclist> pQueue = new PriorityQueue<Cyclist>(12, new StudentComparator());
    public static List<String> surnames = new LinkedList<String>();
    private static final Logger LOGGER = Logger.getLogger(Race.class.getName());
    public static ArrayList<Cyclist> arr = new ArrayList<Cyclist>();

    public static void main(String[] args) throws Exception {
        try {
            FileHandler fileLog = new FileHandler("mylog.log");
            LOGGER.addHandler(fileLog);
        }catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel p = new JPanel();
        prepareTable(p);
        readSurnames();
        surnames = getRandomCyclist();

        for (int i = 0; i < 12; i++) {
            String surname = surnames.get(i);
            int time = randTime();
            Cyclist cyc = new Cyclist(surname, time);
            Thread t = new Thread( new CyclistHandler(time, cyc, i , p));
            t.start();
            LOGGER.info("Cyclist: " + surname + " time: " + time );
            sleep(2200);
        }
        refreshTable(p);
        p.revalidate();
        p.repaint();
    }

    public static void prepareTable(JPanel p){
        frame = new JFrame("Race");
        tab.getColumnModel().getColumn(0).setPreferredWidth(50);
        tab.getColumnModel().getColumn(1).setPreferredWidth(420);
        frame.setSize(500, 280);
        p.add(tab);
        frame.add(p);
        frame.show();
    }

    public static void refreshTable(JPanel p){
        Iterator <Cyclist>value = pQueue.iterator();
        arr.clear();
        int counter = 0;
        while (value.hasNext() ) {
            tab.setValueAt(counter+1, counter,0);
            tab.setValueAt(value.next().toString(), counter,1);
            counter++;
        }
        p.revalidate();
        p.repaint();
    }

    public static void readSurnames() throws Exception {
        URL oracle = new URL("http://szgrabowski.kis.p.lodz.pl/zpo19/nazwiska.txt");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            surnameList.add(inputLine);
        }
        in.close();
    }

    public static Integer randTime() {
        Random r = new Random();
        double val = r.nextGaussian() * 40 + 290;
        int millisDelay = (int) Math.round(val);
        if (millisDelay < 240) {
            millisDelay = 240;
        } else if (millisDelay > 350) {
            millisDelay = 350;
        }
        return millisDelay;
    }

    public static List<String> getRandomCyclist() {
        List<String> cyclistSurnames = new LinkedList<String>();
        while (cyclistSurnames.size() != 12) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(surnameList.size());
            cyclistSurnames.add(surnameList.get(randomIndex));
            surnameList.remove(randomIndex);
        }
        return cyclistSurnames;
    }
}
