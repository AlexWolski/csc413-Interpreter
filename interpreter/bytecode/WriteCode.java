package interpreter.bytecode;

import interpreter.VirtualMachine;

public class WriteCode extends ByteCode {
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peek());
    }

    @Override
    public String toString() {
        return "WRITE";
    }
}