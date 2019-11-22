import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class TestPackageResponse {
    private final String packageId;
    private final List<TestResult> testsResults;

    @JsonCreator
    public TestPackageResponse(@JsonProperty("packageId") String packageId,
                              @JsonProperty("testsResults") List<TestResult> testsResults) {
        this.packageId = packageId;
        this.testsResults = testsResults;
    }

    public String getPackageId() {
        return packageId;
    }

    public List<TestResult> getTestsResults() {
        return testsResults;
    }

    public class TestResult {
        private final String testName;
        private final String expectedResult;
        private final String params;

        @JsonCreator
        public TestResult(@JsonProperty("testName") String testName,
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