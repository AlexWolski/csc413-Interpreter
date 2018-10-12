package interpreter.bytecode;

import interpreter.VirtualMachine;

public class PopCode extends ByteCode {
    private int numToPop;

    @Override
    public void init(String ... parameters) {
        try {
            numToPop = ByteCode.toInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Syntax: POP takes an integer.");
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        int upperBound;

        if(numToPop < vm.getFrameSize())
            upperBound = vm.getFrameSize();
        else
            upperBound = numToPop;

        for (int numPoppsed = 0; numPoppsed < upperBound; numPoppsed++)
            vm.pop();
    }


    @Override
    public String toString() {
        return ("POP " + numToPop);
    }
}