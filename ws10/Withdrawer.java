class Withdrawer extends  Thread{ // Consumer

    private StrangeBank strangeBank;
    private int amount;


    public Withdrawer(StrangeBank strangeBank,int  amount) {
    	super("Withdrawer Thread");
		this.strangeBank = strangeBank;
		this.amount=amount;
	}

	@Override
	public  void run() {
		int key;
		do {
		
			try {
				Thread.sleep( (int) ( Math.random() * 1000 ) );
			
			} catch(InterruptedException e) {
				System.out.println(e.toString());
			}
			
			key = strangeBank.withdrawMoney();
		} while (key != amount);
	}
}