import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestPackageResponse {
    private final String packageId;
    private final TestResult[] testsResults;

    @JsonCreator
    public TestPackageResponse(@JsonProperty("packageId") String packageId,
                              @JsonProperty("testsResults") TestResult[] testsResults) {
        this.packageId = packageId;
        this.testsResults = testsResults;
    }

    public String getPackageId() {
        return packageId;
    }

    public TestResult[] getTestsResults() {
        return testsResults;
    }

    public static class TestResult {
        private final String testName;
        private final boolean isCorrect;
        private final String result;
        private final String expectedResult;
        private final String params;

        @JsonCreator
        public TestResult(@JsonProperty("testName") String testName,
                          @JsonProperty("correct") boolean isCorrect,
                          @JsonProperty("result") String result,
                          @JsonProperty("expectedResul") String expectedResult,
                          @JsonProperty("params") String params) {
            this.testName = testName;
            this.isCorrect = isCorrect;
            this.result = result;
            this.expectedResult = expectedResult;
            this.params = params;
        }

        public String getTestName() {
            return testName;
        }

        public boolean getIsCorrect() {
            return isCorrect;
        }

        public String getResult() {
            return result;
        }

        public String getExpectedResult() {
            return expectedResult;
        }

        public String getParams() {
            return params;
        }
    }

    public static class TestToStore {
        String packageId;
        TestResult testResult;

        public TestToStore(String packageId, TestResult testResult) {
            this.packageId = packageId;
            this.testResult = testResult;
        }

        public String getPackageId() {
            return packageId;
        }

        public TestResult getTestResult() {
            return testResult;
        }
    }
}