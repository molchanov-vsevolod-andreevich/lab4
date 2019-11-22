import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestPackageRequest {
    private final String packageId;
    private final String jsScript;
    private final String functionName;
    private final Test[] tests;

    @JsonCreator
    public TestPackageRequest(@JsonProperty("packageId") String packageId,
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
        @JsonIgnore
        private final String packageId;
        private final String testName;
        private final String expectedResult;
        private final String params;

        @JsonCreator
        public Test(String packageId, @JsonProperty("testName") String testName,
                    @JsonProperty("expectedResul") String expectedResult,
                    @JsonProperty("params") String params) {
            this.packageId = packageId;
            this.testName = testName;
            this.expectedResult = expectedResult;
            this.params = params;
        }

        public String getTestName() {
            return testName;
        }

        public String getExpectedResult() {
            return expectedResult;
        }

        public String getParams() {
            return params;
        }
    }
}