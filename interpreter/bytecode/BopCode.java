package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopCode extends ByteCode {
    private String operator;

    public void init(String ... parameters) {
        if(parameters.length < 1)
            throw new NumberFormatException("Invalid Syntax: BOP takes 1 argument.");

        operator = parameters[0];
    }

    public void execute(VirtualMachine vm) {
    }
}