import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class Test {
//    @JsonProperty("testName")
    private final String testName;
//    @JsonProperty("expectedResult")
    private final String expectedResult;
//    @JsonProperty("params")
    private final Object[] params;

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