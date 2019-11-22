import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class TestPackageRequest {
//    @JsonProperty("packageId")
    private final String packageId;
//    @JsonProperty("jsScript")
    private final String jsScript;
//    @JsonProperty("functionName")
    private final String functionName;
//    @JsonProperty("tests")
    private final Test[] tests;

    public TestPackageRequest() {}

    public TestPackageRequest(String packageId,
                              String jsScript,
                              String functionName,
                              Test[] tests) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.tests = tests;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getJsScript() {
        return jsScript;
    }

    public String getFunctionName() {
        return functionName;
    }

    public Test[] getTests() {
        return tests;
    }

    public static class TestToEval {
        private final String packageId;
        private final String jsScript;
        private final String functionName;
        private final Test test;

        public TestToEval(String packageId, String jsScript, String functionName, Test test) {
            this.packageId = packageId;
            this.jsScript = jsScript;
            this.functionName = functionName;
            this.test = test;
        }

        public String getPackageId() {
            return packageId;
        }

        public String getJsScript() {
            return jsScript;
        }

        public String getFunctionName() {
            return functionName;
        }

        public Test getTest() {
            return test;
        }
    }
}