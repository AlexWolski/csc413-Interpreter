package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LoadCode extends ByteCode {
    private int offset;
    private String variableName;

    @Override
    public void init(String ... parameters) {
        try {
            offset = ByteCode.toInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Syntax: LOAD takes an integer.");
        }

        if(parameters.length > 1)
            variableName = parameters[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.load(offset);
    }

    @Override
    public String toString() {
        return ("LOAD " + offset + " " + variableName);
    }
}