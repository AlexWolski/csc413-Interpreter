package interpreter.bytecode.operator;

public class orOp extends Operator {
    public int execute(int value1, int value2) {
        return value1 | value2;
    }
}