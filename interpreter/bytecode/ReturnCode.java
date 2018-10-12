package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {
    private String label;
    private String cleanedLabel = null;
    private int returnValue;

    @Override
    public void init(String ... parameters) {
        if(parameters.length > 0) {
            label = parameters[0];
            cleanedLabel = cleanLabel(label);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        returnValue = vm.pop();
        vm.popFrame();
        vm.push(returnValue);
        vm.setPc(vm.popReturnAddress());
    }

    @Override
    public String toString() {
        if(cleanedLabel == null)
            return "RETURN";

        return "RETURN " + cleanedLabel + "  exit " + cleanedLabel + ": "+ returnValue;
    }
}