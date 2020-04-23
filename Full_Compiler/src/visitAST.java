

import java.util.ArrayList;

public class visitAST {
    public ArrayList<ArrayList<ArrayList<String>>> symbolTable;
    public ArrayList<String> code = new ArrayList<>();
    public ArrayList<String> tiny_code = new ArrayList<>();
    public int temp_counter = 0;
    public visitAST(ArrayList<ArrayList<ArrayList<String>>> symbolTable){

        this.symbolTable = symbolTable;
        //add initialize global variables
        for (int i = 1; i <symbolTable.get(0).size() ; i++) {
            if(symbolTable.get(0).get(i).get(3).equals("STRING")){
                tiny_code.add("str "+ symbolTable.get(0).get(i).get(1)+" "+ symbolTable.get(0).get(i).get(5));
            }else{
                tiny_code.add("var "+ symbolTable.get(0).get(i).get(1));
            }
        }

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
            tiny_code.add("sys halt");
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
                tiny_code.add("sys reads " + entry);
            }
            else if(type.equals("FLOAT")){
                code.add("READF "+ entry);
                tiny_code.add("sys readr " + entry);
            }
            else if(type.equals("INT")){
                code.add("READI "+ entry);
                tiny_code.add("sys readi " + entry);
            }
        }
    }

    public void write(ASTNode root){
        String [] write_variables = root.data.split(",");
        for (String entry:write_variables ) {

            String type = find_variable_type(entry, root.symbol_table_level);
            if(type.equals("STRING")){
                code.add("WRITES "+ entry);
                tiny_code.add("sys writes " + entry);
            }
            else if(type.equals("FLOAT")){
                code.add("WRITEF "+ entry);
                tiny_code.add("sys writer " + entry);
            }
            else if(type.equals("INT")){
                code.add("WRITEI "+ entry);
                tiny_code.add("sys writei " + entry);
            }
        }
    }

    public void assign(ASTNode root){
        String name_of_var = root.children.get(0).data;
        String type = find_variable_type(name_of_var, root.children.get(0).symbol_table_level);


        if(type.equals("FLOAT")){
            code.add("STOREF "+ root.children.get(1).temp_var + " "+name_of_var);
            tiny_code.add("move "+ root.children.get(1).temp_var + " "+name_of_var );
        }
        else if(type.equals("INT")){
            code.add("STOREI "+ root.children.get(1).temp_var + " "+name_of_var);
            tiny_code.add("move "+ root.children.get(1).temp_var + " "+name_of_var );
        }

    }
    public void function(ASTNode root){

    }
    public void id(ASTNode root){
        root.temp_var = root.data;
        String type = find_variable_type(root.data, root.symbol_table_level);
        root.type_check = type;
    }
    public void intLit(ASTNode root){
        root.temp_var = "r"+temp_counter;
        temp_counter++;
        root.type_check = "INT";
        code.add("STOREI "+ root.data + " "+root.temp_var);
        tiny_code.add("move "+ root.data + " "+root.temp_var);

    }
    public void floatLit(ASTNode root){
        root.temp_var = "r"+temp_counter;
        temp_counter++;
        root.type_check ="FLOAT";
        code.add("STOREF "+ root.data + " "+root.temp_var);
        tiny_code.add("move "+ root.data + " "+root.temp_var);

    }
    public void addop(ASTNode root){
        root.temp_var = "r"+temp_counter;
        temp_counter++;
        root.type_check = root.children.get(0).type_check;

        if(root.type_check.equals("INT")){
            code.add("ADDI "+ root.children.get(1).temp_var + " "+root.children.get(0).temp_var +" " +root.temp_var);
            tiny_code.add("move "+root.children.get(1).temp_var +" "+root.temp_var);
            tiny_code.add("addi "+root.children.get(0).temp_var + " " +root.temp_var);
        }else{
            code.add("ADDF "+ root.children.get(1).temp_var + " "+root.children.get(0).temp_var +" " +root.temp_var);
            tiny_code.add("move "+root.children.get(1).temp_var +" "+root.temp_var);
            tiny_code.add("addr "+root.children.get(0).temp_var + " " +root.temp_var);
        }

    }
    public void subop(ASTNode root){
        root.temp_var = "r"+temp_counter;
        temp_counter++;
        root.type_check = root.children.get(0).type_check;

        if(root.type_check.equals("INT")){
            code.add("SUBI "+ root.children.get(1).temp_var + " "+root.children.get(0).temp_var +" " +root.temp_var);
            tiny_code.add("move "+root.children.get(1).temp_var +" "+root.temp_var);
            tiny_code.add("subi "+root.children.get(0).temp_var + " " +root.temp_var);
        }else{
            code.add("SUBF "+ root.children.get(1).temp_var + " "+root.children.get(0).temp_var +" " +root.temp_var);
            tiny_code.add("move "+root.children.get(1).temp_var +" "+root.temp_var);
            tiny_code.add("subr "+root.children.get(0).temp_var + " " +root.temp_var);
        }


    }
    public void mulop(ASTNode root){
        root.temp_var = "r"+temp_counter;
        temp_counter++;
        root.type_check = root.children.get(0).type_check;

        if(root.type_check.equals("INT")){
            code.add("MULI "+ root.children.get(1).temp_var + " "+root.children.get(0).temp_var +" " +root.temp_var);
            tiny_code.add("move "+root.children.get(1).temp_var +" "+root.temp_var);
            tiny_code.add("muli "+root.children.get(0).temp_var + " " +root.temp_var);
        }else{
            code.add("MULF "+ root.children.get(1).temp_var + " "+root.children.get(0).temp_var +" " +root.temp_var);
            tiny_code.add("move "+root.children.get(1).temp_var +" "+root.temp_var);
            tiny_code.add("mulr "+root.children.get(0).temp_var + " " +root.temp_var);

        }

    }
    public void divop(ASTNode root){
        root.temp_var = "r"+temp_counter;
        temp_counter++;
        root.type_check = root.children.get(0).type_check;

        if(root.type_check.equals("INT")){
            code.add("DIVI "+ root.children.get(1).temp_var + " "+root.children.get(0).temp_var +" " +root.temp_var);
            tiny_code.add("move "+root.children.get(1).temp_var +" "+root.temp_var);
            tiny_code.add("divi "+root.children.get(0).temp_var + " " +root.temp_var);
        }else{
            code.add("DIVF "+ root.children.get(1).temp_var + " "+root.children.get(0).temp_var +" " +root.temp_var);
            tiny_code.add("move "+root.children.get(1).temp_var +" "+root.temp_var);
            tiny_code.add("divr "+root.children.get(0).temp_var + " " +root.temp_var);
        }

    }


}
