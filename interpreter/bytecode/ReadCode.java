package interpreter.bytecode;

import java.util.Scanner;
import interpreter.VirtualMachine;

public class ReadCode extends ByteCode {
    @Override
    public void execute(VirtualMachine vm) {
        Scanner sc = new Scanner(System.in);
        String input;
        int value;

        System.out.print("Enter an integer: ");

        while(true) {
            input = sc.next();

            try {
                value = Integer.valueOf(input);
                break;
            }
            catch (NumberFormatException e) {
                System.out.print("That is not an integer. Enter an integer: ");
            }
        }

        vm.push(value);
    }

    @Override
    public String toString() {
        return "READ";
    }
}