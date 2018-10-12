package interpreter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        StringBuilder stackString = new StringBuilder();

        for(int i = 0; i < framePointer.size(); i++) {

            if(i != 0)
                stackString.append(" ");

            stackString.append("[");

            if(i < framePointer.size() - 1) {
                for (int j = framePointer.get(i); j < framePointer.get(i + 1); j++) {
                    stackString.append(runStack.get(j));

                    if(j != framePointer.get(i + 1) - 1)
                        stackString.append(",");
                }
            }
            else {
                for (int j = framePointer.get(i); j < runStack.size(); j++) {
                    stackString.append(runStack.get(j));

                    if(j != runStack.size() - 1)
                        stackString.append(",");
                }
            }

            stackString.append("]");
        }

        System.out.println(stackString.toString());
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
        if(runStack.size() - offset < safeFramePeek("Can't add NEW FRAME"))
            throw new ArrayIndexOutOfBoundsException("Can't add NEW FRAME, the target location is out of bounds.");

        framePointer.add(runStack.size() - offset);
    }

    public int getTopFrameSize() {
        if(framePointer.isEmpty())
            return -1;

        return runStack.size() - framePointer.get(framePointer.size() - 1);
    }

    public Integer[] getTopFrame() {
        if(getTopFrameSize() < 0)
            return null;

        Integer[] frame = Arrays.copyOf(runStack.toArray(), runStack.size(), Integer[].class);

        return Arrays.copyOfRange(frame, framePointer.peek(), runStack.size());
    }

    public void popFrame() {
        if(framePointer.size() == 0)
            throw new ArrayIndexOutOfBoundsException("Can't POP FRAME, there are no more frames.");

        int oldFrame = framePointer.pop();

        while(runStack.size() > oldFrame)
            runStack.remove(getLastStackIndex());
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

        Integer value = runStack.get(index);
        runStack.add(value);

        return value;
    }
}