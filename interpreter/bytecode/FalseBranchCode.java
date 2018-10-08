package interpreter.bytecode;

import interpreter.VirtualMachine;

public class FalseBranchCode extends JumpByteCode {
    private String label;
    private int address;

    public void init(String ... parameters) {
        if(parameters.length < 1)
            throw new NumberFormatException("Invalid Syntax: ARGS takes 1 argument.");

        label = parameters[0];
    }

    public void execute(VirtualMachine vm) {
    }

    public String getLabel() {
        return label;
    }

    public void setAddress(int resolvedAddress) {
        address = resolvedAddress;
    }
}