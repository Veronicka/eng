package fatec.com.model;

public class Categoria {
	private Integer id;
	private String nome;
	private String creation;
	
	public Categoria(Integer id, String nome, String creation) {
		super();
		this.id = id;
		this.nome = nome;
		this.creation = creation;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCreation() {
		return creation;
	}
	public void setCreation(String creation) {
		this.creation = creation;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", creation="
				+ creation + "]";
	}
}
