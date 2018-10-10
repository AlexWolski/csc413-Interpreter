package interpreter.bytecode;

import java.util.HashMap;

public class OperatorTable {

    private static HashMap<String,String> operatorTable;

    private OperatorTable(){}

    public static void init(){
        operatorTable =  new HashMap<>();
        operatorTable.put("+", "addOp");
        operatorTable.put("-", "subtractOp");
        operatorTable.put("/", "divideOp");
        operatorTable.put("*", "multiplyOp");
        operatorTable.put("==", "equalsOp");
        operatorTable.put("!=", "notEqualsOp");
        operatorTable.put("<", "lesOp");
        operatorTable.put("<=", "lessEqualsOp");
        operatorTable.put(">", "greaterOp");
        operatorTable.put(">=", "greaterEqualsOp");
        operatorTable.put("|", "orOp");
        operatorTable.put("&", "andOp");
    }

    /**
     * A method to facilitate the retrieval of the names
     * of a specific operator class.
     * @param key for byte code.
     * @return class name of desired byte code.
     */
    public static String getClassName(String key){
        return operatorTable.get(key);
    }
}
