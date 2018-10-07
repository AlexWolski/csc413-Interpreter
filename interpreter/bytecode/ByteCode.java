package interpreter.bytecode;

public abstract class ByteCode {
    public abstract void init(String ... parameters);

    public abstract void execute();

    protected static int toInt(String numberString) {
        //Exception handled by concrete ByteCode class and ByteCodeLoader
        return Integer.parseInt(numberString);
    }
}