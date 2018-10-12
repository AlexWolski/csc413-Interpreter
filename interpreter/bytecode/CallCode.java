package interpreter.bytecode;

import interpreter.VirtualMachine;

public class CallCode extends JumpByteCode {
    private String label;
    private String cleanedLabel;
    private int address;

    @Override
    public void init(String ... parameters) {
        label = parameters[0];
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setAddress(int resolvedAddress) {
        address = resolvedAddress;
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAddress(vm.getPc());
        vm.setPc(address);
    }

    @Override
    public String toString() {
        return ("CALL " + cleanedLabel + "   " + cleanedLabel + "(" + ")");
    }
}