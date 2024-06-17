

public class Carta {
	private String forca;
	private int naipe;
	
	public Carta(String forca, int naipe) {
		setForca(forca);
		setNaipe(naipe);
	}

	public int getNaipe() {
		return naipe;
	}

	public void setNaipe(int naipe) {
		this.naipe = naipe;
	}

	public String getForca() {
		return forca;
	}

	public void setForca(String forca) {
		this.forca = forca;
	}
	
	public String toString() {
		return "Força: " + forca + " " +
				"Naipe: " + naipe;
	}
	
}
