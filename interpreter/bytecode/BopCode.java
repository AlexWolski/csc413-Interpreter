package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopCode extends ByteCode {
    private String operator;

    public void init(String ... parameters) {
        operator = parameters[0];
    }

    public void execute(VirtualMachine vm) {
    }
}