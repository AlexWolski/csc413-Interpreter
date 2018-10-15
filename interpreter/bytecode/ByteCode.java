package interpreter.bytecode;

import interpreter.VirtualMachine;

//Abstract class for all ByteCodes
public abstract class ByteCode {
    //Take an array of strings to initialize the ByteCode
    public void init(String ... parameters) { }
    //Run the operations for the ByteCode
    public void execute(VirtualMachine vm) { }

    //Put important data from the ByteCode into a string and return it
    @Override
    public String toString() { return ""; }

    //Take a string and convert it to an integer
    protected static int toInt(String numberString) {
        //Exception handled by the children ByteCode classes
        return Integer.parseInt(numberString);
    }

    //Take a label and remove any brackets ('<' and '>') and any numbers in between the brackets ('<#>')
    protected static String cleanLabel(String label) {
        //Build a new string for the label excluding brackets
        StringBuilder cleanedLabel = new StringBuilder();
        char prevChar;
        char currChar = '\0';

        for(int i = 0; i < label.length(); i++) {
            prevChar = currChar;
            currChar = label.charAt(i);

            //If the character is last in the string, add it to the new label if it isn't a bracket
            //If the character is not last, add it if it is not a bracket and if it is not surrounded by brackets
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