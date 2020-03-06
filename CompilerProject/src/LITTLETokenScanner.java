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

            return;
        }
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\Z");
        String inputFileString = sc.next();

        LITTLESCANNER  lexer = new LITTLESCANNER(CharStreams.fromString(inputFileString));

        while(true) {
            //while the lexer continues to find tokens in the input string
            Token token = lexer.nextToken();
            if(token.getType() == LITTLESCANNER.EOF) {
                break;
            }
            //print to screen token type and value
            String tokenName = lexer.getVocabulary().getSymbolicName(token.getType());

            //append the output string with same
            if(!tokenName.equals("COMMENT")){
                outputString += "Token Type: "+tokenName+"\n"+"Value: " + token.getText()+"\n";
            }

        }


        System.out.println(outputString);
    }


}

