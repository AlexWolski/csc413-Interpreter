package interpreter.bytecode.operator;

public class equalsOp extends Operator {
    public int execute(int value1, int value2) {
        return boolToInt(value1 == value2);
    }
}