package interpreter.bytecode;

import com.sun.corba.se.impl.io.TypeMismatchException;

public class DumpCode extends ByteCode {
    boolean dumpCode;

    public void init(String ... parameters) {
        if(parameters[0].equals("ON"))
            dumpCode = true;
        else if(parameters[0].equals("OFF"))
            dumpCode = false;
        else
            throw new TypeMismatchException("Invalid Syntax: DUMP only takes \"ON\" or \"OFF\".");
    }

    public void execute() {
    }
}