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

    private int safeFramePeek(String errorMessage) {
        if(framePointer.size() == 0)
            throw new ArrayIndexOutOfBoundsException(errorMessage + ", there are no frames.");

        return framePointer.peek();
    }

    public void dump() {

    }

    public int peek() {
        if(runStack.size() + 1 == safeFramePeek("Can't PEEK"))
            throw new ArrayIndexOutOfBoundsException("Can't PEEK, the frame is empty.");

        return runStack.get(getLastStackIndex());
    }

    public int pop() {
        if(runStack.size() + 1 == safeFramePeek("Can't POP"))
            throw new ArrayIndexOutOfBoundsException("Can't POP, the frame is empty");

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
        if(runStack.size() - offset + 1 < safeFramePeek("Can't add NEW FRAME"))
            throw new ArrayIndexOutOfBoundsException("Can't add NEW FRAME, the target location is out of bounds.");

        framePointer.add(runStack.size());
    }

    public void popFrame() {
        if(framePointer.size() == 0)
            throw new ArrayIndexOutOfBoundsException("Can't POP FRAME, there are no more frames.");

        int oldFrame = framePointer.pop();
        Integer returnValue = runStack.get(getLastStackIndex());

        while(runStack.size() > oldFrame)
            runStack.remove(getLastStackIndex());

        runStack.add(returnValue);
    }

    public int store(int offset) {
        int index = safeFramePeek("Can't STORE") + offset;

        if(index > runStack.size())
            throw new ArrayIndexOutOfBoundsException("Can't STORE, the target index is outside of the stack.");

        Integer value = runStack.get(getLastStackIndex());
        runStack.set(index, value);
        runStack.remove(getLastStackIndex());

        return value;
    }

    public int load(int offset) {
        int index = safeFramePeek("Can't LOAD") + offset;

        if(index > runStack.size())
            throw new ArrayIndexOutOfBoundsException("Can't LOAD, the target index is outside of the stack.");

        Integer value = runStack.get(index - 1);
        runStack.add(value);

        return value;
    }
}