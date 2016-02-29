package cisco.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by andrii on 29.02.16.
 */
public class Warning {

    private Set<UniversalClass> data = new HashSet<UniversalClass>();

    public Warning() {
    }

    public Warning(Set<UniversalClass> data) {
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
