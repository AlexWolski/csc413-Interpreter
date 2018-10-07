
package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.HaltCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        Program xProgram = new Program();
        Class c;
        ByteCode bc;

        try {
            while (byteSource.ready()) {
                String test[] = byteSource.readLine().split(" ", -1);
                c = Class.forName("interpreter.bytecode." + CodeTable.getClassName(test[0]));

                try {
                    bc = (ByteCode) c.getDeclaredConstructor().newInstance();

                    if(test.length != 1)
                        bc.init(Arrays.copyOfRange(test, 1, test.length));
                } catch (SecurityException e) {
                    throw new SecurityException(test[0] + " is not a valid bytecode.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new ArrayIndexOutOfBoundsException(test[0] + " needs more than " + (test.length - 1) + " arguments.");
                }

                xProgram.addCode(bc);
            }

            byteSource.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            xProgram = new Program();
            xProgram.addCode(new HaltCode());
        }

        return xProgram;
    }
}