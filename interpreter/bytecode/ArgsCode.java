package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ArgsCode extends ByteCode {
    private int numArgs;

    public void init(String ... parameters) {
        if(parameters.length < 1)
            throw new NumberFormatException("Invalid Syntax: ARGS takes 1 argument.");

        try {
            numArgs = ByteCode.toInt(parameters[0]);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Syntax: ARGS takes an integer.");
        }
    }

    public void execute(VirtualMachine vm) {
    }
}