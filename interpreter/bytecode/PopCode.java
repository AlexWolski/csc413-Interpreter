package interpreter.bytecode;

public class PopCode {
    int numToPop;

    public void init(String ... parameters) {
        try {
            numToPop = ByteCode.toInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Syntax: POP takes an integer.");
        }
    }
}
