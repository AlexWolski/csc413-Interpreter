package interpreter.bytecode;

import interpreter.VirtualMachine;

public class PopCode extends ByteCode {
    private int numToPop;

    public void init(String ... parameters) {
        try {
            numToPop = ByteCode.toInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Syntax: POP takes an integer.");
        }
    }

    public void execute(VirtualMachine vm) {
        for(int numPoppsed = 0; numPoppsed < numToPop; numPoppsed++)
            vm.pop();
    }
}