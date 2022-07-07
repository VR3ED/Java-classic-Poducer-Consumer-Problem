package esercizio2AdvancedThread;

import java.util.LinkedList;
import java.util.Queue;

public class Coda {
	//classe monitor
	
	Queue<Integer> c;
	int size;
	
	public synchronized int getElemento() throws InterruptedException { //ritorna elemento 
		while(c.isEmpty()) {
			wait(); 
		} 	
		int ritorno = c.remove(); //va salvato dentro una variabile temporanea perchè se si sveglia priuma il thread non sto facendo un operazione atomica e quindi due thread operano sulla stessa variabile
		notifyAll();
		return ritorno;
	}
	
	public synchronized void setElemento(int elemento) throws InterruptedException {
		while(c.size()==size) {
			wait();
		}
		c.add(elemento);
		notifyAll();
	}
	
	public Coda(int grandezza) {
		c = new LinkedList<Integer>();
		size = grandezza;
	}
}
 