package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LitCode extends ByteCode {
    private int value;
    private String variableName;

    @Override
    public void init(String ... parameters) {
        try {
            value = ByteCode.toInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Syntax: LIT takes an integer.");
        }

        if(parameters.length > 1)
            variableName = parameters[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.push(value);
    }

    @Override
    public String toString() {
        String output = "LIT " + value;

        if(variableName != null)
            output = output + " " + variableName + "   int " + variableName;

        return output;
    }
}