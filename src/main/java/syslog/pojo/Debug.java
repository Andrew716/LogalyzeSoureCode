package syslog.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by andrii on 29.02.16.
 */
public class Debug {

    private Set<UniversalClass> data = new HashSet<UniversalClass>();

    public Debug() {
    }

    public Debug(Set<UniversalClass> data) {
        this.data = data;
    }

    public Set<UniversalClass> getData() {
        return data;
    }

    public void setData(Set<UniversalClass> data) {
        this.data = data;
    }

    public void add(UniversalClass universalClass){
        data.add(universalClass);
    }
}
