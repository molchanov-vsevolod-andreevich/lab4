import com.fasterxml.jackson.annotation.JsonCreator;
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

    public class TestWithId {
        private final String packageId;
        private final Test test;

        public TestWithId(String packageId, Test test) {
            this.packageId = packageId;
            this.test = test;
        }

        public String getPackageId() {
            return packageId;
        }

        public Test getTest() {
            return test;
        }
    }
}