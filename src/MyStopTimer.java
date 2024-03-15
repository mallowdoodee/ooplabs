import javax.swing.*;
import java.awt.event.*;

public class MyStopTimer extends JLabel implements Runnable, MouseListener {
    private int sec;
    private boolean pause;

    private synchronized void checkPaused(){
        while (pause){
            try{
                wait();
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }

    public void pauseThread(){
        pause = true;
    }

    public synchronized void resumeThread(){
        pause = false;
        notify();
    }

    public MyStopTimer() {
        sec = 0;
        pause = false; // Initially, the timer is not running

        setFont(new java.awt.Font("Cordia New", 1, 100));
        
        addMouseListener(this);
    }

    @Override
    public void run() {
        try {
            while (true) {
                checkPaused();
                int min = (sec / 60) % 60;
                int hr = min / 60;
                int remainingSec = sec % 60;
                setText(String.format("%02d:%02d:%02d", hr, min, remainingSec));
                sec++;
                Thread.sleep(1000); // Update the clock every second  
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (pause) {
            resumeThread(); // If paused, resume the timer
        } else {
            pauseThread(); // If running, pause the timer
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
