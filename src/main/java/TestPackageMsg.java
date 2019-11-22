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

    public class Test {
        private final String testName;
        private final String expectedResul;
        private final String params;

        @JsonCreator
        public Test(@JsonProperty("testName") String testName,
                    @JsonProperty("expectedResul") String expectedResul,
                    @JsonProperty("params") String params) {
            this.testName = testName;
            this.expectedResul = expectedResul;
            this.params = params;
        }

        public String getTestName() {
            return testName;
        }

        public String getExpectedResul() {
            return expectedResul;
        }

        public String getParams() {
            return params;
        }
    }
}