import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            for (String argument : args) {
                //reads in whole file at once
                File file = new File(argument);

                Scanner sc = new Scanner(file);
                sc.useDelimiter("\\Z");
                String inputFileString = sc.next();
                LITTLELexer  lexer = new LITTLELexer(CharStreams.fromString(inputFileString));
                CommonTokenStream ts = new CommonTokenStream(lexer);
                LITTLEParser parser = new LITTLEParser(ts);

                parser.removeErrorListeners();
                ParseTree tree = parser.program();
                if(parser.getNumberOfSyntaxErrors()>0){
                    //System.out.println("Not accepted");
                }else{
                    //System.out.println("Accepted");
                }
                ParseTreeWalker ptwalker = new ParseTreeWalker();
                LITTLEListenerCustom listener = new LITTLEListenerCustom();
                ptwalker.walk(listener, tree);

                visitAST IR_code_generation = new visitAST(listener.symbolTable);
                //at this point the AST is completed and ready to be used to make code
                //do post order traversal
                IR_code_generation.post_order_traversal(listener.AST);
                //print code
                for (String line:IR_code_generation.code) {
                    // TBD - save results to file?

                    // print original line for reference
                    System.out.println("ORIGINAL: " + line);

                    // split on spaces and convert
                    String[] temp = line.split(" ");
                    ASTConverter.convert(temp);

                    // formatting
                    System.out.println();
                }


                if(!listener.nameShared){
                    while(!listener.dummyTransferScopeStack.empty()){
                        ArrayList<ArrayList<String>> output = listener.dummyTransferScopeStack.pop();
                        for (ArrayList<String> scopeLayer: output) {
                            for (String item: scopeLayer) {
                                System.out.print(item);
                                System.out.print(" ");
                            }
                            System.out.println("");

                        }
                        System.out.println("");
                    }

                }

            }
        } else {
            System.out.println("No program arguments provided. Please provide at least one argument.");
        }
    }
}