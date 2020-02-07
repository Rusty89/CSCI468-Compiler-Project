

public class Driver {
    public static void main(String[] args) throws Exception {
        LITTLETokenScanner tokenScan = new LITTLETokenScanner();
        if(args[0]!=null){
            tokenScan.scan(args[0]);
        }

    }
}