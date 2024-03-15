import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

public class Poring implements MouseListener{
    private JFrame fr;
    private JLabel lb;
    
    public Poring(int i){
        fr = new JFrame();
        fr.setLayout(new FlowLayout());
        
        ImageIcon im = null;
        URL imageURL = Poring.class.getResource("poring.png");
        if (imageURL != null){
            im = new ImageIcon(imageURL);
        }

        lb = new JLabel(String.valueOf(i) ,im , JLabel.CENTER);
        lb.addMouseListener(this);
        
        fr.add(lb);
        
        fr.setSize(180, 130);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //
        int x = (int) (Math.random() * (screenSize.width - fr.getWidth())); //
        int y = (int) (Math.random() * (screenSize.height - fr.getHeight())); //
        fr.setLocation(x, y);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE ); //Set to DO_NOTHING_ON_CLOSE 
        fr.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        fr.dispose(); 
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
