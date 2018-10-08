package interpreter.bytecode;

public class LitCode extends ByteCode {
    int value;

    public void init(String ... parameters) {
        try {
            value = ByteCode.toInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Syntax: LIT takes an integer.");
        }
    }

    public void execute() {
    }
}