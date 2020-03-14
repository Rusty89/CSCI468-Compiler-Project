import java.util.ArrayList;
import java.util.Stack;

public class LITTLEListenerCustom extends LITTLEBaseListener {

    public Stack<ArrayList<String>> scopeStack;
    public ArrayList<String> currentSymbol;
    public LITTLEListenerCustom() {
        scopeStack = new Stack<ArrayList<String>>();

    }
    @Override public void enterPgm_body(LITTLEParser.Pgm_bodyContext ctx) {
        //make global context
  
    }


    @Override public void enterVar_decl(LITTLEParser.Var_declContext ctx) {
        String type = ctx.var_type().getText();
        String [] varNameList = ctx.id_list().getText().split(",");
        for (String name:varNameList) {
            System.out.println("name "+name+" type " +type );
        }
    }

    @Override public void enterString_decl(LITTLEParser.String_declContext ctx) {
        System.out.println("name "+ ctx.id().getText() + "type STRING "+ "value "+ctx.str().getText());


    }
}
