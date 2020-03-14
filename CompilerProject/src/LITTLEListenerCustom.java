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


    public LITTLEListenerCustom() {
        scopeStack = new Stack<>();
        transferStack = new Stack<>();
        dummyScopeStack = new Stack<>();
        dummyTransferScopeStack = new Stack<>();
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
            //System.out.println("name "+name+" type " +type );

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
        //System.out.println("name "+ ctx.id().getText() + "type STRING "+ "value "+ctx.str().getText());
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
        //System.out.println("name "+ ctx.id().getText() + "type STRING "+ "value "+ctx.str().getText());

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
