package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.JumpByteCode;
import interpreter.bytecode.LabelCode;

import java.util.ArrayList;
import java.util.HashMap;


public class Program {
    private ArrayList<ByteCode> program;
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

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @ param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs() {
        for(ByteCode currByteCode : program) {
            if(currByteCode instanceof JumpByteCode)
                ((JumpByteCode) currByteCode).setAddress(addresses.get(((JumpByteCode) currByteCode).getLabel()));
        }
    }
}