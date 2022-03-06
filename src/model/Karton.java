package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Karton database table.
 * 
 */

@Entity
@Table(name="Karton")
@NamedQuery(name="Karton.findAll", query="SELECT k FROM Karton k")
public class Karton implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKarton;

	private String dijagnoza;

	//bi-directional many-to-one association to Pacijent
	@ManyToOne
	@JoinColumn(name="Pacijent_idPacijent")
	private Pacijent pacijent;

	public Karton() {
	}

	public int getIdKarton() {
		return this.idKarton;
	}

	public void setIdKarton(int idKarton) {
		this.idKarton = idKarton;
	}

	public String getDijagnoza() {
		return this.dijagnoza;
	}

	public void setDijagnoza(String dijagnoza) {
		this.dijagnoza = dijagnoza;
	}

	public Pacijent getPacijent() {
		return this.pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

}