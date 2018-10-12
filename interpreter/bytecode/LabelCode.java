package interpreter.bytecode;

public class LabelCode extends JumpByteCode {
    private String label;

    @Override
    public void init(String ... parameters) {
        label = parameters[0];
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return ("LABEL " + label);
    }
}