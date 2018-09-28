package interpreter.bytecode;

public class LabelCode {
    String label;
    int resolvedAddress;

    public void init(String ... parameters) {
        label = parameters[0];
    }
}
