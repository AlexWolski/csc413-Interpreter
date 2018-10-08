package interpreter.bytecode;

public class ArgsCode extends ByteCode {
    int numArgs;

    public void init(String ... parameters) {
        try {
            numArgs = ByteCode.toInt(parameters[0]);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Syntax: ARGS takes an integer.");
        }
    }

    public void execute() {
    }
}