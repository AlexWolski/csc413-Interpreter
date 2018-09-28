package interpreter.bytecode;

import com.sun.corba.se.impl.io.TypeMismatchException;

public class DumpCode {
    boolean dumpCode;

    public void init(String ... parameters) {
        if(parameters[0] == "ON")
            dumpCode = true;
        else if(parameters[0] == "OFF")
            dumpCode = false;
        else
            throw new TypeMismatchException("Invalid Syntax: DUMP only takes \"ON\" or \"OFF\".");
    }
}