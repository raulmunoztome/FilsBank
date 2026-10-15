package bank;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import bank.BankProcess.Operation;

public class AccountMonitor {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private static final String CURRENCY = "EUR";

	private String fileName;

	public AccountMonitor(String fileName) {
		this.fileName = fileName;
	}

	// Write operation to the account statement
	public void writeOperation(Operation operation, String concept, double amount) {
		
		LocalDateTime ahora = LocalDateTime.now();
        String fechaFormateada = ahora.format(FORMATTER);
        String operacionElegida ="";
        String lineaOperacion = "";
        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw"); FileChannel channel = file.getChannel();
             FileLock lock = channel.lock()) {


	        	// Esto es lo que hace el append: va al final del archivo
	            file.seek(file.length());
	            // Escribe los datos

        		if(operation == Operation.WITHDRAW) {
        			operacionElegida = "RETIRADA";
        			
        			
        		}
        		
        		else {
        			operacionElegida = "INGRESO";
        		}
        		
        		lineaOperacion = fechaFormateada+" | "+operacionElegida+" | "+concept+" | "+amount+"E";
        		file.write(lineaOperacion.getBytes());
        		
    

           } catch (Exception e) {
        	   e.printStackTrace(); 
           } 
 
	}
}
