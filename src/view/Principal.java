package view;

import java.util.concurrent.Semaphore;
import controllerBanco.Banco;

public class Principal {
	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int x=0; x < 20; x++) {
			Banco banco = new Banco(x, semaforo);
			banco.start();
		}
	}
}
