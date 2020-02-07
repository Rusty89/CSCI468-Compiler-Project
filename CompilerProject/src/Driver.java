public class Driver {
    public static void main(String[] args) throws Exception {
        LITTLETokenScanner tokenScan = new LITTLETokenScanner();
        if (args.length != 0) {
            for (String argument : args) {
                tokenScan.scan(argument);
            }
        } else {
            System.out.println("No program arguments provided. Please provide at least one argument.")
        }
    }
}