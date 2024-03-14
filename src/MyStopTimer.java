import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyStopTimer extends JLabel implements Runnable, ActionListener, MouseListener {
    private int sec;
    private JButton bt;
    private boolean isRunning;

    private synchronized void checkPaused(){
        while (isRunning){
            try{
                wait();
            }
            catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }

    public void pauseThread(){
        isRunning = true;
    }

    public synchronized void resumeThread(){
        isRunning = false;
        notify();
    }

    public MyStopTimer() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        sec = 0;
        isRunning = false; // Initially, the timer is not running

        setFont(new java.awt.Font("Cordia New", 1, 100));

        bt = new JButton("Stop");
        bt.addActionListener(this);
        bt.setAlignmentX(Component.CENTER_ALIGNMENT);
        bt.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        
        add(Box.createVerticalGlue());
        add(bt);
        
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
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt) {
            pauseThread();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        resumeThread();
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
