package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {
    private String label;
    private String cleanedLabel;

    @Override
    public void init(String ... parameters) {
        if(parameters.length > 0)
            label = parameters[0];
    }

    @Override
    public void execute(VirtualMachine vm) {
        int returnValue = vm.pop();
        vm.popFrame();
        vm.push(returnValue);
        vm.setPc(vm.popReturnAddress());
    }

    @Override
    public String toString() {
        String output = "RETURN " + cleanedLabel;

        if(true) {
            output += ("  exit " + cleanedLabel + ":");
        }

        return output;
    }
}