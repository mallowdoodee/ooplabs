import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import javax.swing.*;

public class StudentView implements ActionListener, WindowListener{
    private JFrame fr;
    private JPanel pn, pn1;
    private JLabel lb1, lb2, lb3;
    private JTextField tf1, tf2, tf3;
    private JButton bt1, bt2;
    private Student std;
    private File file;
    

    public StudentView() {
        std = new Student();
        fr = new JFrame("Student");
        pn = new JPanel();
        pn1 = new JPanel();
        lb1 = new JLabel(" ID: ");
        lb2 = new JLabel(" Name:");
        lb3 = new JLabel(" Money:");
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField(String.valueOf(std.getMoney()));
        bt1 = new JButton("Deposit");
        bt2 = new JButton("Withdraw");

        fr.setLayout(new BorderLayout());
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(250, 130);
        fr.setVisible(true);
        pn.setLayout(new GridLayout(3, 2));
        pn1.setLayout(new FlowLayout());

        tf3.setEditable(false);

        pn.add(lb1);
        pn.add(tf1);
        pn.add(lb2);
        pn.add(tf2);
        pn.add(lb3);
        pn.add(tf3);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        pn1.add(bt1);
        pn1.add(bt2);

        fr.add(pn, BorderLayout.NORTH);
        fr.add(pn1, BorderLayout.CENTER);
        
        file = new File("StudentM.dat");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        fr.addWindowListener(this);
        }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton gs = (JButton) ae.getSource();
        if (gs.equals(bt1)) {
            std.setMoney(std.getMoney() + 100);
        } else if (gs.equals(bt2)) {
            if (std.getMoney() <= 0) {
                std.setMoney(0);
            } else {
                std.setMoney(std.getMoney() - 100);
            }
        }
        tf3.setText(String.valueOf(std.getMoney()));
    }
    
    @Override
    public void windowOpened(WindowEvent w){
        try (FileInputStream fin = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fin);){
            std = (Student) in.readObject();
            if (std == null) {
                std = new Student();
                std.setID(0);
            }
            
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        if (std.getID() == 0){
            tf1.setText("");
        } else {  
            tf1.setText(String.valueOf(std.getID()));
            
        }
        tf2.setText(std.getName());
        tf3.setText(String.valueOf(std.getMoney()));
    }
    
    @Override
    public void windowClosing(WindowEvent w){
        if (tf1.getText().equals("")) {
            std.setID(0);
        } else {
            std.setID(Integer.parseInt(tf1.getText()));
        }
        std.setName(tf2.getText());
        std.setMoney(Integer.parseInt(tf3.getText()));
        try (FileOutputStream fOut = new FileOutputStream(file);
                ObjectOutputStream oout = new ObjectOutputStream(fOut);){
            oout.writeObject(std);
        }catch (IOException e){
            e.printStackTrace();
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
        new StudentView();
    }
}

