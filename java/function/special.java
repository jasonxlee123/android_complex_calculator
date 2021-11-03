package function;
import static function.cleaning.*;

import android.util.Log;

import java.util.regex.Pattern;

public class special {
    //save data while cal
    private String str1=""; //complex expression and its result
    private String str2=""; //original expression save byte by byte
    private String str3=""; // save the only result of complex cal
    private String str4=""; //initialize the expression to computable specification

    /**
     * clean and filter the expression for complex calculation
     *
     * @param str
     *            expression with brackets
     */

    public String adcal(String str){
        String n; //used as a char
        //replace symbols
        for(int i=0;i<str.length();i++) {
            n = String.valueOf(str.charAt(i));
            //replace symbols +-*/
            if (n.equals("＋")) {
                str4 = str4 + "+";
            }
            else if (n.equals("－")) {
                str4 = str4 + "-";
            }
            else if (n.equals("×")) {
                str4 = str4 + "*";
            }
            else if (n.equals("÷")) {
                str4 = str4 + "/";
            }
            else{
                str4=str4 + String.valueOf(str.charAt(i));
            }
        }
        Log.d("specialCF",str2);
        str=str4;
        int flag1=0;//()
        //complex and special cal
        for(int i=0;i<str.length();i++){
            n= String.valueOf(str.charAt(i));
            if(n.equals("s")){//sin, get the sign and lead to cal read as digit
                i=i+3;
                flag1++; //( to +1
                str1=str1+"(";
                while(flag1!=0){//read the outermost layer brackets
                    i++;
                    if(String.valueOf(str.charAt(i)).equals("(")){
                        flag1++;
                        str1=str1+"(";
                    }
                    else if(String.valueOf(str.charAt(i)).equals(")")){
                        flag1--; //) to -1
                        str1=str1+")";
                    }
                    else
                        str1=str1+String.valueOf(str.charAt(i)); //put the char to str1
                }
                Log.d("Special",str1);
                try {
                    str3=str3 + counti.cal(str1); //cal the expression of the complex symbol
                    Log.d("Special1",str3);
                    str2= str2 + sinc(Double.parseDouble(str3)); //cal the complex symbol and send to str2
                    Log.d("Special2",str2);
                    str3="";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(n.equals("c")){//cos
                i=i+3;
                flag1++;
                str1=str1+"(";
                while(flag1!=0){
                    i++;
                    if(String.valueOf(str.charAt(i)).equals("(")){
                        flag1++;
                        str1=str1+"(";
                    }
                    else if(String.valueOf(str.charAt(i)).equals(")")){
                        flag1--;
                        str1=str1+")";
                    }
                    else
                        str1=str1+String.valueOf(str.charAt(i));
                }
                Log.d("Special",str1);
                try {
                    str3=str3 + counti.cal(str1);
                    Log.d("Special1",str3);
                    str2= str2 + cosc(Double.parseDouble(str3));
                    Log.d("Special2",str2);
                    str3="";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(n.equals("t")){//tan
                i=i+3;
                flag1++;
                str1=str1+"(";
                while(flag1!=0){
                    i++;
                    if(String.valueOf(str.charAt(i)).equals("(")){
                        flag1++;
                        str1=str1+"(";
                    }
                    else if(String.valueOf(str.charAt(i)).equals(")")){
                        flag1--;
                        str1=str1+")";
                    }
                    else
                        str1=str1+String.valueOf(str.charAt(i));
                }
                Log.d("Special",str1);
                try {
                    str3=str3 + counti.cal(str1);
                    Log.d("Special1",str3);
                    str2= str2 + tanc(Double.parseDouble(str3));
                    Log.d("Special2",str2);
                    str3="";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(n.equals("f")){//factorial
                i=i+3;
                flag1++;
                str1=str1+"(";
                while(flag1!=0){
                    i++;
                    if(String.valueOf(str.charAt(i)).equals("(")){
                        flag1++;
                        str1=str1+"(";
                    }
                    else if(String.valueOf(str.charAt(i)).equals(")")){
                        flag1--;
                        str1=str1+")";
                    }
                    else
                        str1=str1+String.valueOf(str.charAt(i));
                }
                Log.d("Special",str1);
                try {
                    str3=str3 + counti.cal(str1);
                    Log.d("Special1",str3);
                    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$"); //RE for judge the int
                    if(Double.parseDouble(str3)>=0 && pattern.matcher(str3).matches()){ //lt 0 and int
                        return "ERROR";
                    }
                    str2= str2 + factorial(Integer.parseInt(str3)); //cal the complex expression
                    Log.d("Special2",str2);
                    str3="";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(n.equals("p")){//percent
                i=i+3;
                flag1++;
                str1=str1+"(";
                while(flag1!=0){
                    i++;
                    if(String.valueOf(str.charAt(i)).equals("(")){
                        flag1++;
                        str1=str1+"(";
                    }
                    else if(String.valueOf(str.charAt(i)).equals(")")){
                        flag1--;
                        str1=str1+")";
                    }
                    else
                        str1=str1+String.valueOf(str.charAt(i));
                }
                Log.d("Special",str1);
                try {
                    str3=str3 + counti.cal(str1);
                    Log.d("Special1",str3);
                    str2= str2 + percent(Double.parseDouble(str3));
                    Log.d("Special2",str2);
                    str3="";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(n.equals("r")){//reciprocal
                i=i+3;
                flag1++;
                str1=str1+"(";
                while(flag1!=0){
                    i++;
                    if(String.valueOf(str.charAt(i)).equals("(")){
                        flag1++;
                        str1=str1+"(";
                    }
                    else if(String.valueOf(str.charAt(i)).equals(")")){
                        flag1--;
                        str1=str1+")";
                    }
                    else
                        str1=str1+String.valueOf(str.charAt(i));
                }
                Log.d("Special",str1);
                try {
                    str3=str3 + counti.cal(str1);
                    Log.d("Special1",str3);
                    str2= str2 + reciprocal(Double.parseDouble(str3));
                    Log.d("Special2",str2);
                    str3="";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(n.equals("o")){//root
                i=i+3;
                flag1++;
                str1=str1+"(";
                while(flag1!=0){
                    i++;
                    if(String.valueOf(str.charAt(i)).equals("(")){
                        flag1++;
                        str1=str1+"(";
                    }
                    else if(String.valueOf(str.charAt(i)).equals(")")){
                        flag1--;
                        str1=str1+")";
                    }
                    else
                        str1=str1+String.valueOf(str.charAt(i));
                }
                Log.d("Special",str1);
                try {
                    str3=str3 + counti.cal(str1);
                    Log.d("Special1",str3);
                    if(Double.parseDouble(str3)<0){ //only positive num can root
                        return "ERROR";
                    }
                    str2= str2 + sqrtc(Double.parseDouble(str3));
                    Log.d("Special2",str2);
                    str3="";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                str2=str2+String.valueOf(str.charAt(i));
                Log.d("End",str2);
            }

        }
    Log.d("Special2Last",str2);
    return str2;
    }
}

/*
sctfpr√
 */