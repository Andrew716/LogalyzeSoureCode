package syslog.parse;

import syslog.pojo.Info;
import syslog.pojo.UniversalClass;
import syslog.pojo.Severity;
import com.google.gson.Gson;
import syslog.pojo.Debug;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by andrii on 29.02.16.
 */
public class Parser {

    public static final String REG_EX_SYSLOG = "^(\\w{1,3}\\s+\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2})\\s(\\S+)\\s(\\S+)\\s(.*)$";
    public static final String PATH_TO_SYSLOG_FILE = "";
    public static final String PATH_TO_JSON_SYSLOG = "";
    public static final Logger LOGGER = Logger.getLogger("Info logging");

    public static List writeDataToList(){
        List<UniversalClass> data = new ArrayList<UniversalClass>();
        BufferedReader bufferedReader = null;
        UniversalClass universalClass;
        try {
            String currentLine;
            bufferedReader = new BufferedReader(new FileReader(PATH_TO_SYSLOG_FILE));
            LOGGER.info("File exists");
            while ((currentLine = bufferedReader.readLine()) != null){
                Pattern pattern = Pattern.compile(REG_EX_SYSLOG);
                Matcher matcher = pattern.matcher(currentLine);
                if (matcher.find()){
                    universalClass = new UniversalClass(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
                    data.add(universalClass);
                }
            }
            LOGGER.info("Data was added successfully to the list");
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "File not found in the method writeDataToTempList()", e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "IOException has been generated in the method writeDataToTempList()", e);
        }finally {
            try {
                if (bufferedReader != null){
                    bufferedReader.close();
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "PrintStackTrace exception has been generated in the method writeDataToTempList");
            }
        }
        return data;
    }

    public static void parsingToJSON(){
        try{
            FileWriter fileWriter = new FileWriter(PATH_TO_JSON_SYSLOG);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            List tempList = writeDataToList();
            Info info = new Info();
            Debug debug = new Debug();
            for (int i = 0; i < tempList.size(); i++){
                if (((UniversalClass)tempList.get(i)).getService().equals("tgtd:") || ((UniversalClass)tempList.get(i)).getService().equals("proxy-server:")){
                    info.add((UniversalClass)tempList.get(i));
                }else {
                    debug.add((UniversalClass)tempList.get(i));
                }
            }
                Severity severity = new Severity(info, debug);
                fileWriter.write(writeToJSON(severity));
                printWriter.println();
                fileWriter.close();
            } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String writeToJSON(Severity severity){
        Gson gson = new Gson();
        String json = gson.toJson(severity);
        return json;
    }

    public static void main(String[] args){
        Pattern pattern = Pattern.compile(REG_EX_SYSLOG);
        Matcher matcher = pattern.matcher("Jun  9 15:41:36 devstack-precise-hpcloud-b3-227769 object-replicator: Object replication complete. (0.00 minutes)");
        if (matcher.matches()){
            System.out.println("Hello");
        }

    }
}
