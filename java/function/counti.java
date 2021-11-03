package function;

public interface counti {
    /**
     * calculate interface for activity
     *
     * @param str
     *            expression with brackets
     */
    public static String cal(String str) throws Exception {
        str = new special().adcal(str);
        return new count().calculate(str);
    }
}
