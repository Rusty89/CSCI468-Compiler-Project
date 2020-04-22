

import java.util.ArrayList;

public class visitAST {
    public ArrayList<ArrayList<ArrayList<String>>> symbolTable;
    public ArrayList<String> code = new ArrayList<>();
    public int temp_counter = 0;
    public visitAST(ArrayList<ArrayList<ArrayList<String>>> symbolTable){
        this.symbolTable = symbolTable;
    }

    public void visit_node(ASTNode root){

        //perform actions with node based on type of node
        if(root.operation.equals("read")){
            read(root);
        }
        else if (root.operation.equals("write")){
            write(root);
        }
        else if (root.operation.equals("assign")){
            assign(root);
        }
        else if (root.operation.equals("function")){
            function(root);
        }
        else if (root.operation.equals("id")){
            id(root);
        }
        else if (root.operation.equals("integer")){
            intLit(root);
        }
        else if (root.operation.equals("float")){
            floatLit(root);
        }
        else if (root.operation.equals("+")){
            addop(root);
        }
        else if (root.operation.equals("-")){
            subop(root);
        }
        else if (root.operation.equals("*")){
            mulop(root);
        }
        else if (root.operation.equals("/")){
            divop(root);
        }else if (root.operation.equals("nop")){

        }

    }


    public void post_order_traversal(ASTNode root){
        for (ASTNode node :root.children) {
            post_order_traversal(node);
        }
        visit_node(root);

    }


    public String find_variable_type(String var_name, String current_level){
        String type="";
        ArrayList<ArrayList<String>> current_level_table = new ArrayList<>();
        for(ArrayList<ArrayList<String>> symbol_block:symbolTable) {
            String name_of_table = symbol_block.get(0).get(0).split(" ")[2];
            if(name_of_table.equals(current_level)){
                current_level_table = symbol_block;
            }
        }

        for(ArrayList<String> symbol_block:current_level_table) {
            if(symbol_block.size()>1){
                String name = symbol_block.get(1);
                if(name.equals(var_name)){
                    type = symbol_block.get(3);
                }
            }
        }

        return type;
    }


    public void read(ASTNode root){
        String [] read_variables = root.data.split(",");
        for (String entry:read_variables ) {

            String type = find_variable_type(entry, root.symbol_table_level);
            if(type.equals("STRING")){
                code.add("READS "+ entry);
            }
            else if(type.equals("FLOAT")){
                code.add("READF "+ entry);
            }
            else if(type.equals("INT")){
                code.add("READI "+ entry);
            }
        }
    }

    public void write(ASTNode root){
        String [] write_variables = root.data.split(",");
        for (String entry:write_variables ) {

            String type = find_variable_type(entry, root.symbol_table_level);
            if(type.equals("STRING")){
                code.add("WRITES "+ entry);
            }
            else if(type.equals("FLOAT")){
                code.add("WRITEF "+ entry);
            }
            else if(type.equals("INT")){
                code.add("WRITEI "+ entry);
            }
        }
    }

    public void assign(ASTNode root){
        String name_of_var = root.children.get(0).data;
        String type = find_variable_type(name_of_var, root.children.get(0).symbol_table_level);


        if(type.equals("FLOAT")){
            code.add("STOREF "+ root.children.get(1).temp_var + " "+name_of_var);
        }
        else if(type.equals("INT")){
            code.add("STOREI "+ root.children.get(1).temp_var + " "+name_of_var);
        }

    }
    public void function(ASTNode root){

    }
    public void id(ASTNode root){
        root.temp_var = root.data;
    }
    public void intLit(ASTNode root){
        root.temp_var = "T"+temp_counter;
        temp_counter++;
        code.add("STOREI "+ root.data + " "+root.temp_var);

    }
    public void floatLit(ASTNode root){
        root.temp_var = "T"+temp_counter;
        temp_counter++;
        code.add("STOREF "+ root.data + " "+root.temp_var);

    }
    public void addop(ASTNode root){
        root.temp_var = "T"+temp_counter;
        temp_counter++;

        code.add("ADDI "+ root.children.get(1).temp_var + " "+root.children.get(0).temp_var +" " +root.temp_var);
    }
    public void subop(ASTNode root){
        root.temp_var = "T"+temp_counter;
        temp_counter++;

        code.add("SUBI "+ root.children.get(1).temp_var + " "+root.children.get(0).temp_var +" " +root.temp_var);
    }
    public void mulop(ASTNode root){
        root.temp_var = "T"+temp_counter;
        temp_counter++;

        code.add("MULI "+ root.children.get(1).temp_var + " "+root.children.get(0).temp_var +" " +root.temp_var);
    }
    public void divop(ASTNode root){
        root.temp_var = "T"+temp_counter;
        temp_counter++;

        code.add("DIVI "+ root.children.get(1).temp_var + " "+root.children.get(0).temp_var +" " +root.temp_var);
    }


}
