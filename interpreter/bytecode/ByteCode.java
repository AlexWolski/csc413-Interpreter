package interpreter.bytecode;

public class ByteCode {
    protected static int toInt(String numberString) {
        //Exception handled by concrete ByteCode class and ByteCodeLoader
        return Integer.parseInt(numberString);
    }
}
