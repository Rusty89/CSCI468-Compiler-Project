import java.util.ArrayList;

public class ASTNode {
    ASTNode parent;
    ArrayList<ASTNode> children;
    String operation;;
    String data;
    String symbol_table_level;
    String temp_var;
    String type_check;


    public ASTNode(){
        children = new ArrayList<>();
        operation ="nop";
    }


}
