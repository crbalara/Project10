import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class QuizJson {
   static File file = new File("C:\\Users\\91876\\Desktop\\Question1.json");
    public static void json()
    {
        JSONArray arr = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("Ques","Which data type is used to create a variable that should store text?");
        obj.put("opt1","String");
        obj.put("opt2","MyString");
        obj.put("opt3","string");
        obj.put("opt4","Txt");
        obj.put("ans","a");
        arr.add(obj);
        createfile(arr.toString());

        obj.put("Ques"," What is the default value of byte variable?");
        obj.put("opt1"," String is immutable.");
        obj.put("opt2","String can be created using new operator.");
        obj.put("opt3","String is a primary data type.");
        obj.put("opt4","None of the above.");
        obj.put("ans","String is a primary data type.");
        arr=readFile(file);
        arr.add(obj);
       createfile(arr.toString());
        obj.put("Ques"," Which of the following is a thread safe?");
        obj.put("opt1","StringBuilder");
        obj.put("opt2","StringBuffer");
        obj.put("opt3","Both of the above");
        obj.put("opt4","None of the above");
        obj.put("ans","b");
        arr=readFile(file);
        arr.add(obj);
        createfile(arr.toString());

        obj.put("Ques","  Java is designed by");
        obj.put("opt1","Dennis Ritchie");
        obj.put("opt2","James Gosling");
        obj.put("opt3","Charles Babbage");
        obj.put("opt4"," Guido van Rossum");
        obj.put("ans","b");
        arr=readFile(file);
        arr.add(obj);
        createfile(arr.toString());

        obj.put("Ques"," Java first appeared in?");
        obj.put("opt1"," May 23, 1995");
        obj.put("opt2","23 July, 1994");
        obj.put("opt3","18 August, 2001");
        obj.put("opt4","13 September, 1983");
        obj.put("ans","a");
        arr=readFile(file);
        arr.add(obj);
        createfile(arr.toString());

        obj.put("Ques","  Java influenced by?");
        obj.put("opt1"," C++");
        obj.put("opt2","Objective-C");
        obj.put("opt3"," Ada");
        obj.put("opt4"," All the above");
        obj.put("ans","a");
        arr=readFile(file);
        arr.add(obj);
        createfile(arr.toString());

      // createfile(arr.toString());

      // System.out.println(arr);
    }

  public static void  createfile(String s)
    {
     //   File file = new File("C:\\Users\\91876\\Desktop\\Question1.json");
        if (file.exists()) {
            //System.out.println("file Already exists");
        } else {
            System.out.println("file Created successfully");
        }
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(s);
            fw.close();
        }
        catch (Exception e)
        {

        }

    }
    public static void main(String[] args) {

        json();

    }
    public static JSONArray readFile(File file){
        JSONParser parser=new JSONParser();
        JSONArray jas;
        try {
             jas=(JSONArray) parser.parse(new FileReader(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return jas;
    }
}
