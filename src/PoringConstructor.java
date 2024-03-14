import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class PoringConstructor implements ActionListener{
    private JFrame fr;
    private JButton bt;
    private ArrayList<Poring> poring; //
    
    public PoringConstructor(){
        fr = new JFrame();
        bt = new JButton("Add");
        poring = new ArrayList<>(); //

        fr.setLayout(new FlowLayout());
        
        bt.addActionListener(this);
        fr.add(bt);
        
        fr.pack();
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //
        fr.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bt)){
            poring.add(new Poring(poring.size() + 1));//
        }
    }
    
    public static void main(String[] args) {
        new PoringConstructor();
    }
}
