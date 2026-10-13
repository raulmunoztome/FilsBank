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
		while(true) {
			AccountMonitor accountMonitor = new AccountMonitor(null);
			operacion = ProcessInputUtils.readOperationMenu();
			concepto = ProcessInputUtils.readConcept();
			cantidad = ProcessInputUtils.readAmount();

			accountMonitor.writeOperation(operacion, concepto, cantidad);
		if(!ProcessInputUtils.confirmAnotherOperation()) {
			break;
			}
		}
		System.out.println("Bank process finished.");
	}
}
