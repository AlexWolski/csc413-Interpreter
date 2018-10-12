package interpreter.bytecode;

import interpreter.VirtualMachine;
import interpreter.bytecode.operator.Operator;

public class BopCode extends ByteCode {
    private String operatorSymbol;
    private Operator operator;

    static {
        OperatorTable.init();
    }

    @Override
    public void init(String ... parameters) {
        try {
            operatorSymbol = parameters[0];
            Class operatorClass = Class.forName("interpreter.bytecode.operator." + OperatorTable.getClassName(operatorSymbol));
            operator = (Operator) operatorClass.getDeclaredConstructor().newInstance();
        }
        catch (Exception e) {
            throw new RuntimeException(parameters[0] + " is not a valid operator.");
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        int value2 = vm.pop();

        vm.push(operator.execute(vm.pop(), value2));
    }

    @Override
    public String toString() {
        return ("BOP " + operatorSymbol);
    }
}