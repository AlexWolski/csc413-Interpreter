package interpreter.bytecode;

public class LabelCode extends ByteCode {
    String label;

    public void init(String[] parameters) {
        label = parameters[0];
    }

    public void execute() {
    }
}