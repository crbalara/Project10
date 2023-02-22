
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
public class ChatRoomClient {

    static JFrame fr1 = new JFrame("Client");
    static JPanel jp = new JPanel();
    static JLabel jl;
    static JLabel jl1,jl3,jl4,jl5,jl6,jl7,jl8;
    static JTextField jtf = new JTextField();
    static JButton bt;
    static int a =40;
    static DataInputStream dts;
    static DataOutputStream dtss;
    public static void main(String[] args) {
        fr1.setSize(400,500);
        fr1.setLayout(null);


        fr1.getContentPane().setBackground(Color.cyan);
        jp.setBackground(Color.lightGray);
        ImageIcon arr = new ImageIcon("C:\\Users\\admin\\Downloads\\arr.png");
        jl3 = new JLabel(arr);
        jl3.setBounds(5,8,30,20);
        fr1.add(jl3);

        jl5 = new JLabel("Server");
        jl5.setBounds(70,4,50,30);
        fr1.add(jl5);

        ImageIcon arr2 = new ImageIcon("C:\\Users\\admin\\Downloads\\c2.png");
        jl6 = new JLabel(arr2);
        jl6.setBounds(280,5,40,30);
        fr1.add(jl6);

        ImageIcon arr3 = new ImageIcon("C:\\Users\\admin\\Downloads\\d1.png");
        jl7 = new JLabel(arr3);
        jl7.setBounds(330,5,40,30);
        fr1.add(jl7);

        ImageIcon arr4 = new ImageIcon("C:\\Users\\admin\\Downloads\\m1.png");
        jl8 = new JLabel(arr4);
        jl8.setBounds(300,420,30,40);
        fr1.add(jl8);
        jp.setLayout(null);
        jp.setBorder(null);
        fr1.add(jp);
        jp.setBounds(0,40,385,380);
        fr1.add(jtf);
        jtf.setBorder(null);
        ImageIcon ic = new ImageIcon("C:\\Users\\admin\\Downloads\\send2.png");
        bt = new JButton(ic);
        jtf.setBounds(0,421,300,40);
        fr1.add(bt);
        bt.setBounds(330,421,60,40);
        fr1.setVisible(true);
        try {
            Socket sst = new Socket("localhost", 8888);
            System.out.println("SERVER IS CONNECTED");
            dts = new DataInputStream(sst.getInputStream());
            //Scanner sc1 = new Scanner(System.in);
            dtss = new DataOutputStream(sst.getOutputStream());
            reader();
            write();
        }//try block end;
        catch(Exception ee)
        {
            System.out.println(ee);
        }//catch end;
    }//main end;
    static void write() {
        Thread tr = new Thread(() -> {
            bt.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String msg = jtf.getText();
                        System.out.println(msg);
                        dtss.writeUTF(msg);
                        jtf.setText("");
                        jl1 = new JLabel();
                        jp.add(jl1);
                        jl1.setBounds(300,a,100,30);
                        jl1.setText(msg);
                        a=a+20;
                    } catch (Exception w) {
                        System.out.println(w);
                    }
                }
            });
        });
        tr.start();
    }
    static void reader()
    {
        Thread th = new Thread(()->
        {
            while(true) {
                try {
                    String ms = dts.readUTF();
                    System.out.println(ms);
                    jl = new JLabel();
                    jl.setBounds(0,a,100,30);
                    jp.add(jl);
                    jl.setText(ms);
                    a = a + 20;
                } catch (Exception q) {
                    System.out.println(q);
                }
            }
        });
        th.start();
    }
}//public class end;