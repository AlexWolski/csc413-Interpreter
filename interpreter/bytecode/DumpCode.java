package interpreter.bytecode;

import com.sun.corba.se.impl.io.TypeMismatchException;
import interpreter.VirtualMachine;

public class DumpCode extends ByteCode {
    private boolean dumpCode;

    @Override
    public void init(String ... parameters) {
        if (parameters[0].equals("ON"))
            dumpCode = true;
        else if (parameters[0].equals("OFF"))
            dumpCode = false;
        else
            throw new TypeMismatchException("Invalid Syntax: DUMP takes \"ON\" or \"OFF\".");
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setDumping(dumpCode);
    }
}