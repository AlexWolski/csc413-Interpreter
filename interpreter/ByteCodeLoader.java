package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.HaltCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


class ByteCodeLoader extends Object {

    private BufferedReader byteSource;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    ByteCodeLoader(String file) throws IOException {
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
    Program loadCodes() {
        Program xProgram = new Program();
        ByteCode byteObject;

        try {
            while (byteSource.ready()) {
                String parsedString[] = byteSource.readLine().split(" ", -1);
                Class byteClass = Class.forName("interpreter.bytecode." + CodeTable.getClassName(parsedString[0]));

                try {
                    byteObject = (ByteCode) byteClass.getDeclaredConstructor().newInstance();

                    if(parsedString.length != 1)
                        byteObject.init(Arrays.copyOfRange(parsedString, 1, parsedString.length));
                } catch (SecurityException e) {
                    throw new SecurityException(parsedString[0] + " is not a valid bytecode.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new ArrayIndexOutOfBoundsException(parsedString[0] + " needs more than " + (parsedString.length - 1) + " arguments.");
                }

                xProgram.addCode(byteObject);
            }

            byteSource.close();
            xProgram.resolveAddrs();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            xProgram = new Program();
            xProgram.addCode(new HaltCode());
        }

        return xProgram;
    }
}