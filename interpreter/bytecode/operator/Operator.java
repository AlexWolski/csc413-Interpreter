package interpreter.bytecode.operator;

public abstract class Operator {
    public abstract int execute(int value1, int value2);

    protected int boolToInt(boolean value) {
        if(value)
            return 1;

        return 0;
    }
}
