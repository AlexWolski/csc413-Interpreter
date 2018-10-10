package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ArgsCode extends ByteCode {
    private int numArgs;

    public void init(String ... parameters) {
        try {
            numArgs = ByteCode.toInt(parameters[0]);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Syntax: ARGS takes an integer.");
        }
    }

    public void execute(VirtualMachine vm) {
        vm.newFrameAt(numArgs);
    }
}