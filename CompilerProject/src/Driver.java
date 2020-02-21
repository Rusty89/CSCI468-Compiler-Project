import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
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


                try {
                    //  Block of code to try
                    parser.program();
                }
                catch(Exception e) {
                    System.out.println("Failed");
                }




                //System.out.println(tree.toStringTree(parser));

            }
        } else {
            System.out.println("No program arguments provided. Please provide at least one argument.");
        }
    }
}