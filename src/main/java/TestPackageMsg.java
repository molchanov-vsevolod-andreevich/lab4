import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestPackageMsg {
    private final String packageID;
    private final String name;

    @JsonCreator
    public TestPackageMsg(@JsonProperty("packageID") int id, @JsonProperty("name") String name) {
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