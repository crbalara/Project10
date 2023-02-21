import javax.swing.*;
import java.awt.*;

public class PasswordGenerator {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Registeration Form");
        frame.setSize(600,500);
        frame.setLayout(null);

        JLabel label1 = new JLabel("UserName :");
        label1.setBounds(10,30,90,40);
        label1.setFont(new Font("Arial", Font.BOLD,15));
        frame.add(label1);

        JTextField tf1 = new JTextField();
        tf1.setBounds(95,30,300,30);
        tf1.setFont(new Font("Arial", Font.BOLD,15));
        frame.add(tf1);

        JLabel label2 = new JLabel("Email Id :");
        label2.setBounds(10,80,80,40);
        label2.setFont(new Font("Arial", Font.BOLD,15));
        frame.add(label2);

        JTextField tf2 = new JTextField();
        tf2.setBounds(95,90,300,30);
        tf2.setFont(new Font("Arial", Font.BOLD,15));
        frame.add(tf2);

        JButton btn = new JButton("Submit");
        btn.setBounds(285,130,100,30);
        frame.add(btn);

        JLabel label3 = new JLabel("");
        label3.setBounds(35,170,500,40);
        label3.setFont(new Font("Arial", Font.BOLD,20));
        label3.setForeground(Color.BLUE);
        frame.add(label3);

        int pass = (int) (Math.random()*9999999);

        btn.addActionListener(e -> {
         String name=   tf1.getText();
         String mail=   tf2.getText();

            label3.setText(" "+name+" Your Password is :"+pass);
        });

        frame.setVisible(true);
    }
}
