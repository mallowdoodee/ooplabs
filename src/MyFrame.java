import javax.swing.JFrame;
public class MyFrame {
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        //MyClock clock = new MyClock();
        //MyTimer clock = new MyTimer();
        MyStopTimer clock = new MyStopTimer();
        Thread t = new Thread(clock);
        t.start();
        
        fr.add(clock);
        fr.pack();
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}
