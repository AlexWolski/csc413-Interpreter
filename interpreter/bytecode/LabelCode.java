package interpreter.bytecode;

public class LabelCode extends JumpByteCode {
    private String label;

    public void init(String ... parameters) {
        label = parameters[0];
    }

    public String getLabel() {
        return label;
    }
}