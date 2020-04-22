public class visitAST {

    public visitAST(){

    }

    public void visit_Node(ASTNode in_root){
        System.out.println(in_root.operation);

    }


    public void post_order_traversal(ASTNode in_root){
        for (ASTNode node :in_root.children) {
            post_order_traversal(node);
        }



        visit_Node(in_root);

    }




}
