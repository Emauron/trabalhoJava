
import java.util.ArrayList;
import java.util.Arrays;

public class Mesa {
	private ArrayList<Carta> rodada;
	private ArrayList<String> truqueirosOrdem;
	private ArrayList<String> placarRodada;
	private Carta vira;

	public Mesa(Carta vira) {
		rodada = new ArrayList<>();
		truqueirosOrdem = new ArrayList<>();
		setPlacarRodada(new ArrayList<>());
		setVira(vira);
	}
	
	private String converteNaipe(int naipe) {
		String naipeSimbolo = "";
		switch(naipe) {
	    	case 1:
	    		naipeSimbolo ="♣";
	    		break;
	    	case 2:
	    		naipeSimbolo ="♥";
	    		break;
	    	case 3:
	    		naipeSimbolo ="♠";
	    		break;
	    	case 4:
	    		naipeSimbolo ="♦";
	    	default:
		}
		return naipeSimbolo;
	}
	
	public void ganhaRodada() {
		String vira = this.vira.getForca();
		String[] forcasBase = {"3", "2", "1", "K", "J", "Q", "7", "6", "5", "4"};
		ArrayList<String> forcas = new ArrayList<>();
		forcas.add(vira);
		for(int i = 0; i < forcasBase.length; i++) {
			if(forcasBase[i] != vira) {
				forcas.add(forcasBase[i]);
			}
		}

		int[] naipes = new int[rodada.size()]; 
		int[] indexForca = new int[rodada.size()]; 
		int contador = 0;
		for(Carta carta: rodada) {
			String forca = carta.getForca();
			indexForca[contador] = forcas.indexOf(forca);
			naipes[contador] = carta.getNaipe();
			contador++;
		}
		for(int i = 0; i < 15; i++) {
			System.out.println();
		}
		System.out.println("Ganhador: ");
		if(indexForca[0] < indexForca[1]) {
			placarRodada.add(truqueirosOrdem.get(0));
			System.out.println(   "+-----+\r\n"
								+ "|   " + converteNaipe(rodada.get(0).getNaipe()) + " |\r\n"
								+ "|  "+ rodada.get(0).getForca() +"  |\r\n"
								+ "|     |\r\n"
								+ "+-----+");
			System.out.println( truqueirosOrdem.get(0));
		}else if(indexForca[1] < indexForca[0]) {
			placarRodada.add(truqueirosOrdem.get(1));
			System.out.println(   "+-----+\r\n"
								+ "|   " + converteNaipe(rodada.get(1).getNaipe()) + " |\r\n"
								+ "|  "+ rodada.get(1).getForca() +"  |\r\n"
								+ "|     |\r\n"
								+ "+-----+");
			System.out.println( truqueirosOrdem.get(1));
		}else if(indexForca[0] == indexForca[1]) {
			if(naipes[0] > naipes[1]) {
				placarRodada.add(truqueirosOrdem.get(0));
				System.out.println(   "+-----+\r\n"
									+ "|   " + converteNaipe(rodada.get(0).getNaipe()) + " |\r\n"
									+ "|  "+ rodada.get(0).getForca() +"  |\r\n"
									+ "|     |\r\n"
									+ "+-----+");
				System.out.println( truqueirosOrdem.get(0));
			}else {
				placarRodada.add(truqueirosOrdem.get(1));
				System.out.println(   "+-----+\r\n"
									+ "|   " + converteNaipe(rodada.get(1).getNaipe()) + " |\r\n"
									+ "|  "+ rodada.get(1).getForca() +"  |\r\n"
									+ "|     |\r\n"
									+ "+-----+");
				System.out.println( truqueirosOrdem.get(1));
			}
		}
		rodada.remove(1);
		rodada.remove(0);
	}
	
	public ArrayList<Carta> getRodada() {
		return rodada;
	}

	public void setRodada(Carta carta) {
		rodada.add(carta);
	}

	public Carta getVira() {
		return vira;
	}

	public void setVira(Carta vira) {
		this.vira = vira;
	}

	public ArrayList<String> getTruqueirosOrdem() {
		return truqueirosOrdem;
	}

	public void setTruqueirosOrdem(String truqueirosOrdem) {
		this.truqueirosOrdem.add(truqueirosOrdem);
	}

	public ArrayList<String> getPlacarRodada() {
		return placarRodada;
	}

	public void setPlacarRodada(ArrayList<String> placarRodada) {
		this.placarRodada = placarRodada;
	}	
}
