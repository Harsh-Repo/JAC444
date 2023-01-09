import java.util.Map;

public class Depositer extends Thread{ // Producer
    private StrangeBank strangeBank;
    Map<String, Integer> currencyMap;


    public Depositer(StrangeBank strangeBank, Map<String, Integer> currencyMap) {
    	super("Depositor Thread");
		this.strangeBank = strangeBank;
		this.currencyMap = currencyMap;
	}

	@Override
	public void run() {
	

			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
			
			 int balance =0;
			 
		
			 
				for (Map.Entry<String, Integer> entry : currencyMap.entrySet()) {

					if (entry.getKey().equals("dollor")) {
						balance = entry.getValue();
					} else if (entry.getKey().equals("euro")) {
						balance = entry.getValue();
					} else if (entry.getKey().equals("pound")) {
						balance = entry.getValue();
					}

					if (balance > 0) {
						strangeBank.depositMoney(balance, entry.getKey());
						balance--;

					} else {
						break;
					}
				}
	}
}