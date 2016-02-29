package syslog.pojo;

/**
 * Created by andrii on 29.02.16.
 */
public class Severity {

    private Info info;
    private Debug debug;

    public Severity(Info info, Debug debug) {
        this.info = info;
        this.debug = debug;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Debug getDebug() {
        return debug;
    }

    public void setDebug(Debug debug) {
        this.debug = debug;
    }
}
