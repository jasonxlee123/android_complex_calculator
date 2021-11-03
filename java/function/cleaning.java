package function;
import static java.lang.Math.*;

import java.math.BigDecimal;

public interface cleaning {

    public static String sinc(double d) {
        double v = Math.toRadians(d);
        return String.valueOf(sin(v));
    }
    public static String cosc(double d) {
        double v = Math.toRadians(d);
        return String.valueOf(cos(v));
    }
    public static String tanc(double d) {
        double v = Math.toRadians(d);
        return String.valueOf(tan(v));
    }
    public static String percent(double d) {
        return String.valueOf(d/100);
    }
    public static String sqrtc(double d) {
        return String.valueOf(sqrt(d));
    }
    public static String factorial(int d) {
        int sum=1;
        if(d<0){
            return "ERROR";
        }
        for(int i=1;i<=d;i++){
            sum *= i;
        }
        return String.valueOf(sum);
    }
    public static String reciprocal(double d) {
        return String.valueOf(1/d);
    }
}
