package cisco.pojo;

/**
 * Created by andrii on 29.02.16.
 */
public class UniversalClass {

    private String date;
    private String type;
    private String severity;
    private String information;

    public UniversalClass() {
    }

    public UniversalClass(String date, String type, String severity, String information) {
        this.date = date;
        this.type = type;
        this.severity = severity;
        this.information = information;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString(){
        return "Date: " + date + "   type: " + type + "   severity: " + severity + "   info: " +information;
    }
}
