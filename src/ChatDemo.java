import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class ChatDemo implements ActionListener, WindowListener{
    private JFrame fr;
    private JTextArea ta;
    private JTextField tf;
    private JButton bt1, bt2;
    private JPanel pn;
    private File file;
    public ChatDemo(){
        fr = new JFrame("แชท");
        Font font = new Font("FC Iconic", Font.PLAIN, 16);
        fr.setFont(font);
        ta = new JTextArea(20, 45);
        tf = new JTextField(45);
        pn = new JPanel();
        fr.setLayout(new BorderLayout());
        
        file = new File("ChatDemo.dat");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e);;
        }
        fr.addWindowListener(this);
        
        ta.setEditable(false);
        ta.setForeground(Color.BLUE);
        ta.setFont(font);
        tf.setFont(font);
        
        bt1 = new JButton("Submit");
        bt2 = new JButton("Reset");
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        pn.add(bt1);
        pn.add(bt2);
        
        fr.add(ta, BorderLayout.NORTH);
        fr.add(tf, BorderLayout.CENTER);
        fr.add(pn, BorderLayout.SOUTH);

        fr.pack();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
        
        
    }
    

    @Override
    public void actionPerformed(ActionEvent ae){
        JButton gs = (JButton) ae.getSource();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String chat = "";
        if (gs.equals(bt1)){
            chat = tf.getText();
            ta.append(dtf.format(LocalDateTime.now()) + ": " + chat + "\n");
            tf.setText("");
        } else if (gs.equals(bt2)){
            ta.setText("");
        }
    }
    
    @Override
    public void windowOpened(WindowEvent e){
        String txt = "";
        try (FileReader fr = new FileReader(file);){
            int tmp;
            while ((tmp = fr.read()) != -1) {
                txt += (char) tmp;
            }
            
        }catch (IOException ee){
            System.out.println(ee);
        }
        ta.setText(txt);
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        try (FileWriter fw = new FileWriter(file);){
            fw.write(ta.getText());
        }catch (IOException ee){
            System.out.println(ee);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
    
    public static void main(String[] args) {
        new ChatDemo();
    }
}
