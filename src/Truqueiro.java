import java.util.ArrayList;

public class Truqueiro {
	private String nome;
	private ArrayList<Carta> mao;
	
	public Truqueiro(String nome){
		setNome(nome);
        mao = new ArrayList<>();
        
	}
	public void lancaCarta(int indice) {
		mao.remove(indice);
	}
	public ArrayList<Carta> getMao(){
		return mao;
	}
	
	public void setMao(Carta carta){
		mao.add(carta);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return "Nome: " + nome + "\n"
			+ "Cartas" + mao;
	}
}
