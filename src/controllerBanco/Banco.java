package controllerBanco;

import java.util.concurrent.Semaphore;

public class Banco extends Thread{
	
	int idBanco;
	Semaphore semaforo;
	
	public Banco(int idBanco, Semaphore semaforo) {
		this.idBanco = idBanco;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		int opc = ((int)(Math.random()*2));
		if(opc == 1) {
			try {
				semaforo.acquire();
				executar("O depósito");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				semaforo.release();
			}
		}else {
			try {
				semaforo.acquire();
				executar("O saque");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				semaforo.release();
			}
		}
	}
	
	public void executar(String func) {
		System.out.println(func+" do #"+idBanco+" foi um sucesso");
	}
	
}
