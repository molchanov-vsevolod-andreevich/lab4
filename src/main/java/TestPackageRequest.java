import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestPackageRequest {
    private String packageId;
    private String jsScript;
    private String functionName;
    private Test[] tests;

    @JsonCreator
    public TestPackageRequest() {}

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

    @JsonAutoDetect
    public static class Test {
        @JsonProperty("testName")
        private String testName;
        @JsonProperty("expectedResult")
        private String expectedResult;
        @JsonProperty("params")
        private Object[] params;

        public Test() {}

        public Test(String testName,
                    String expectedResult,
                    Object[] params) {
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

        public Object[] getParams() {
            return params;
        }
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