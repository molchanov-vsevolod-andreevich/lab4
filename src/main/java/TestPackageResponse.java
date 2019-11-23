import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

class TestPackageResponse {
    private final String packageId;
    private final Object[] testsResults;

    @JsonCreator
    TestPackageResponse(@JsonProperty("packageId") String packageId,
                        @JsonProperty("testsResults") Object[] testsResults) {
        this.packageId = packageId;
        this.testsResults = testsResults;
    }

    public String getPackageId() {
        return packageId;
    }

    public Object[] getTestsResults() {
        return testsResults;
    }

    static class TestResult {
        @JsonIgnore
        private final String packageId;
        private final String testName;
        private final boolean isCorrect;
        private final String result;
        private final String expectedResult;
        private final Object[] params;

        @JsonCreator
        TestResult(String packageId, @JsonProperty("testName") String testName,
                   @JsonProperty("correct") boolean isCorrect,
                   @JsonProperty("result") String result,
                   @JsonProperty("expectedResult") String expectedResult,
                   @JsonProperty("params") Object[] params) {
            this.packageId = packageId;
            this.testName = testName;
            this.isCorrect = isCorrect;
            this.result = result;
            this.expectedResult = expectedResult;
            this.params = params;
        }

        public String getPackageId() {
            return packageId;
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

        public Object[] getParams() {
            return params;
        }
    }

    static class TestToStore {
        private final String packageId;
        private final TestResult testResult;

        TestToStore(String packageId, TestResult testResult) {
            this.packageId = packageId;
            this.testResult = testResult;
        }

        String getPackageId() {
            return packageId;
        }

        TestResult getTestResult() {
            return testResult;
        }
    }
}