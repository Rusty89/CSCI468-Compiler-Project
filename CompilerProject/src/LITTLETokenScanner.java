import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import java.io.*;
import java.util.Scanner;

public class LITTLETokenScanner {
    public LITTLETokenScanner(){
        //empty constructor
    }

    public void scan(String fileName) throws FileNotFoundException, UnsupportedEncodingException {
        //string to hold output
        String outputString="";


        //reads in whole file at once
        File file = new File(fileName);
        if(!file.exists()){
            System.out.println("File not found!");
            return;
        }
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\Z");
        String inputFileString = sc.next();

        LITTLELexer  lexer = new LITTLELexer(CharStreams.fromString(inputFileString));
        System.out.println("Beginning Scan...");
        while(true) {
            //while the lexer continues to find tokens in the input string
            Token token = lexer.nextToken();
            if(token.getType() == LITTLELexer.EOF) {
                break;
            }
            //print to screen token type and value
            String tokenName = lexer.getVocabulary().getSymbolicName(token.getType());
            System.out.println("Token Type: "+tokenName);
            System.out.println("Value: " + token.getText());
            //append the output string with same
            if(!tokenName.equals("COMMENT")){
                outputString += "Token Type: "+tokenName+"\n"+"Value: " + token.getText()+"\n";
            }

        }
        System.out.println("Scan Complete");

        Scanner in = new Scanner(System.in);
        //printwriter to put output string in a file
        System.out.print("Enter name of output file >>> ");
        PrintWriter writer = new PrintWriter(in.nextLine());
        writer.print(outputString);
        writer.close();
    }


}

