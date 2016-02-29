package cisco.pojo;

/**
 * Created by andrii on 29.02.16.
 */
public class Severity {

    private Info info;
    private Warning warning;

    public Severity() {
    }

    public Severity(Info info, Warning warning) {
        this.info = info;
        this.warning = warning;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Warning getWarning() {
        return warning;
    }

    public void setWarning(Warning warning) {
        this.warning = warning;
    }
}
