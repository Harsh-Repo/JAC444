import java.util.HashMap;
import java.util.Map;

public class SharedAccount {
	
    public static void main(String[] args) {
        
    	Map< String,Integer> currencyMap = new HashMap<>();
        currencyMap.put("dollar", 1);
        currencyMap.put("euro", 2);
        currencyMap.put("pound", 3);
        
        StrangeBank strangeBank = new StrangeBank(); // shared container contains a shared int

        Depositer d = new Depositer(strangeBank, currencyMap);
        Withdrawer w = new Withdrawer(strangeBank,0);
       
        d.start();
        w.start();
    }
}