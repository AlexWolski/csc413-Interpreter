package interpreter.bytecode;

import interpreter.VirtualMachine;

public class CallCode extends JumpByteCode {
    private String label;
    private int address;

    public void init(String ... parameters) {
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