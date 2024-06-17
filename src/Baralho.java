
import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
	private ArrayList<Carta> baralho;
	
	
	
	public Baralho() {
	    baralho = new ArrayList<>();
	    
		String[] forcas = {"3", "2", "1", "K", "J", "Q", "7", "6", "5", "4"};
		int[] naipes = {1,2,3,4};
		for(int i = 0; i < forcas.length; i++) {
			for(int y = 0; y < naipes.length; y++) {
				Carta carta = new Carta(forcas[i], naipes[y]);
				baralho.add(carta);	
			}
		}
		embaralhar();
	}
	
	public void embaralhar() {
        Collections.shuffle(baralho);
	}
	
	public Carta distribuir(int i) {
		return baralho.get(i);
	}
	
	public ArrayList<Carta> getBaralho() {
		return baralho;
	}

	public void setBaralho(ArrayList<Carta> baralho) {
		this.baralho = baralho;
	}
	
	public String toString() {
        for (Carta carta : baralho) {
            System.out.println(carta);
        }
		return "";
	}
}
