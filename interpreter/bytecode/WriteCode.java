package interpreter.bytecode;

import interpreter.VirtualMachine;

public class WriteCode extends ByteCode {
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peek());
    }
}