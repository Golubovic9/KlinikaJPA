package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Recept database table.
 * 
 */
@Entity
@Table(name="Recept")
@NamedQuery(name="Recept.findAll", query="SELECT r FROM Recept r")
public class Recept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRecept;

	private int kolicina;

	private String nazivLeka;

	//bi-directional many-to-one association to Pregled
	@ManyToOne
	@JoinColumn(name="Pregled_idPregled")
	private Pregled pregled;

	public Recept() {
	}

	public int getIdRecept() {
		return this.idRecept;
	}

	public void setIdRecept(int idRecept) {
		this.idRecept = idRecept;
	}

	public int getKolicina() {
		return this.kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public String getNazivLeka() {
		return this.nazivLeka;
	}

	public void setNazivLeka(String nazivLeka) {
		this.nazivLeka = nazivLeka;
	}

	public Pregled getPregled() {
		return this.pregled;
	}

	public void setPregled(Pregled pregled) {
		this.pregled = pregled;
	}

}