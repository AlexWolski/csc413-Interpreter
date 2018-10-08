package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LoadCode extends ByteCode {
    private int index;

    public void init(String ... parameters) {
        if(parameters.length < 1)
            throw new NumberFormatException("Invalid Syntax: LOAD takes 1 argument.");

        try {
            index = ByteCode.toInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Syntax: LOAD takes an integer.");
        }
    }

    public void execute(VirtualMachine vm) {
    }
}