package interpreter;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    void executeProgram() {
        isRunning = true;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<>();
        pc = 0;

        while(isRunning) {
            program.getCode(pc).execute(this);
            pc++;
        }
    }

    public void stopProgram() {
        this.isRunning = false;
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
