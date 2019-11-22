import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestPackageMsg {
    private final String packageId;
    private final String jsScript;
    private final String functionName;
    private final Test[] tests;

    @JsonCreator
    public TestPackageMsg(@JsonProperty("packageId") String packageId,
                          @JsonProperty("jsScript") String jsScript,
                          @JsonProperty("functionName") String functionName,
                          @JsonProperty("tests") Test[] tests) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.tests = tests;
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