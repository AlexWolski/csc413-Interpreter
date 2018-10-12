package interpreter.bytecode;

import interpreter.VirtualMachine;

public class HaltCode extends ByteCode {
    @Override
    public void execute(VirtualMachine vm) {
        vm.stopProgram();
    }

    @Override
    public String toString() {
        return ("HALT");
    }
}