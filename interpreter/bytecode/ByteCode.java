package interpreter.bytecode;

import interpreter.VirtualMachine;

public abstract class ByteCode {
    public void init(String ... parameters) { }

    public void execute(VirtualMachine vm) { }

    protected static int toInt(String numberString) {
        //Exception handled by concrete ByteCode class and ByteCodeLoader
        return Integer.parseInt(numberString);
    }
}