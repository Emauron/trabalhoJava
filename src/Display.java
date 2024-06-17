
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;

public class Display {
	private ArrayList<Truqueiro> truqueiros;
	private Carta vira;
	private Carta lance;
	
	public void confirmaTruqueiro(String nome) {
		System.out.println("Vez passada para " + nome + " ?");
		System.out.println("1 - Sim      2 - Não");

	}
	
	public void showCarta(String forca, int naipe, int indexVira) {
		String desenhoNaipe = "";
		switch(naipe) {
	    	case 1:
	    		desenhoNaipe ="♣";
	    		break;
	    	case 2:
	    		desenhoNaipe ="♥";
	    		break;
	    	case 3:
	    		desenhoNaipe ="♠";
	    		break;
	    	case 4:
	    		desenhoNaipe ="♦";
	    	default:
		}
		if(indexVira == 0) {
			String naipeVira = "";
			switch(vira.getNaipe()) {
		    	case 1:
		    		naipeVira ="♣";
		    		break;
		    	case 2:
		    		naipeVira ="♥";
		    		break;
		    	case 3:
		    		naipeVira ="♠";
		    		break;
		    	case 4:
		    		naipeVira ="♦";
		    	default:
			}
			if(this.lance == null) {
				System.out.println(   "                                        vira:\r\n" 
									+ "   " + "+-----+                        +-----+\r\n"
									+ (indexVira+1) + ". " + "|   " + desenhoNaipe + " |                        |   " + naipeVira + " |\r\n"
									+ "   " + "|  "+ forca +"  |                        |  "+ vira.getForca() +"  |\r\n"
									+ "   " + "|     |                        |     |\r\n"
									+ "   " + "+-----+                        +-----+");
			}else {
				int naipeLance = lance.getNaipe();
				String desenhoNaipeLance = "";
				switch(naipeLance) {
			    	case 1:
			    		desenhoNaipeLance ="♣";
			    		break;
			    	case 2:
			    		desenhoNaipeLance ="♥";
			    		break;
			    	case 3:
			    		desenhoNaipeLance ="♠";
			    		break;
			    	case 4:
			    		desenhoNaipeLance ="♦";
			    	default:
				}
				System.out.println(   "                                        vira:  lance:\r\n" 
									+ "   " + "+-----+                        +-----+ +-----+\r\n"
									+ (indexVira+1) + ". " +  "|   " + desenhoNaipe + " |                        |   " + naipeVira + " | |   " + desenhoNaipeLance + " |\r\n"
									+ "   " +  "|  "+ forca +"  |                        | "+ vira.getForca() +"   | |   " + lance.getForca() +" |\r\n"
									+ "   " +  "|     |                        |     | |     |\r\n"
									+ "   " +  "+-----+                        +-----+ +-----+");
				this.lance = null;
			}
		}else {
			System.out.println(   "   " + "+-----+\r\n"
								+ (indexVira+1) + ". " + "|   " + desenhoNaipe + " |\r\n"
								+ "   " + "|  "+ forca +"  |\r\n"
								+ "   " + "|     |\r\n"
								+ "   " + "+-----+");
		}
		
	}
	
	
	public static void limparTerminal() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
	}
	
	public void loading(int  relogio) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
        	int contador = 0;

            public void run() {
            	switch(contador) {
                	case 0:
                		System.out.print("         ♣   ");
                		break;
                	case 1:
                		System.out.print("    ♥   ");
                		break;
                	case 2:
                		System.out.print("    ♠   ");
                		break;
                	case 3:
                		System.out.print("    ♦   ");
                		break;
                	case 5:
                        timer.cancel();
                        limparTerminal();
                		break;
                	default:
                		//
            	}
            	contador++;
            }
        }, 0, relogio);
	}
	public void comecaJogo() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			int contador = 0;
			public void run() {
				limparTerminal();
				if(contador > 0) {
					System.out.println("\nQuem começa?");
					int cont = 1;
					for (Truqueiro truqueiro : truqueiros) {
						System.out.println(cont + " - " + truqueiro.getNome());
						cont++;
					}
					timer.cancel();
				}
				contador++;
			}
		},0 , 2000);
	}
	public void start() {
		System.out.println("   ##\r\n"
				+ "   ##\r\n"
				+ "  #####   ######   ##  ##    ####     ####\r\n"
				+ "   ##      ##  ##  ##  ##   ##  ##   ##  ##\r\n"
				+ "   ##      ##      ##  ##   ##       ##  ##\r\n"
				+ "   ## ##   ##      ##  ##   ##  ##   ##  ##\r\n"
				+ "    ###   ####      ######   ####     ####\r\n"
				+ "\r\n"
				);
		loading(1000);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			int contador = 0;
			public void run() {
				if(contador > 0) {
					timer.cancel();
				}
				contador++;
			}
		}, 0, 5500 );
	}

	public ArrayList<Truqueiro> getTruqueiros() {
		return truqueiros;
	}

	public void setTruqueiros(ArrayList<Truqueiro> truqueiros) {
		this.truqueiros = truqueiros;
	}

	public Carta getVira() {
		return vira;
	}

	public void setVira(Carta vira) {
		this.vira = vira;
	}

	public Carta getLance() {
		return lance;
	}

	public void setLance(Carta lance) {
		this.lance = lance;
	}
}
