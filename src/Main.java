
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) {
		Display display = new Display();	
		display.start();
		Timer run = new Timer();
		run.schedule(new TimerTask() {
			int contador = 0;
			public void run() {
				if(contador > 0) {
					Scanner sc = new Scanner(System.in);
			    	int qtdTruqueiros = 2;
					ArrayList<Truqueiro> truqueiros = new ArrayList<>();
					if(qtdTruqueiros == 2) {
						for (int i = 0; i < qtdTruqueiros; i++) {
							System.out.println("Insira o nome do " + (i + 1) + "° truqueiro:");
						    String nome = sc.next();
						    Truqueiro truqueiro = new Truqueiro(nome); 
						    truqueiros.add(truqueiro); 
						}		
						display.setTruqueiros(truqueiros);
					}
					//System.out.println(truqueiros.toString());
					Timer timer = new Timer();				
					
					Baralho baralho = new Baralho();
					int indexBaralho = 0;
			
					for (Truqueiro truqueiro : truqueiros) {
						for(int i = 0; i < 3; i++) {
							Carta carta = baralho.distribuir(indexBaralho);
					        truqueiro.setMao(carta);
					        indexBaralho++;
						}
					}
					int indexVira = indexBaralho++;
					Mesa mesa = new Mesa(baralho.distribuir(indexVira));
					display.setVira(baralho.distribuir(indexVira));
			
					display.comecaJogo();
					int comeca = sc.nextInt() - 1;
					
					if(comeca == 1) {
						Collections.reverse(truqueiros);
					}
					
					display.loading(1500);
				    System.out.println("                 INICIANDO");
			
					timer.schedule(new TimerTask() {
						String ganhador = null;
						int contador = 0;
						public void run() {
							if(contador > 0) {
								while(ganhador != "ganhou") {
									for(int rodada = 0; rodada < 3; rodada++) {
										display.setLance(null);
										for (int y = 0 ; y < truqueiros.size(); y++) {
										    Truqueiro truqueiro = truqueiros.get(y);
										    System.out.println("              Vez de " + truqueiro.getNome());
										    int indexVira = 0;
										    for(Carta carta : truqueiro.getMao()) {
												display.showCarta(carta.getForca(), carta.getNaipe(), indexVira);
												indexVira++;
										    }
				
											System.out.println("\n Jogue uma carta!");
								    		int cartaEscolhida = sc.nextInt();
									    	Display.limparTerminal();

									    	int indexCarta = 1;
										    for(Carta carta : truqueiro.getMao()) {
										    	if(indexCarta == cartaEscolhida) {
										    		mesa.setRodada(carta);
										    		mesa.setTruqueirosOrdem(truqueiro.getNome());
										    		display.setLance(carta);
										    	}
				
										    	indexCarta++;
										    }
									    	truqueiro.lancaCarta(cartaEscolhida - 1);
									    	
									    	int passaVez = 0;
									    	while(passaVez != 1) {
									    		Truqueiro truqueiroSeguinte = null;
									    		if(y == 0) {
									    			truqueiroSeguinte = truqueiros.get(1);
									    		}else if (y == 1) {
									    			truqueiroSeguinte = truqueiros.get(0);
									    		}
												display.confirmaTruqueiro(truqueiroSeguinte.getNome());
										    	passaVez = sc.nextInt();
									    	
									    	}
									    	
										}
				
								    	mesa.ganhaRodada();
									}
									int lancesVencidos = 0;
									for (int x = 0 ; x < truqueiros.size(); x++) {
									    Truqueiro truqueiro = truqueiros.get(x);
										for (String ganhadorLance : mesa.getPlacarRodada()) {
								            if (ganhadorLance.equals(truqueiro.getNome())) {
								            	lancesVencidos++;
								            }
								        }
										if(lancesVencidos >= 2) {
											String vencedorRodada = truqueiro.getNome();
											Timer timerRodada = new Timer();		
											System.out.println(" ----- Vencedor Rodada: " + vencedorRodada + " ----- ");

											timerRodada.schedule(new TimerTask() {
												int contadorRodada = 0;
												public void run() {
													if(contadorRodada > 0) {
														timerRodada.cancel();
													}
													contadorRodada++;
												}
											}, 0, 3000);
											
						            		break;
						            	}
									}
									baralho.embaralhar();
							    	
									int indexBaralho = 0;
							    	for (Truqueiro truqueiro : truqueiros) {
										for(int i = 0; i < 3; i++) {
											Carta carta = baralho.distribuir(indexBaralho);
									        truqueiro.setMao(carta);
									        indexBaralho++;
										}
									}
									int indexVira = indexBaralho++;
									Mesa mesa = new Mesa(baralho.distribuir(indexVira));
									display.setVira(baralho.distribuir(indexVira));
								}
			                    timer.cancel();
							}
			                contador++;
						}
					}, 0, 7700);
					//baralho.toString();	
                    run.cancel();
				}
                contador++;
			}
		}, 0, 7700);
	}
}