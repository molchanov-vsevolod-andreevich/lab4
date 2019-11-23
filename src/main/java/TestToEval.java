static class TestToEval {
    private final String packageId;
    private final String jsScript;
    private final String functionName;
    private final TestPackageRequest.Test test;

    TestToEval(String packageId, String jsScript, String functionName, TestPackageRequest.Test test) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.test = test;
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

    TestPackageRequest.Test getTest() {
        return test;
    }
}