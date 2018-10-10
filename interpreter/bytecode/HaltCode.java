package interpreter.bytecode;

import interpreter.VirtualMachine;

public class HaltCode extends ByteCode {
    public void execute(VirtualMachine vm) {
        vm.stopProgram();
    }
}