package dm3;

public class Gerant {
	private String nomGerant;
    private int numeroGerant;

    public Gerant(String nomGerant, int numeroGerant){
        this.nomGerant = nomGerant;
        this.numeroGerant = numeroGerant;

    }

	public String getNomGerant() {
		return nomGerant;
	}

	public void setNomGerant(String nomGerant) {
		this.nomGerant = nomGerant;
	}

	public int getNumeroGerant() {
		return numeroGerant;
	}

	public void setNumeroGerant(int numeroGerant) {
		this.numeroGerant = numeroGerant;
	}


}
