package interpreter.bytecode.operator;

public class andOp extends Operator {
    public int execute(int value1, int value2) {
        return value1 & value2;
    }
}