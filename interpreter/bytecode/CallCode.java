package interpreter.bytecode;

import interpreter.VirtualMachine;

public class CallCode extends JumpByteCode {
    private String label;
    private String cleanedLabel;
    private int address;
    private Integer[] arguments;

    @Override
    public void init(String ... parameters) {
        label = parameters[0];
        cleanedLabel = cleanLabel(label);
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
        arguments = vm.getTopFrame();
    }

    @Override
    public String toString() {
        String output = "CALL " + cleanedLabel + "   " + cleanedLabel + "(";

        for(int i = 0; i < arguments.length; i++) {
            if(i != 0)
                output += ",";

            output +=arguments[i];
        }

        return output + ")";
    }
}