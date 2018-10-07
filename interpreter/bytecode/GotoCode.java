package interpreter.bytecode;

public class GotoCode extends ByteCode {
    String label;
    int resolvedAddress;

    public void init(String[] parameters) {
        label = parameters[0];
    }

    public void execute() {
    }
}