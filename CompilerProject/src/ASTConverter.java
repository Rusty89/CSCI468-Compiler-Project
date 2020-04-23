import java.util.ArrayList;
import java.util.HashMap;

public class ASTConverter {

    // Registers
    static ArrayList<String> registers = new ArrayList<>(100);

    // Convert Method - takes AST code and converts it to tinyCode equivalent
    public static void convert(String[] arr){

        // registers
        String r1;
        String r2;
        String r3;

        // amount of needed registers varies based on line of AST Code
        if (arr.length > 3) {
            r1 = searchAL(arr[1]);
            r2 = searchAL(arr[2]);
            r3 = searchAL(arr[3]);
        }
        else if (arr.length > 2){
            r1 = searchAL(arr[1]);
            r2 = searchAL(arr[2]);
            r3 = "";
        }
        else{
            r1 = searchAL(arr[1]);
            r2 = "";
            r3 = "";
        }

        // switch on AST Code type
        switch(arr[0]){

            case "ADDI":
                System.out.println("move " + arr[1] + " " + r1);
                System.out.println("move " + arr[2] + " " + r2);
                System.out.println("addi " + r1 + " " + r3);
                System.out.println("addi " + r2 + " " + r3);
                System.out.println("move " + r3 + " " + arr[3]);
                break;

            case "ADDF":
                System.out.println("move " + arr[1] + " " + r1);
                System.out.println("move " + arr[2] + " " + r2);
                System.out.println("addr " + r1 + " " + r3);
                System.out.println("addr " + r2 + " " + r3);
                System.out.println("move " + r3 + " " + arr[3]);
                break;

            case "SUBI":
                System.out.println("move " + arr[1] + " " + r1);
                System.out.println("move " + arr[2] + " " + r2);
                System.out.println("move " + r1 + " " + r3);
                System.out.println("subi " + r2 + " " + r3);
                System.out.println("move " + r3 + " " + arr[3]);
                break;

            case "SUBF":
                System.out.println("move " + arr[1] + " " + r1);
                System.out.println("move " + arr[2] + " " + r2);
                System.out.println("move " + r1 + " " + r3);
                System.out.println("subr " + r2 + " " + r3);
                System.out.println("move " + r3 + " " + arr[3]);
                break;

            case "MULI":
                System.out.println("move " + arr[1] + " " + r1);
                System.out.println("move " + arr[2] + " " + r2);
                System.out.println("move " + r1 + " " + r3);
                System.out.println("muli " + r2 + " " + r3);
                System.out.println("move " + r3 + " " + arr[3]);
                break;

            case "MULF":
                System.out.println("move " + arr[1] + " " + r1);
                System.out.println("move " + arr[2] + " " + r2);
                System.out.println("move " + r1 + " " + r3);
                System.out.println("mulr " + r2 + " " + r3);
                System.out.println("move " + r3 + " " + arr[3]);
                break;

            case "DIVI":
                System.out.println("move " + arr[1] + " " + r1);
                System.out.println("move " + arr[2] + " " + r2);
                System.out.println("move " + r1 + " " + r3);
                System.out.println("divi " + r2 + " " + r3);
                System.out.println("move " + r3 + " " + arr[3]);
                break;

            case "DIVF":
                System.out.println("move " + arr[1] + " " + r1);
                System.out.println("move " + arr[2] + " " + r2);
                System.out.println("move " + r1 + " " + r3);
                System.out.println("divr " + r2 + " " + r3);
                System.out.println("move " + r3 + " " + arr[3]);
                break;

            case "STOREI":
                System.out.println("move " + arr[1] + " " + r1);
                System.out.println("move " + r1 + " " + arr[2]);
                break;

            case "STOREF":
                System.out.println("move " + arr[1] + " " + r1);
                System.out.println("move " + r1 + " " + arr[2]);
                break;

            case "READI":
                System.out.println("sys readi " + arr[1]);
                break;

            case "READF":
                System.out.println("sys readr " + arr[1]);
                break;

            case "WRITEI":
                System.out.println("sys writei " + arr[1]);
                break;

            case "WRITEF":
                System.out.println("sys writer " + arr[1]);
                break;

            case "WRITES":
                System.out.println("sys writes " + arr[1]);
                break;

            default:
                System.out.println("conversion not found... error?");

        }
    }

    // Slight optimization - checks to see if value is already stored in registers; if it is it reuses that
    // register instead of making a new one.
    public static String searchAL(String s){

        // if already saved
        if (registers.contains(s)){

            // return the register as a string
            String reg = "$R" + (registers.indexOf(s) + 1);
            return reg;
        }

        // if new entry
        else {

            // add to registers and return
            registers.add(s);
            String reg = "$R" + (registers.indexOf(s) + 1);
            return reg;
        }
    }
}
