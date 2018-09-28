package interpreter.bytecode;

public class BopCode {
    String operator;

    public void init(String ... parameters) {
        operator = parameters[0];
    }
}
