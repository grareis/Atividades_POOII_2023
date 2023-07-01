package entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "potencia")
    private int potencia;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private String marca;

	public Modelo(int id, String descricao, int potencia, String string) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.potencia = potencia;
		this.marca = string;
	}

	public Modelo(int id2, Object descricao2, int potencia2, Marca marca2) {
		// TODO Auto-generated constructor stub
	}

	public Modelo() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Modelo [id=" + id + ", descricao=" + descricao + ", potencia=" + potencia + ", marca=" + marca + "]";
	}

	public void setMarca(Marca marca2) {
		// TODO Auto-generated method stub
		
	}

    
}