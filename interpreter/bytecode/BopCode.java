package interpreter.bytecode;

public class BopCode extends ByteCode {
    String operator;

    public void init(String[] parameters) {
        operator = parameters[0];
    }

    public void execute() {
    }
}