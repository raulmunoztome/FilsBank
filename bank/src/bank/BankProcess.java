package bank;

public class BankProcess {
	public enum Operation {
		DEPOSIT, WITHDRAW;

		String sign() {
			return DEPOSIT.equals(this) ? "+" : "-";
		}
	}

	private static final String STATEMENT_FILE = "statement.txt";

	public static void main(String[] args) {
		
		String concepto;
		double cantidad;
		Operation operacion;
		boolean ciclo = true;
		
		while(ciclo) {
			AccountMonitor accountMonitor = new AccountMonitor(STATEMENT_FILE);
			
			operacion = ProcessInputUtils.readOperationMenu();
			concepto = ProcessInputUtils.readConcept();
			cantidad = ProcessInputUtils.readAmount();

			accountMonitor.writeOperation(operacion, concepto, cantidad);
			
		if(!ProcessInputUtils.confirmAnotherOperation()) {
			
			ciclo = false;
			
			}
		}
		System.out.println("Bank process finished.");
	}
}
