import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

class TestPackageResponse {
    private final String packageId;
    private final Object[] testsResults;

    @JsonCreator
    TestPackageResponse(@JsonProperty(AkkaAppConstants.PACKAGE_ID_FIELD) String packageId,
                        @JsonProperty(AkkaAppConstants.TEST_RESULTS_FIELD) Object[] testsResults) {
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
        TestResult(String packageId, @JsonProperty(AkkaAppConstants.TEST_NAME_FIELD) String testName,
                   @JsonProperty(AkkaAppConstants.IS_CORRECT_FIELD) boolean isCorrect,
                   @JsonProperty(AkkaAppConstants.RESULT_FIELD) String result,
                   @JsonProperty(AkkaAppConstants.EXPECTED_RESULT_FIELD) String expectedResult,
                   @JsonProperty(AkkaAppConstants.PARAMS_FIELD) Object[] params) {
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
}