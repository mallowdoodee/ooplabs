import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class TextEditor implements ActionListener{
    private JFrame fr;
    private JMenuBar mb;
    private JMenu mn;
    private JTextArea ta;
    private JMenuItem minew, miopen, misave, miclose;
    private File f;
    
    public TextEditor(){
        Font font = new Font("FC Iconic", Font.PLAIN, 16);
        fr = new JFrame("MaTextEditor");
        ta = new JTextArea();
        ta.setFont(font);
        mb = new JMenuBar();
        mn = new JMenu("File");
        minew = new JMenuItem("New");
        miopen = new JMenuItem("Open");
        misave = new JMenuItem("Save");
        miclose = new JMenuItem("Close");
        
        minew.addActionListener(this);
        miopen.addActionListener(this);
        misave.addActionListener(this);
        miclose.addActionListener(this);
        
        
        mn.add(minew);
        mn.add(miopen);
        mn.add(misave);
        mn.addSeparator();
        mn.add(miclose);
        
        JScrollPane scrollPane = new JScrollPane(ta);
        ta.setForeground(new Color(73, 105, 137));
        ta.setAlignmentX(Component.LEFT_ALIGNMENT);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        
        
        mb.add(mn);
        
        File f = new File("TextEditor.dat");
                try {
            f.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }
        
        fr.add(scrollPane);
        fr.add(mb, BorderLayout.NORTH);
        fr.setSize(500, 300);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JMenuItem gs = (JMenuItem) ae.getSource();
        if (gs.equals(minew)){
            ta.setText("");
            
        } else if (gs.equals(miopen)) {
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(fr);
            File f = fc.getSelectedFile();
            String txt = "";
            try (FileReader fr = new FileReader(f);){
                int tmp;
                while ((tmp = fr.read()) != -1) {
                    txt += (char) tmp;
                }
            }catch (IOException ee){
                System.out.println(ee);
            }
            ta.setText(txt);
            
        } else if (gs.equals(misave)){
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(fr);
            File f = fc.getSelectedFile();
            try (FileWriter fw = new FileWriter(f); ){
                fw.write(ta.getText());
            }catch (IOException e){
                e.printStackTrace();
            }
        } else {
            fr.dispose();
        }
    }
    
    public static void main(String[] args) {
        new TextEditor();
    }
}
