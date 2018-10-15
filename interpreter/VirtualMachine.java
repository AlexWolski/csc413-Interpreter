package interpreter;

import interpreter.bytecode.ByteCode;
import java.util.Stack;

//Loops through the ByteCodes and execute the program
public class VirtualMachine {

    //runStack object to manage the program's memory
    private RunTimeStack runStack;
    //List of return addresses for functions calls
    private Stack<Integer> returnAddrs;
    //Program object to store all of the ByteCodes
    private Program program;
    //Integer to loop through the ArrayList of ByteCodes
    private int pc;
    //Booleans to control if the program is running and if the program is printing its status
    private boolean isRunning;
    private boolean isDumping;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    void executeProgram() {
        isRunning = true;
        isDumping = false;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<>();
        pc = 0;

        ByteCode currCode;

        //Keep looping and executing ByteCodes
        while(isRunning) {
            try {
                currCode = program.getCode(pc);
                currCode.execute(this);

                if (isDumping) {
                    System.out.println(currCode.toString());
                    runStack.dump();
                }

            } catch(Exception e) {
                //If there is an error, print it to the console. But don't stop the program.
                System.out.println(e.getMessage());
            }

            pc++;
        }
    }

    /**Methods for VirtualMachine*/

    public void stopProgram() {
        this.isRunning = false;
    }

    public void setDumping (boolean dumpCode) {
        isDumping = dumpCode;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int newPc) {
        pc = newPc;
    }

    public void pushReturnAddress(int address) {
        returnAddrs.push(address);
    }

    public int popReturnAddress() {
        return returnAddrs.pop();
    }

    /**Methods to call other methods in the runStack*/

    public int peek() {
        return runStack.peek();
    }

    public int pop() {
        return runStack.pop();
    }

    public int push(int value) {
        return runStack.push(value);
    }

    public int load(int offset) {
        return runStack.load(offset);
    }

    public int store(int offset) {
        return runStack.store(offset);
    }

    public void newFrameAt(int offset) {
        runStack.newFrameAt(offset);
    }

    public int getTopFrameSize() {
        return runStack.getTopFrameSize();
    }

    public Integer[] getTopFrame() {
        return runStack.getTopFrame();
    }

    public void popFrame() {
        runStack.popFrame();
    }
}