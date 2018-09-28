package interpreter.bytecode;

public class CallCode {
    String funcName;
    int resolvedAddress;

    public void init(String ... parameters) {
        funcName = parameters[0];
    }
}
