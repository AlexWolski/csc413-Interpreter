package interpreter.bytecode;

import interpreter.VirtualMachine;

public abstract class ByteCode {
    public void init(String ... parameters) { }
    public void execute(VirtualMachine vm) { }

    @Override
    public String toString() { return ""; }

    static int toInt(String numberString) {
        //Exception handled by concrete ByteCode class and ByteCodeLoader
        return Integer.parseInt(numberString);
    }

    static String cleanLabel(String label) {
        StringBuilder cleanedLabel = new StringBuilder();
        char prevChar;
        char currChar = '\0';

        for(int i = 0; i < label.length(); i++) {
            prevChar = currChar;
            currChar = label.charAt(i);

            if(i == label.length() - 1) {
                if (currChar != '<' && currChar != '>')
                    cleanedLabel.append(currChar);
            } else if(prevChar != '<' && label.charAt(i + 1) != '>' &&
                      currChar != '<' && currChar != '>')
                cleanedLabel.append(currChar);
        }

        return cleanedLabel.toString();
    }
}