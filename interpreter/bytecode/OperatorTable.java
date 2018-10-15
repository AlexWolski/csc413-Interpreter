package interpreter.bytecode;

import java.util.HashMap;

//Takes a math operator symbol and return the associated class name
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
        operatorTable.put("<", "lessOp");
        operatorTable.put("<=", "lessEqualsOp");
        operatorTable.put(">", "greaterOp");
        operatorTable.put(">=", "greaterEqualsOp");
        operatorTable.put("|", "orOp");
        operatorTable.put("&", "andOp");
    }

    public static String getClassName(String key){
        return operatorTable.get(key);
    }
}
