package interpreter.bytecode;

public class StoreCode extends ByteCode {
    int index;

    public void init(String[] parameters) {
        try {
            index = ByteCode.toInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Syntax: STORE takes an integer.");
        }
    }

    public void execute() {
    }
}