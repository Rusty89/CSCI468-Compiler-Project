import java.util.ArrayList;
import java.util.Stack;

public class LITTLEListenerCustom extends LITTLEBaseListener {

    public Stack<ArrayList<ArrayList<String>>> scopeStack;
    public Stack<ArrayList<ArrayList<String>>> transferStack;
    public ArrayList<ArrayList<String>> currentSymbolSet;
    public ArrayList<String> currentSymbol;
    public ArrayList<ArrayList<ArrayList<String>>> symbolTable = new ArrayList<>();
    public int block = 1;
    public int symbolTableIndex = 0;
    public boolean nameShared = false;


    public Stack<ArrayList<ArrayList<String>>> dummyScopeStack;
    public Stack<ArrayList<ArrayList<String>>> dummyTransferScopeStack;
    public ArrayList<ArrayList<String>> dummyCurrentSymbolSet;

    public ASTNode AST;

    public LITTLEListenerCustom() {
        scopeStack = new Stack<>();
        transferStack = new Stack<>();
        dummyScopeStack = new Stack<>();
        dummyTransferScopeStack = new Stack<>();
        //first node of the AST is the root, parent is itself.
        AST = new ASTNode();


    }
    @Override public void enterPgm_body(LITTLEParser.Pgm_bodyContext ctx) {
        //make global context symbol table
        currentSymbolSet = new ArrayList<>();
        currentSymbolSet.add(new ArrayList<>());
        currentSymbolSet.get(0).add("Symbol table GLOBAL");
        scopeStack.push(currentSymbolSet);

        //make global context symbol table
        dummyCurrentSymbolSet = new ArrayList<>();
        dummyCurrentSymbolSet.add(new ArrayList<>());
        dummyCurrentSymbolSet.get(0).add("Symbol table GLOBAL");
        dummyScopeStack.push(dummyCurrentSymbolSet);


    }


    @Override public void enterFunc_decl(LITTLEParser.Func_declContext ctx) {
        //make new symbol table
        currentSymbolSet = new ArrayList<>();
        currentSymbolSet.add(new ArrayList<>());
        currentSymbolSet.get(0).add("Symbol table "+ctx.id().getText());
        scopeStack.push(currentSymbolSet);

        //make global context symbol table dummy for step 3 output
        dummyCurrentSymbolSet = new ArrayList<>();
        dummyCurrentSymbolSet.add(new ArrayList<>());
        dummyCurrentSymbolSet.get(0).add("Symbol table "+ctx.id().getText());
        dummyScopeStack.push(dummyCurrentSymbolSet);

        //make ast node for function_decl
        ASTNode funcNode = new ASTNode();
        //make its parent the current node
        funcNode.parent = AST;
        //make this new node a child of the parent
        AST.children.add(funcNode);
        //write what kind of thing this node does
        funcNode.operation = "function";
        //grabs name of function to make label with
        funcNode.data = ctx.getChild(0).getText();
        //update current node to the new one
        AST = funcNode;
    }


    @Override public void enterWhile_stmt(LITTLEParser.While_stmtContext ctx) {
        //make new symbol table with block numbers
        currentSymbolSet = new ArrayList<>();
        currentSymbolSet.add(new ArrayList<>());
        currentSymbolSet.get(0).add("Symbol table BLOCK " + Integer.toString(block));
        scopeStack.push(currentSymbolSet);


        //make global context symbol table dummy for step 3 output
        dummyCurrentSymbolSet = new ArrayList<>();
        dummyCurrentSymbolSet.add(new ArrayList<>());
        dummyCurrentSymbolSet.get(0).add("Symbol table BLOCK " + Integer.toString(block));
        dummyScopeStack.push(dummyCurrentSymbolSet);

        block++;

    }

    @Override public void enterIf_stmt(LITTLEParser.If_stmtContext ctx) {
        currentSymbolSet = new ArrayList<>();
        currentSymbolSet.add(new ArrayList<>());
        currentSymbolSet.get(0).add("Symbol table BLOCK " + Integer.toString(block));
        scopeStack.push(currentSymbolSet);

        //make global context symbol table dummy for step 3 output
        dummyCurrentSymbolSet = new ArrayList<>();
        dummyCurrentSymbolSet.add(new ArrayList<>());
        dummyCurrentSymbolSet.get(0).add("Symbol table BLOCK " + Integer.toString(block));
        dummyScopeStack.push(dummyCurrentSymbolSet);

        block++;
    }

    @Override public void enterElse_part(LITTLEParser.Else_partContext ctx) {
        try{
            ctx.decl().getText();

            currentSymbolSet = new ArrayList<>();
            currentSymbolSet.add(new ArrayList<>());
            currentSymbolSet.get(0).add("Symbol table BLOCK " + Integer.toString(block));
            scopeStack.push(currentSymbolSet);

            //make global context symbol table dummy for step 3 output
            dummyCurrentSymbolSet = new ArrayList<>();
            dummyCurrentSymbolSet.add(new ArrayList<>());
            dummyCurrentSymbolSet.get(0).add("Symbol table BLOCK " + Integer.toString(block));
            dummyScopeStack.push(dummyCurrentSymbolSet);

            block++;


        }catch(Exception e) {
            //do nothing, no else was appended to the if statment
        }

    }

    @Override public void exitPgm_body(LITTLEParser.Pgm_bodyContext ctx) {
        addToSymbolTable();
        while(!dummyScopeStack.empty()){
            dummyTransferScopeStack.push(dummyScopeStack.pop());
        }

    }
    @Override public void exitFunc_decl(LITTLEParser.Func_declContext ctx) {
        addToSymbolTable();

        //back out of this ast node
        AST = AST.parent;
    }
    @Override public void exitWhile_stmt(LITTLEParser.While_stmtContext ctx) {
        addToSymbolTable();
    }
    @Override public void exitIf_stmt(LITTLEParser.If_stmtContext ctx) {
        addToSymbolTable();
    }

    @Override public void exitElse_part(LITTLEParser.Else_partContext ctx) {
        try{
            ctx.decl().getText();
            addToSymbolTable();

        }catch(Exception e) {
            //do nothing, no else was appended to the if statment
        }
    }

    //variable declarations

    @Override public void enterVar_decl(LITTLEParser.Var_declContext ctx) {
        //add variables to symbol table

        String type = ctx.var_type().getText();
        String [] varNameList = ctx.id_list().getText().split(",");
        for (String name:varNameList) {
            currentSymbol = new ArrayList<>();
            currentSymbol.add("name");
            currentSymbol.add(name);
            currentSymbol.add("type");
            currentSymbol.add(type);
            checkForDuplicateName(name);
            scopeStack.peek().add(currentSymbol);
            dummyScopeStack.peek().add(currentSymbol);


        }
    }

    @Override public void enterString_decl(LITTLEParser.String_declContext ctx) {
        //add variable to symbol table
        currentSymbol = new ArrayList<>();
        currentSymbol.add("name");
        currentSymbol.add(ctx.id().getText());
        currentSymbol.add("type");
        currentSymbol.add("STRING");
        currentSymbol.add("value");
        currentSymbol.add(ctx.str().getText());
        checkForDuplicateName(ctx.id().getText());
        dummyScopeStack.peek().add(currentSymbol);

    }

    @Override public void enterParam_decl(LITTLEParser.Param_declContext ctx) {
        //add variable to symbol table
        currentSymbol = new ArrayList<>();
        currentSymbol.add("name");
        currentSymbol.add(ctx.id().getText());
        currentSymbol.add("type");
        currentSymbol.add(ctx.var_type().getText());

        checkForDuplicateName(ctx.id().getText());
        dummyScopeStack.peek().add(currentSymbol);


    }

    @Override public void enterExpr(LITTLEParser.ExprContext ctx) {
        //create placeholder node
        ASTNode expressionNode = new ASTNode();
        expressionNode.parent = AST;
        AST.children.add(expressionNode);
        expressionNode.operation = "expr";
        AST = expressionNode;
    }



    @Override public void enterFactor(LITTLEParser.FactorContext ctx) {
        //create placeholder node
        ASTNode factorNode = new ASTNode();
        factorNode.parent = AST;
        AST.children.add(factorNode);
        factorNode.operation = "fact";
        AST = factorNode;
    }



    @Override public void exitExpr(LITTLEParser.ExprContext ctx) {
        //removing placeholder nodes and organizing the expression nodes



        ASTNode final_destination = AST;



        while(AST.children.size()>0){
            AST.operation = AST.children.get(0).operation;
            AST.data = AST.children.get(0).data;
            AST=AST.children.get(0);
        }
        AST.parent.children.remove(AST);




        AST = final_destination.parent;


    }

    @Override public void exitFactor(LITTLEParser.FactorContext ctx) {


        ASTNode final_destination = AST;



        while(AST.children.size()>0){
            AST.operation = AST.children.get(0).operation;
            AST.data = AST.children.get(0).data;
            AST=AST.children.get(0);
        }
        AST.parent.children.remove(AST);




        AST = final_destination.parent;

    }

    @Override public void enterExpr_prefix(LITTLEParser.Expr_prefixContext ctx) {
        if(ctx.getChildCount()==3){

            if(ctx.getChild(2).getChild(0).getText().equals("+")){
                //create an addop node
                ASTNode addop = new ASTNode();
                addop.parent = AST;
                AST.children.add(addop);
                addop.operation = "+";
                AST = addop;

            }else if(ctx.getChild(2).getChild(0).getText().equals("-")){
                //create an subop node
                ASTNode subop = new ASTNode();
                subop.parent = AST;
                AST.children.add(subop);
                subop.operation = "-";
                AST = subop;

            }

        }

    }

    @Override public void exitExpr_prefix(LITTLEParser.Expr_prefixContext ctx) {

        if(ctx.getChildCount()==3){

            AST = AST.parent;
        }
    }



    @Override public void enterFactor_prefix(LITTLEParser.Factor_prefixContext ctx) {
        if(ctx.getChildCount()==3){

            if(ctx.getChild(2).getChild(0).getText().equals("*")){
                //create an mulop node
                ASTNode mulop = new ASTNode();
                mulop.parent = AST;
                AST.children.add(mulop);
                mulop.operation = "*";
                AST = mulop;

            }else if(ctx.getChild(2).getChild(0).getText().equals("/")){
                //create an divop node
                ASTNode divop = new ASTNode();
                divop.parent = AST;
                AST.children.add(divop);
                divop.operation = "/";
                AST = divop;

            }

        }
    }

    @Override public void exitFactor_prefix(LITTLEParser.Factor_prefixContext ctx) {
        //move back to parent if we were in a non empty factor prefix
        if(ctx.getChildCount()==3){

            AST = AST.parent;
        }

    }

    @Override public void enterPrimary(LITTLEParser.PrimaryContext ctx){
        if(ctx.getChildCount()==1){
            //create a primary node
            String primaryValue = ctx.getText();
            String type = "id";


            //determines what type the primary entry is
            try {
                Float.parseFloat(primaryValue);
                type = "float";
            }
            catch(Exception e) {
            }
            try {
                Integer.parseInt(primaryValue);
                type = "integer";
            }
            catch(Exception e) {

            }
            //if not a float or an int, it's an id

            if(type.equals("id")){

                //create idNode
                ASTNode idNode = new ASTNode();
                idNode.parent = AST;
                AST.children.add(idNode);
                idNode.operation = type;
                idNode.data = primaryValue;
                AST = idNode;
            }else if (type.equals("integer")){

                //create integer literal node
                ASTNode intNode = new ASTNode();
                intNode.parent = AST;
                AST.children.add(intNode);
                intNode.operation = type;
                intNode.data = primaryValue;
                AST = intNode;
            }else if (type.equals("float")){

                //create float literal node
                ASTNode floatNode = new ASTNode();
                floatNode.parent = AST;
                AST.children.add(floatNode);
                floatNode.operation = type;
                floatNode.data = primaryValue;
                AST = floatNode;
            }
        }
    }


    @Override public void exitPrimary(LITTLEParser.PrimaryContext ctx) {
        if(ctx.getChildCount()==1){
            AST = AST.parent;
        }
    }




    @Override public void enterAssign_expr(LITTLEParser.Assign_exprContext ctx) {
        if(ctx.getChildCount()==3){

            ASTNode assignNode = new ASTNode();
            assignNode.parent = AST;
            AST.children.add(assignNode);
            assignNode.operation = "assign";

            ASTNode idNode = new ASTNode();
            idNode.parent = assignNode;
            assignNode.children.add(idNode);
            idNode.operation = "id";
            idNode.data = ctx.getChild(0).getText();
            AST = assignNode;
        }

    }

    @Override public void exitAssign_expr(LITTLEParser.Assign_exprContext ctx) {

        AST = AST.parent;

    }


    @Override public void enterRead_stmt(LITTLEParser.Read_stmtContext ctx) {
        ASTNode readNode = new ASTNode();
        readNode.parent = AST;
        AST.children.add(readNode);
        readNode.operation = "read";
        readNode.data = ctx.getChild(2).getText();
        AST = readNode;

    }
    @Override public void exitRead_stmt(LITTLEParser.Read_stmtContext ctx) {
        AST = AST.parent;
    }

    @Override public void enterWrite_stmt(LITTLEParser.Write_stmtContext ctx) {
        ASTNode writeNode = new ASTNode();
        writeNode.parent = AST;
        AST.children.add(writeNode);
        writeNode.operation = "write";
        writeNode.data = ctx.getChild(2).getText();
        AST = writeNode;

    }
    @Override public void exitWrite_stmt(LITTLEParser.Write_stmtContext ctx) {
        AST = AST.parent;
    }




    public void addToSymbolTable(){
        symbolTable.add(scopeStack.pop());
        while(!scopeStack.empty()){
            currentSymbolSet = scopeStack.peek();
            for(int i = 1; i < currentSymbolSet.size(); i++){
                symbolTable.get(symbolTableIndex).add(currentSymbolSet.get(i));
            }

            transferStack.push(scopeStack.pop());
        }
        symbolTableIndex++;
        while(!transferStack.empty()){
            scopeStack.push(transferStack.pop());
        }
    }

    public void checkForDuplicateName(String name){
        ArrayList<ArrayList<String>> nameCheck = scopeStack.peek();
        for(int i = 1; i<nameCheck.size(); i++){
            if(nameCheck.get(i).get(1).equals(name) && nameShared != true){
                nameShared = true;
                System.out.println("DECLARATION ERROR "+ name);
            }
        }
    }


}
