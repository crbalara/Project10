import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherInfo {
    static Scanner sc;
    static String city,state,temp,humidity,visibility,base,pressure;
    static JTextField cityname,statename;
    static void wether(){
        try {
            /*sc=new Scanner(System.in);
            city=sc.nextLine();
            state=sc.nextLine();*/
            city=cityname.getText();
            URL url=new URL("http://api.openweathermap.org/geo/1.0/direct?q="+city+",+91&limit=1&appid=d702494f832d26be7a7953404de86f01");
            HttpURLConnection ur=(HttpURLConnection)url.openConnection();
            ur.setRequestMethod("GET");
            InputStreamReader in=new InputStreamReader(ur.getInputStream());
            BufferedReader in1=new BufferedReader(in);
            String st="";
            while(st!=null) {
                st = in1.readLine();
                System.out.println(st);
                in1.close();
                JSONParser pr = new JSONParser();
                JSONArray arr = (JSONArray) pr.parse(st);
                //  org.json.JSONObject obj = new org.json.JSONObject(arr.toString());
                JSONObject obj = (JSONObject) arr.get(0);
                System.out.println(obj.get("lat"));
                System.out.println(obj.get("lon"));
                Object lat = (obj.get("lat"));
                Object lon = (obj.get("lon"));
                Double lat1 = (Double) lat;
                Double lon1 = (Double) lon;
                System.out.println(lat1);
                URL url2 = new URL("https://api.openweathermap.org/data/2.5/weather?lat=" + lat1 + "&lon=" + lon1 + "&appid=d702494f832d26be7a7953404de86f01");
                HttpURLConnection u2 = (HttpURLConnection) url2.openConnection();
                u2.setRequestMethod("GET");
                InputStreamReader rd = new InputStreamReader(u2.getInputStream());
                BufferedReader rd2 = new BufferedReader(rd);
                String st2 = "";
                String st3 = "";
                while (st2 != null) {
                    st2 = rd2.readLine();
                    System.out.println(st2);
                    st3 = st3 + st2;
                    rd.close();

                    JSONParser pr2 = new JSONParser();
                    JSONObject obj1 = (JSONObject) pr2.parse(st3);

                    //  System.out.println(obj1.get("main"));
                    System.out.println("visivility is :"+obj1.get("visibility"));
                    System.out.println("Base is :"+city);

                    JSONObject obj2 = (JSONObject) (obj1.get("main"));
                    System.out.println("pressure is :"+obj2.get("pressure"));
                    System.out.println("temp is : "+obj2.get("temp"));
                    System.out.println("humidity is : "+obj2.get("humidity"));

                    temp = obj2.get("temp") .toString();

                    visibility = obj1.get("visibility") .toString();
                    pressure = obj2.get("pressure") .toString();
                    humidity = obj2.get("humidity") .toString();
                    base = obj1.get("base") .toString();
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    static  void frame(){

        JFrame f=new JFrame("Wether Report");
        f.setBounds(100,100,405,430);
        f.setLayout(null);
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBounds(05,05,380,380);
        p.setBackground(Color.cyan);
        JLabel title=new JLabel("Know Your Locality Weather");
        title.setBounds(80,10,250,30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel city=new JLabel("Enter City Name");
        cityname=new JTextField();
        city.setBounds(10,40,100,30);

        cityname.setBounds(120,40,200,25);
        JButton submit = new JButton("SUBMIT");
        submit.setBounds(160,80,100,30);
        JTextArea data=new JTextArea();
        data.setBounds(40,130,300,160);
        data.setEditable(false);

        p.add(city);p.add(submit);
        p.add(data);
        p.add(cityname);
        f.add(p);p.add(title);
        f.setVisible(true);

        ActionListener ac=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wether();
                data.setText("Temperature is: "+temp+"\n");
                data.append("base is : "+base+"\n");
                data.append("pressure is :"+pressure+"\n");
                data.append("visiblity is : "+visibility+"\n");
                data.append("humidity is : "+humidity+"\n"+"\n");
                data.append("search next city weather ") ;
                cityname.setText("");
            }
        };submit.addActionListener(ac);


    }
    public static void main(String[] args) {
        WeatherInfo c=new WeatherInfo();
        frame();

    }
}
