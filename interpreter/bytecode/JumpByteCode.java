package interpreter.bytecode;

//Subclass of ByteCod used to organize ByteCodes that store a label and target address
public abstract class JumpByteCode extends ByteCode {
    //Return the label of the ByteCode
    public abstract String getLabel();
    //Set the target address of the ByteCode
    public void setAddress(int address) { }
}
