import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestPackageResponse {
    private final String packageId;
    private final Test[] testsResults;

    @JsonCreator
    public TestPackageResponse(String packageId, Test[] testsResults) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.testsResults = testsResults;
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

    public Test[] getTestsResults() {
        return testsResults;
    }

    public class Test {
        private final String testName;
        private final String expectedResult;
        private final String params;

        @JsonCreator
        public Test(@JsonProperty("testName") String testName,
                    @JsonProperty("expectedResul") String expectedResult,
                    @JsonProperty("params") String params) {
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