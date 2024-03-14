import javax.swing.JLabel;
import java.util.Calendar;

public class MyClock extends JLabel implements Runnable {

    public MyClock() {
        setFont(new java.awt.Font("Cordia New", 1, 85)); // Set font outside the loop
    }

    @Override
    public void run() {
        while (true) {
            Calendar d = Calendar.getInstance();
            int sec = d.get(Calendar.SECOND);
            int min = d.get(Calendar.MINUTE);
            int hour = d.get(Calendar.HOUR_OF_DAY);
            setText(String.format("%02d:%02d:%02d", hour, min, sec)); // Format the time to display leading zeros
            try {
                Thread.sleep(1000); // Update the clock every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
