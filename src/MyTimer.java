import javax.swing.JLabel;

public class MyTimer extends JLabel implements Runnable {
    private int sec;

    public MyTimer() {
        setFont(new java.awt.Font("Cordia New", 1, 85));
        sec = 0;
    }

    @Override
    public void run() {
        while (true) {
            int min = (sec / 60) % 60;
            int hr = min / 60;
            int remainingSec = sec % 60;
            setText(String.format("%02d:%02d:%02d", hr, min, remainingSec));
            try {
                Thread.sleep(1000); // Update the clock every second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sec++;
        }
    }
}
