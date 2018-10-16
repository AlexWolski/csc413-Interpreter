package interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//Manages the RunTimeStack for the program
public class RunTimeStack {
    //Acts as a stack for the program's memory
    private ArrayList<Integer> runStack;
    //Stores the locations of frames in runStack
    private Stack<Integer> framePointer;

    /**Methods for whole RunTimeStack class*/

    public RunTimeStack() {
        runStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    //Convert the specified frame into a string and return it
    public String frameToString(int frame) {
        StringBuilder stackString = new StringBuilder();
        int upperBound;

        stackString.append("[");

        //If the specified frame is not the last frame, loop until the next frame. If it is the last string, loop until the end of runStack
        if(frame < framePointer.size() - 1)
            upperBound = framePointer.get(frame + 1);
        else
            upperBound = runStack.size();

        //Append the values of the stack to the output string
        for (int j = framePointer.get(frame); j < upperBound; j++) {
            stackString.append(runStack.get(j));

            //If the value is not the last value in the stack, follow it by a comma
            if(j != upperBound - 1)
                stackString.append(",");
        }

        stackString.append("]");

        return stackString.toString();
    }

    //Print all of the frames in runStack
    public void dump() {
        StringBuilder stackString = new StringBuilder();

        //Keep looping and appending each frame
        for(int i = 0; i < framePointer.size(); i++) {
            //If the frame is not the first frame, put a space before it
            if(i != 0)
                stackString.append(" ");

            stackString.append(frameToString(i));
        }

        System.out.println(stackString.toString());
    }

    /**Methods for runStack*/

    //Return the last index in the runStack
    private int getLastStackIndex() {
        return runStack.size()-1;
    }

    //Return the top value of the runStack
    public int peek() {
        if(runStack.size() <= peekFrame("Can't PEEK"))
            throw new ArrayIndexOutOfBoundsException("Can't PEEK, the frame is empty.");

        return runStack.get(getLastStackIndex());
    }

    //Return and remove the top value of the runStack
    public int pop() {
        if(runStack.size() <= peekFrame("Can't POP"))
            throw new ArrayIndexOutOfBoundsException("Can't POP, the frame is empty");

        Object value = runStack.get(getLastStackIndex());
        runStack.remove(getLastStackIndex());

        return (int)value;
    }

    //Add the given int to the runStack
    public int push(int val) {
        runStack.add(val);
        return val;
    }

    //Add the given Integer to the runStack
    public Integer push(Integer val) {
        runStack.add(val);
        return val;
    }

    //Pop the top value in the runStack and store it a given offset from the bottom of the frame
    public int store(int offset) {
        int index = peekFrame("Can't STORE") + offset;

        if(index > runStack.size())
            throw new ArrayIndexOutOfBoundsException("Can't STORE, the target index is outside of the stack.");

        int value = pop();
        runStack.set(index, value);

        return value;
    }

    //Take a value from a given offset from the bottom of the frame and add a cope to the top
    public int load(int offset) {
        int index = peekFrame("Can't LOAD") + offset;

        if(index > runStack.size())
            throw new ArrayIndexOutOfBoundsException("Can't LOAD, the target index is outside of the stack.");

        int value = runStack.get(index);
        runStack.add(value);

        return value;
    }

    /**Methods for framePointer*/

    //Create a new frame at a given offset below the top of the runStack
    public void newFrameAt(int offset) {
        if(runStack.size() - offset < peekFrame("Can't add NEW FRAME"))
            throw new ArrayIndexOutOfBoundsException("Can't add NEW FRAME, the target location is out of bounds.");

        framePointer.add(runStack.size() - offset);
    }

    //Return the size of the top frame
    public int getTopFrameSize() {
        if(framePointer.isEmpty())
            return -1;

        return runStack.size() - framePointer.get(framePointer.size() - 1);
    }

    //Convert the top frame into an array and pass it
    public Integer[] getTopFrame() {
        if(getTopFrameSize() < 0)
            return null;

        Integer[] frame = Arrays.copyOf(runStack.toArray(), runStack.size(), Integer[].class);

        return Arrays.copyOfRange(frame, framePointer.peek(), runStack.size());
    }

    //Return the index of the top frame. If the frame is empty, throw an error.
    private int peekFrame() {
        return peekFrame("Can't peek frame");
    }

    //Return the index of the top frame. If the frame is empty, throw an error with the specified message.
    private int peekFrame(String errorMessage) {
        if(framePointer.size() == 0)
            throw new ArrayIndexOutOfBoundsException(errorMessage + ", there are no frames.");

        return framePointer.peek();
    }

    //Return and remove the index of the top frame. If the frame is empty, throw an error. Then remove the top frame from the runStack
    public void popFrame() {
        if(framePointer.size() == 0)
            throw new ArrayIndexOutOfBoundsException("Can't POP FRAME, there are no more frames.");

        int oldFrame = framePointer.pop();

        while(runStack.size() > oldFrame)
            runStack.remove(getLastStackIndex());
    }
}