package interpreter.bytecode;

public class FalseBranchCode {
    String label;
    int resolvedAddress;

    public void init(String ... parameters) {
        label = parameters[0];
    }
}
