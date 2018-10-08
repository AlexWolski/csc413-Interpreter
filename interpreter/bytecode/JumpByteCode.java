package interpreter.bytecode;

public abstract class JumpByteCode extends ByteCode {
    public abstract String getLabel();
    public void setAddress(int address) { }
}
