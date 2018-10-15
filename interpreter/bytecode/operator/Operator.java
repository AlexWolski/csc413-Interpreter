package interpreter.bytecode.operator;

//Abstract class for all operators
public abstract class Operator {
    //Take two values and return the result of that operator
    public abstract int execute(int value1, int value2);

    //Take a boolean and return 1 if the boolean is true, or 0 if the boolean is false
    protected int boolToInt(boolean value) {
        if(value)
            return 1;

        return 0;
    }
}
