import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class ChatRoomServer {
    static JFrame fr = new JFrame("Server");
    static JPanel jp = new JPanel();
    static JButton bt;
    static JTextField jtf;
    static JLabel jl1;
    static JLabel jl2,jl4,jl5,jl6,jl7,jl8,jl9;
    static JLabel jl3;
    static DataOutputStream dtss;
    static DataInputStream dts;
    static  int a=42;
    static Scanner sc;
    public static void main(String[] args) {
        ChatRoomServer sr = new ChatRoomServer();
        fr.setSize(400,500);
        ImageIcon arr = new ImageIcon("C:\\Users\\admin\\Downloads\\arr.png");
        jl3 = new JLabel(arr);
        jl3.setBounds(5,8,30,20);
        fr.add(jl3);

        jl5 = new JLabel("client");
        jl5.setBounds(70,4,50,30);
        fr.add(jl5);

        ImageIcon arr2 = new ImageIcon("C:\\Users\\admin\\Downloads\\c2.png");
        jl6 = new JLabel(arr2);
        jl6.setBounds(280,5,40,30);
        fr.add(jl6);

        ImageIcon arr3 = new ImageIcon("C:\\Users\\admin\\Downloads\\d1.png");
        jl7 = new JLabel(arr3);
        jl7.setBounds(330,5,40,30);
        fr.add(jl7);

        ImageIcon arr4 = new ImageIcon("C:\\Users\\admin\\Downloads\\m1.png");
        jl8 = new JLabel(arr4);
        jl8.setBounds(300,420,30,40);
        fr.add(jl8);

        fr.setLayout(null);
        ImageIcon ic = new ImageIcon("C:\\Users\\admin\\Downloads\\send2.png");
        bt = new JButton(ic);
        fr.getContentPane().setBackground(Color.gray);
        jp.setBackground(Color.lightGray);
        jl3.setBackground(Color.gray);
        jp.setLayout(null);
        jp.setBorder(null);

        fr.add(jp);
        jp.setBounds(0,40,385,380);
        jtf = new JTextField();
        jtf.setBounds(0,421,300,40);
        jtf.setBorder(null);
        fr.add(jtf);
        fr.add(bt);
        bt.setBounds(330,421,55,40);
        fr.setVisible(true);
        try {
            ServerSocket st = new ServerSocket(8888);
            Socket sst = st.accept();
            System.out.println("Server is Running");
            dts = new DataInputStream(sst.getInputStream());
            sc = new Scanner(System.in);
            dtss = new DataOutputStream(sst.getOutputStream());
            reader();
            write();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    static void write()
    {
        Thread tr = new Thread(()->
        {
            bt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String msg = jtf.getText();
                        System.out.println(msg);
                        dtss.writeUTF(msg);
                        jtf.setText("");
                        jl2 = new JLabel();
                        jl2.setBounds(300,a,100,30);
                        jp.add(jl2);
                        jl2.setText(msg);
                        a=a+20;
                    }
                    catch(Exception ee)
                    {
                        System.out.println(ee);
                    }
                }
            });
        });
        tr.start();
    }
    static void reader()
    {
        Thread th = new Thread(()->{
            while(true) {
                try {
                    String ms = dts.readUTF();
                    System.out.println(ms);
                    jl1=new JLabel();
                    jl1.setBounds(0,a,200,30);
                    jp.add(jl1);
                    jl1.setText(ms);
                    a=a+20;
                } catch (Exception r) {
                    System.out.println(r);
                }
            }
        });
        th.start();
    }
}
