package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.HaltCode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//Reads a .x file and converts it into ByteCodes
class ByteCodeLoader extends Object {

    private BufferedReader byteSource;

    //Simply create a new BufferedReader from the given file.
    //If the file can't be opened, throw an exception. This exception will be caught in Interpreter.java
    public ByteCodeLoader(String file) throws IOException {
        byteSource = new BufferedReader(new FileReader(file));
    }

    //Reads the file, constructs a ByteCode object for each line, initializes it, and puts it in the program array list
    public Program loadCodes() {
        Program xProgram = new Program();
        ByteCode byteObject;

        try {
            //While there are still more BytesCodes in the file, keep looking
            while (byteSource.ready()) {
                //Read the line and split it into array on every space
                String parsedString[] = byteSource.readLine().split(" ", -1);
                //Look up the class name given the ByteCode and create a Java class for that ByteCode
                Class byteClass = Class.forName("interpreter.bytecode." + CodeTable.getClassName(parsedString[0]));

                try {
                    //Get the default constructor for the Java class and create a new instance
                    byteObject = (ByteCode) byteClass.getDeclaredConstructor().newInstance();

                    //If there are parameters, make a new array excluding the ByteCode and use it to initialize the ByteCode
                    if(parsedString.length != 1)
                        byteObject.init(Arrays.copyOfRange(parsedString, 1, parsedString.length));
                  //If the ByteCode can't be found in the hash map, raise an exception
                } catch (SecurityException e) {
                    throw new SecurityException(parsedString[0] + " is not a valid bytecode.");
                  //If there aren't enough parameters, raise an exception
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new ArrayIndexOutOfBoundsException(parsedString[0] + " needs more than " + (parsedString.length - 1) + " arguments.");
                }

                //Add the ByteCode to the program ArrayList
                xProgram.addCode(byteObject);
            }

            //Close the BufferedReader and resolve
            byteSource.close();
            xProgram.resolveAddrs();

          //If there were any exceptions, halt the program
        } catch (Exception e) {
            System.out.println(e.getMessage());
            xProgram = new Program();
            xProgram.addCode(new HaltCode());
        }

        //Return the program
        return xProgram;
    }
}