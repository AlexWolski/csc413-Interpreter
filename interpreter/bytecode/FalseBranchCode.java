package interpreter.bytecode;

public class FalseBranchCode extends JumpByteCode {
    String label;
    int address;

    public void init(String ... parameters) {
        label = parameters[0];
    }

    public void execute() {
    }

    public String getLabel() {
        return label;
    }

    public void setAddress(int resolvedAddress) {
        address = resolvedAddress;
    }
}