import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Notes {
    public static void main(String[] args) {
        Framen fn=new Framen();
        fn.st();

    }
}
class Framen{
    void st(){
        JFrame jfn=new JFrame("NOTE BOOK");
        jfn.setSize(600,600);
        jfn.setLayout(null);
        jfn.getContentPane().setBackground(Color.lightGray);
        JLabel jht=new JLabel("enter heading");
        jht.setBounds(20,30,200,30);
        jfn.add(jht);
        JTextField jft=new JTextField();
        jft.setBounds(20,60,200,40);
        jfn.add(jft);
        JLabel jw=new JLabel("write your notes here ");
        jw.setBounds(20,100,550,20);
        jfn.add(jw);
        JTextArea jwt=new JTextArea();
        jwt.setBounds(20,130,550,350);
        jfn.add(jwt);
        JMenuBar jmb=new JMenuBar();
        jmb.setBounds(0,0,600,30);
        jfn.add(jmb);
        jmb.setBackground(Color.cyan);

        JButton sub=new JButton("save");
        sub.setBounds(450,510,100,30);
        jfn.add(sub);
        JMenu jm=new JMenu("saved notes");
        jmb.add(jm);

        jmb.add(new JMenu("about"));
        jmb.add(new JMenu("help"));

        jfn.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfn.setVisible(true);
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fn= new File(""+jft.getText()+ ".txt");
                try {
                    fn.createNewFile();
                } catch (IOException ex) {
                    System.out.println("saved");
                }

            }
        });
    }




}