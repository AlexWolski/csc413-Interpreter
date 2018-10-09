package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {
    private String label;

    public void init(String ... parameters) {
        if(parameters.length > 0)
            label = parameters[0];
    }

    public void execute(VirtualMachine vm) {
    }
}