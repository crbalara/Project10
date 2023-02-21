import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;

public class Quiz extends QuizJson {
    static JSONObject obj=null;
   static JSONArray array= null;
   static JLabel label;
   static JRadioButton a ;
    static JRadioButton b ;
    static JRadioButton c ;
    static JRadioButton d ;

    static  int i =0;
    public static void main(String[] args) {
        json();
        JSONParser parser = new JSONParser();

        try {

          array = (JSONArray) parser.parse(new FileReader(new File("C:\\Users\\91876\\Desktop\\Question1.json")));
             obj = (JSONObject) array.get(0);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        JFrame frame = new JFrame("Quiz");
        frame.setLayout(null);
        frame.setSize(600,450);

        label = new JLabel("Q.1 :"+ obj.get("Ques"));
        label.setFont(new Font("Arial",Font.BOLD,15));
        label.setBounds(20,20,650,70);
        frame.add(label);

       a = new JRadioButton(""+obj.get("opt1"));
        a.setBounds(20,95,200,40);
        a.setActionCommand("a");

         b = new JRadioButton(""+obj.get("opt2"));
        b.setBounds(300,95,200,40);
        b.setActionCommand("b");

         c = new JRadioButton(""+obj.get("opt3"));
        c.setBounds(20,150,200,40);
        c.setActionCommand("c");

         d = new JRadioButton(""+obj.get("opt4"));
        d.setBounds(300,150,200,40);
        d.setActionCommand("d");

        ButtonGroup bg = new ButtonGroup();
        bg.add(a);bg.add(b);bg.add(c);bg.add(d);
        frame.add(a);  frame.add(b);  frame.add(c);  frame.add(d);

        JButton submit = new JButton("SUBMIT & NEXT");
        submit.setBounds(350,220,150,40);
        frame.add(submit);

        JButton next = new JButton("SKIP & NEXT");
        next.setBounds(150,220,150,40);
        frame.add(next);


        submit.addActionListener(e -> {
            String input =  bg.getSelection().getActionCommand();
            if(input.equals(obj.get("ans")))
            {
                System.out.println("Right Answer");

            }
            else
            {
                System.out.println("Wrong Answer");
            }
            bg.clearSelection();
            if(i<5)

                i++;
            obj = (JSONObject) array.get(i);
            label.setText("Q."+(i+1)+": "+obj.get("Ques"));
            a.setText(""+obj.get("opt1"));
            b.setText(""+obj.get("opt2"));
            c.setText(""+obj.get("opt3"));
            d.setText(""+obj.get("opt4"));
        });

        next.addActionListener(e -> {
            System.out.println("Skipped");
if(i<5)
            i++;
            obj = (JSONObject) array.get(i);
            label.setText("Q."+(i+1)+": "+obj.get("Ques"));
            a.setText(""+obj.get("opt1"));
            b.setText(""+obj.get("opt2"));
            c.setText(""+obj.get("opt3"));
            d.setText(""+obj.get("opt4"));
        });


        frame.setVisible(true);


    }

}
