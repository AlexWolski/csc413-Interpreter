package interpreter.bytecode;

public class LoadCode {
    int index;

    public void init(String ... parameters) {
        try {
            index = ByteCode.toInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Syntax: LOAD takes an integer.");
        }
    }
}