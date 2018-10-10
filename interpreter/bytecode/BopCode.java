package interpreter.bytecode;

import interpreter.VirtualMachine;
import interpreter.bytecode.operator.Operator;

public class BopCode extends ByteCode {
    private Operator operator;

    static {
        OperatorTable.init();
    }

    public void init(String ... parameters) {
        try {
            Class operatorClass = Class.forName("interpreter.bytecode.operator." + OperatorTable.getClassName(parameters[0]));
            operator = (Operator) operatorClass.getDeclaredConstructor().newInstance();
        }
        catch (Exception e) {
            throw new RuntimeException(parameters[0] + " is not a valid operator.");
        }
    }

    public void execute(VirtualMachine vm) {
        int value2 = vm.pop();

        vm.push(operator.execute(vm.pop(), value2));
    }
}