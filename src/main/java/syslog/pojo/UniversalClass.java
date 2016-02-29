package syslog.pojo;

/**
 * Created by andrii on 29.02.16.
 */
public class UniversalClass {

    private String date;
    private String type;
    private String service;
    private String information;

    public UniversalClass() {
    }

    public UniversalClass(String date, String type, String service, String information) {
        this.date = date;
        this.type = type;
        this.service = service;
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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
