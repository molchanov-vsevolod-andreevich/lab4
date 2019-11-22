import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestPackageMsg {
    private final String packageId;
    private final String jsScript;
    private final String functionName;
    

    @JsonCreator
    public TestPackageMsg(@JsonProperty("packageId") int id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public class Test {

    }
}