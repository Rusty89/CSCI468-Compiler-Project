import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            for (String argument : args) {
                //reads in whole file at once
                File file = new File(argument);
                if(!file.exists()){
                    System.out.println("File not found!");
                    return;
                }
                Scanner sc = new Scanner(file);
                sc.useDelimiter("\\Z");
                String inputFileString = sc.next();
                LITTLELexer  lexer = new LITTLELexer(CharStreams.fromString(inputFileString));
                CommonTokenStream ts = new CommonTokenStream(lexer);
                LITTLEParser parser = new LITTLEParser(ts);

                ParseTree tree = parser.program();
                if(parser.getNumberOfSyntaxErrors()>0){
                    System.out.println("Not Accepted");
                }else{
                    System.out.println("Accepted");
                }
                //System.out.println(tree.toStringTree(parser));


            }
        } else {
            System.out.println("No program arguments provided. Please provide at least one argument.");
        }
    }
}