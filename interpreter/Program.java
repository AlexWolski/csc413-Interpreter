package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.JumpByteCode;
import interpreter.bytecode.LabelCode;
import java.util.ArrayList;
import java.util.HashMap;

//Stores the ByteCodes for the program
public class Program {
    //Holds all of the ByteCodes
    private ArrayList<ByteCode> program;
    //Temporary HashMap for resolving addresses. The key is the Label and the value is the index that label ByteCode is in.
    private HashMap<String, Integer> addresses;

    public Program() {
        program = new ArrayList<>();
        addresses = new HashMap<>();
    }

    public int getSize() {
        return this.program.size();
    }

    public ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public void addCode(ByteCode newByteCode) {
        if (newByteCode instanceof LabelCode)
            addresses.put(((LabelCode) newByteCode).getLabel(), program.size());

        program.add(newByteCode);
    }

    //Resolve the addresses of any ByteCodes that holds a label. Get the index by giving the HashMap the label.
    public void resolveAddrs() {
        for(ByteCode currByteCode : program) {
            if(currByteCode instanceof JumpByteCode)
                ((JumpByteCode) currByteCode).setAddress(addresses.get(((JumpByteCode) currByteCode).getLabel()));
        }
    }
}