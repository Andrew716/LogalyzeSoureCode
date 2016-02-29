package cisco.parse;

import com.google.gson.Gson;
import cisco.pojo.Info;
import cisco.pojo.Severity;
import cisco.pojo.UniversalClass;
import cisco.pojo.Warning;

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

    public static final String REG_EX_CISCO_LOGS = "^(\\w{3}\\s\\d{1,2}\\s\\d{2}:\\d{2}:\\d{2})\\s(\\w+)\\s(\\w+)\\s(.*)$";
    public static final String PATH_TO_CISCO_LOGS_FILE = "/home/andrii/Desktop/ciscorv220wtest";
    public static final String PATH_TO_JSON_PARSED_FILE = "/home/andrii/Desktop/ciscojson";
    public static final Logger LOGGER = Logger.getLogger("Info logging");

    public static List writeDataToTempList(){
        List<UniversalClass> universalClassList = new ArrayList<UniversalClass>();
        BufferedReader bufferedReader = null;
        UniversalClass universalClass;
        try {
            String currentLine;
            bufferedReader = new BufferedReader(new FileReader(PATH_TO_CISCO_LOGS_FILE));
            LOGGER.info("File exists");
            while ((currentLine = bufferedReader.readLine()) != null){
                Pattern pattern = Pattern.compile(REG_EX_CISCO_LOGS);
                Matcher matcher = pattern.matcher(currentLine);
                if (matcher.find()){
                    universalClass = new UniversalClass(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
                    universalClassList.add(universalClass);
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
        return universalClassList;
    }

    public static void parsingToJSON(){
        List tempList = writeDataToTempList();
        Info info = new Info();
        Warning warning = new Warning();
        for (int i = 0; i < tempList.size(); i++){
            if (((UniversalClass)tempList.get(i)).getSeverity().equals("NTP")){
                info.add((UniversalClass)tempList.get(i));
            }else {
                warning.add((UniversalClass)tempList.get(i));
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(PATH_TO_JSON_PARSED_FILE);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            Severity severity = new Severity(info, warning);
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
}
