package parsing.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by andrii on 26.02.16.
 */
public class RegExForDifferentUsage {

    public final static String DATE_STRING_REG_EX = "";
    public final static String DATE_STRING_PALOALTO_REG_EX = "";
    public final static String DATE_NUMBER_REG_EX = "\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}.\\d{3}";
    public final static String DATE_NUMBER_MILLISECONDS_REG_EX = "";
    public final static String CONSOLE_REG_EX = "";
    public final static String CISCO_REG_EX = "";
    public final static String HP_REG_EX = "";
    public final static String JUNIPER_REG_EX = "";
    public final static String PALO_ALTO_REG_EX = "";
    public final static String OSSEC_REG_EX = "";
    public final static String SYSLOG_REG_EX = "";
    public final static String DEVSTACK_REG_EX = "";
//
    public static void main(String[] args){
        Pattern pattern = Pattern.compile(DATE_NUMBER_REG_EX);
        Matcher matcher = pattern.matcher("2013-09-27 18:15:38.334");
        if (matcher.matches()){
            System.out.println("Good!");
        }
    }
}
