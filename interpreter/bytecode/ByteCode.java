package interpreter.bytecode;

public abstract class ByteCode {
    public void init(String ... parameters) { }

    public void execute() { }

    protected static int toInt(String numberString) {
        //Exception handled by concrete ByteCode class and ByteCodeLoader
        return Integer.parseInt(numberString);
    }
}