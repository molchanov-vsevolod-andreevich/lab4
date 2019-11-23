import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestPackageRequest {
    private String packageId;
    private String jsScript;
    private String functionName;
    private Test[] tests;

    @JsonCreator
    public TestPackageRequest(@JsonProperty("packageId") String packageId,
                              @JsonProperty("jsScript") String jsScript,
                              @JsonProperty("functionName") String functionName,
                              @JsonProperty("tests") Test[] tests) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.tests = tests;
//        System.out.println(packageId + " " + jsScript + " " + functionName + " ");
//        for (Test test : tests) {
//            System.out.println(test.testName + " " + test.expectedResult);
//            for (Object par : test.params) {
//                System.out.println(par);
//            }
//        }
    }

    String getPackageId() {
        return packageId;
    }

    String getJsScript() {
        return jsScript;
    }

    String getFunctionName() {
        return functionName;
    }

    Test[] getTests() {
        return tests;
    }

    public static class Test {
        private String testName;
        private String expectedResult;
        private Object[] params;

        @JsonCreator
        public Test(@JsonProperty("testName") String testName,
                    @JsonProperty("expectedResult") String expectedResult,
                    @JsonProperty("params") Object[] params) {
            this.testName = testName;
            this.expectedResult = expectedResult;
            this.params = params;
        }

        String getTestName() {
            return testName;
        }

        String getExpectedResult() {
            return expectedResult;
        }

        Object[] getParams() {
            return params;
        }
    }
}