package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean isDumping;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    void executeProgram() {
        isRunning = true;
        isDumping = true;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<>();
        pc = 0;

        ByteCode currCode;

        while(isRunning) {
            try {
                currCode = program.getCode(pc);

                if (isDumping) {
                    //System.out.println(currCode.toString());
                    currCode.execute(this);
                    runStack.dump();
                }
                else
                    currCode.execute(this);

            } catch(Exception e) {
                //Ignore all errors thrown by the runtime stack, don't stop the program
                System.out.println("error");
            }

            pc++;
        }
    }

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

    public int getFrameSize() {
        return runStack.getFrameSize();
    }

    public void popFrame() {
        runStack.popFrame();
    }

    public void pushReturnAddress(int address) {
        returnAddrs.push(address);
    }

    public int popReturnAddress() {
       return returnAddrs.pop();
    }
}
