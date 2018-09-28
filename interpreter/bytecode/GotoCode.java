package interpreter.bytecode;

public class GotoCode {
    String label;
    int resolvedAddress;

    public void init(String ... parameters) {
        label = parameters[0];
    }
}
