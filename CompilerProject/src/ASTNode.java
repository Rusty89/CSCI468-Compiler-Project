import java.util.ArrayList;

public class ASTNode {
    ASTNode parent;
    ArrayList<ASTNode> children;
    ArrayList<String> code;
    String operation;;
    String data;
    String symbol_table_level;

    boolean visited = false;

    public ASTNode(){
        children = new ArrayList<>();
        operation ="nop";
    }


}
