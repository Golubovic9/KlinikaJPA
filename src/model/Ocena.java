package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Ocena database table.
 * 
 */
@Entity
@Table(name="Ocena")
@NamedQuery(name="Ocena.findAll", query="SELECT o FROM Ocena o")
public class Ocena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOcena;

	private int ocena;

	//bi-directional many-to-one association to Lekar
	@ManyToOne
	@JoinColumn(name="Lekar_idLekar")
	private Lekar lekar;

	//bi-directional many-to-one association to Pacijent
	@ManyToOne
	@JoinColumn(name="Pacijent_idPacijent")
	private Pacijent pacijent;

	public Ocena() {
	}

	public int getIdOcena() {
		return this.idOcena;
	}

	public void setIdOcena(int idOcena) {
		this.idOcena = idOcena;
	}

	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Lekar getLekar() {
		return this.lekar;
	}

	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}

	public Pacijent getPacijent() {
		return this.pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

}