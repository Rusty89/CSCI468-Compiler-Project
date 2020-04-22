import java.util.ArrayList;

public class ASTNode {
    ASTNode parent;
    ArrayList<ASTNode> children;
    ArrayList<String> code;
    String operation;
    String data;
    boolean visited = false;

    public ASTNode(){
        children = new ArrayList<>();
    }


}
