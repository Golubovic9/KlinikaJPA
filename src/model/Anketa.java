package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Anketa database table.
 * 
 */
@Entity
@Table(name="Anketa")
@NamedQuery(name="Anketa.findAll", query="SELECT a FROM Anketa a")
public class Anketa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAnketa;

	private String odgovor;

	//bi-directional many-to-one association to Pacijent
	@ManyToOne
	@JoinColumn(name="Pacijent_idPacijent")
	private Pacijent pacijent;

	public Anketa() {
	}

	public int getIdAnketa() {
		return this.idAnketa;
	}

	public void setIdAnketa(int idAnketa) {
		this.idAnketa = idAnketa;
	}

	public String getOdgovor() {
		return this.odgovor;
	}

	public void setOdgovor(String odgovor) {
		this.odgovor = odgovor;
	}

	public Pacijent getPacijent() {
		return this.pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

}