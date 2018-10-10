package interpreter.bytecode;

import java.util.Scanner;
import interpreter.VirtualMachine;

public class ReadCode extends ByteCode {
    public void execute(VirtualMachine vm) {
        Scanner sc = new Scanner(System.in);
        String input;
        int value;

        System.out.println("Enter a positive integer: ");

        while(true) {
            input = sc.next();

            try {
                value = Integer.valueOf(input);
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("That is not an integer. Enter an integer: ");
            }
        }

        vm.push(value);
    }
}