/*
 Authors: Rusy Clayton, William Kingsley, Nick Hager
 Purpose: Token scanner for the LITTLE programming language
 Generated from C:/Users/rusty/Documents/GitHub/CSCI468-Compiler-Project/CompilerProject/src\LITTLESCANNER.g4 by ANTLR 4.8
 */
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import java.io.*;
import java.util.Scanner;

public class LITTLETokenScanner {

    public void scan(String fileName) throws FileNotFoundException {
        //string to hold output
        StringBuilder outputString = new StringBuilder();

        //reads in whole file at once
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\Z");
        String inputFileString = sc.next();

        LITTLESCANNER  lexer = new LITTLESCANNER(CharStreams.fromString(inputFileString));
        System.out.println("Beginning Scan...");
        while (true) {
            //while the lexer continues to find tokens in the input string
            Token token = lexer.nextToken();
            if (token.getType() == LITTLESCANNER.EOF) {
                break;
            }
            //print to screen token type and value
            String tokenName = lexer.getVocabulary().getSymbolicName(token.getType());
            System.out.println("Token Type: "+tokenName);
            System.out.println("Value: " + token.getText());
            //append the output string with same
            if (!tokenName.equals("COMMENT")) {
                outputString
                        .append("Token Type: ").append(tokenName)
                        .append("\n")
                        .append("Value: ").append(token.getText())
                        .append("\n");
            }
        }
        System.out.println("Scan Complete");
        Scanner in = new Scanner(System.in);
        // print writer to put output string in a file
        System.out.print("Enter name of output file >>> ");
        PrintWriter writer = new PrintWriter(in.nextLine());
        writer.print(outputString);
        writer.close();
    }
}