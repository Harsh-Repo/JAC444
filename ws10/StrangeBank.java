class StrangeBank{
	
    private int balance = 0;
    private String currencyType;
    
    

	public int getBalance() {
		return balance;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public synchronized void depositMoney(int currentBalance, String currency) { // Depositer
		while (balance > 0) {

			try {

				System.out.println("Waiting for withdrawal of money from your account!");
				wait();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		balance += currentBalance;
		this.currencyType = currency;

		System.out.println(
				"Money Deposited in your account, the current balance is " + getBalance() + " " + getCurrencyType());

		notify();

	}
    public synchronized int withdrawMoney(){ // Withdrawer
    	while(balance == 0) {   
    		
			try { 
				System.err.println("Sorry ! Your Account is Empty.Please Deposit Money.");
				wait();
			
			} catch (Throwable e) { 
			System.out.println(e.getMessage());
			}
		}
		balance -=1;
		System.out.println("Your Friend withdrew money, the current balance is " + getBalance()+ " " + getCurrencyType()+"\n");
		notify(); 
	    return 1;
    }
}