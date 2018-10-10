package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {
    private ArrayList<Integer> runStack;
    private Stack<Integer> framePointer;

    RunTimeStack() {
        runStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    private int getLastStackIndex() {
        return runStack.size()-1;
    }

    public void dump() {

    }

    public int peek() {
        if(runStack.size() == 0)
            throw new ArrayIndexOutOfBoundsException("Can't PEEK, the stack is empty.");

        return runStack.get(getLastStackIndex());
    }

    public int pop() {
        if(runStack.size() == 0)
            throw new ArrayIndexOutOfBoundsException("Can't POP, the stack is empty.");

        Object value = runStack.get(getLastStackIndex());
        runStack.remove(getLastStackIndex());

        return (int)value;
    }

    public int push(int val) {
        runStack.add(val);
        return val;
    }

    public Integer push(Integer val) {
        runStack.add(val);
        return val;
    }

    public void newFrameAt(int offset) {
        if(runStack.size() < framePointer.peek())
            throw new ArrayIndexOutOfBoundsException("Can't add NEW FRAME, the target location is out of bounds.");

        framePointer.add(runStack.size());
    }

    public void popFrame() {
        if(runStack.size() == framePointer.peek())
            throw new ArrayIndexOutOfBoundsException("Can't POP FRAME, there is no return value.");

        if(runStack.size() > framePointer.peek())
            throw new ArrayIndexOutOfBoundsException("Can't POP FRAME, there is more than one return value.");

        Integer returnValue = runStack.get(getLastStackIndex());
        int oldFrame = framePointer.pop();

        while(runStack.size() > oldFrame)
            runStack.remove(getLastStackIndex());

        runStack.add(returnValue);
    }

    public int store(int offset) {
        int index = framePointer.peek() + offset;

        if(index > runStack.size())
            throw new ArrayIndexOutOfBoundsException("Can't STORE, the target value is outside of the stack.");

        Integer value = runStack.get(getLastStackIndex());
        runStack.set(index, value);
        runStack.remove(getLastStackIndex());

        return value;
    }

    public int load(int offset) {
        int index = framePointer.peek() + offset;

        if(index > runStack.size())
            throw new ArrayIndexOutOfBoundsException("Can't LOAD, the target value is outside of the stack.");

        Integer value = runStack.get(index);
        runStack.add(value);

        return value;
    }
}