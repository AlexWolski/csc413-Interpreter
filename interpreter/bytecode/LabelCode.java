package interpreter.bytecode;

public class LabelCode extends JumpByteCode {
    private String label;

    public void init(String ... parameters) {
        if(parameters.length < 1)
            throw new NumberFormatException("Invalid Syntax: LABEL takes 1 argument.");

        label = parameters[0];
    }

    public String getLabel() {
        return label;
    }
}