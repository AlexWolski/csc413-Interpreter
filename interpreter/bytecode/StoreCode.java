package interpreter.bytecode;

import interpreter.VirtualMachine;

public class StoreCode extends ByteCode {
    private int index;
    private String variableName;

    public void init(String ... parameters) {
        try {
            index = ByteCode.toInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Syntax: STORE takes an integer.");
        }

        if(parameters.length > 1)
            variableName = parameters[1];
    }

    public void execute(VirtualMachine vm) {
    }
}