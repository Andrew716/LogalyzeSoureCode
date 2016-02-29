package parsing.cisco.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by andrii on 29.02.16.
 */
public class Info {

    private Set<UniversalClass> data = new HashSet<UniversalClass>();

    public Info() {
    }

    public Info(Set<UniversalClass> universalClasses) {
        this.data = universalClasses;
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
