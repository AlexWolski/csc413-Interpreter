package interpreter.bytecode;

import interpreter.VirtualMachine;

public class FalseBranchCode extends JumpByteCode {
    private String label;
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
        if(vm.pop() == 0)
            vm.setPc(address);
    }

    @Override
    public String toString() {
        return ("FALSEBRANCH " + label);
    }
}