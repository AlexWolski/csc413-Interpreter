package interpreter.bytecode;

import interpreter.VirtualMachine;

public class PopCode extends ByteCode {
    private int numToPop;

    public void init(String ... parameters) {
        if(parameters.length < 1)
            throw new NumberFormatException("Invalid Syntax: POP takes 1 argument.");

        try {
            numToPop = ByteCode.toInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Syntax: POP takes an integer.");
        }
    }

    public void execute(VirtualMachine vm) {
    }
}