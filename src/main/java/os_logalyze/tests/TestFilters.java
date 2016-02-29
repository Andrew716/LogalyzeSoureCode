package os_logalyze.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by andrii on 23.02.16.
 */
public class TestFilters extends Base {

    public static final String REG_EX_IP = "^\\(\\d+\\)(\\S+)\\(\\d\\)$";

    public static String turnDomainToGoodView(String badDomainString) {
        String realDomain = null;
        char[] charsOfIP;
        char[] beforeWWW;
        char[] charsForWWW;
        char[] afterWWW;
        Pattern pattern = Pattern.compile(REG_EX_IP);
        Matcher matcher = pattern.matcher(badDomainString);
        if (matcher.matches()) {
            String str = matcher.group(1).replaceAll("\\(\\d+\\)", ".");
            charsOfIP = str.toCharArray();
            for (int i = 0; i < str.length() - 4; i++) {
                if (charsOfIP[i] == 'w' && charsOfIP[i + 1] == 'w' && charsOfIP[i + 2] == 'w' && charsOfIP[i + 3] == '.') {
                    beforeWWW = Arrays.copyOfRange(charsOfIP, 0, i);
                    charsForWWW = Arrays.copyOfRange(charsOfIP, i, i + 4);
                    afterWWW = Arrays.copyOfRange(charsOfIP, i + 4, charsOfIP.length);
                    List<Character> tempList = new ArrayList<Character>();
                    if (beforeWWW.length != 0 && afterWWW.length != 0 && charsForWWW.length != 0) {
                        for (int p = 0; p < charsForWWW.length; p++) {
                            tempList.add(charsForWWW[p]);
                        }
                        for (int j = 0; j < beforeWWW.length; j++) {
                            tempList.add(beforeWWW[j]);
                        }
                        for (int k = 0; k < afterWWW.length; k++) {
                            tempList.add(afterWWW[k]);
                        }
                        for (int m = 0; m < tempList.size(); m++) {
                            charsOfIP[m] = tempList.get(m);
                        }
                    }
                    realDomain = new String(charsOfIP);
                    break;
                } else {
                    realDomain = str;
                }
            }
        }
        return realDomain;
    }
}
