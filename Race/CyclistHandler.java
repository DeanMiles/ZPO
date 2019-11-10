import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class CyclistHandler extends Thread implements Runnable {
    final int time;
    final Cyclist cyc;
    final int i;
    final JPanel p;

    public CyclistHandler(int time, Cyclist cyc, int i, JPanel p){
        this.time = time;
        this.cyc = cyc;
        this.i = i;
        this.p = p;
    }

    @Override
    public void run() {
        int delay = time/25;
        Timer timer = new Timer("Timer");
        long milDelay = delay;//*1000;
        timer.schedule(task, milDelay);
    }

    TimerTask task = new TimerTask() {
        public void run() {
            Race.pQueue.add(cyc);
            Race.refreshTable(p);
        }
    };
}
