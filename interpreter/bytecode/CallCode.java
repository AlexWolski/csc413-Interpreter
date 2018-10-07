package interpreter.bytecode;

public class CallCode extends ByteCode {
    String funcName;
    int resolvedAddress;

    public void init(String[] parameters) {
        funcName = parameters[0];
    }

    public void execute() {
    }
}