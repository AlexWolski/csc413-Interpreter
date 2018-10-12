package interpreter.bytecode;

import interpreter.VirtualMachine;

public abstract class ByteCode {
    public void init(String ... parameters) { }
    public void execute(VirtualMachine vm) { }

    @Override
    public String toString() { return ""; }

    static int toInt(String numberString) {
        //Exception handled by concrete ByteCode class and ByteCodeLoader
        return Integer.parseInt(numberString);
    }

    static String cleanLabel(String label) {
        return label;
    }
}