package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Pregled database table.
 * 
 */
@Entity
@Table(name="Pregled")
@NamedQuery(name="Pregled.findAll", query="SELECT p FROM Pregled p")
public class Pregled implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPregled;

	@Temporal(TemporalType.DATE)
	private Date datum;

	//bi-directional many-to-one association to Lekar
	@ManyToOne
	@JoinColumn(name="Lekar_idLekar")
	private Lekar lekar;

	//bi-directional many-to-one association to Pacijent
	@ManyToOne
	@JoinColumn(name="Pacijent_idPacijent")
	private Pacijent pacijent;

	//bi-directional many-to-one association to Recept
	@OneToMany(mappedBy="pregled")
	private List<Recept> recepts;

	public Pregled() {
	}

	public int getIdPregled() {
		return this.idPregled;
	}

	public void setIdPregled(int idPregled) {
		this.idPregled = idPregled;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
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

	public List<Recept> getRecepts() {
		return this.recepts;
	}

	public void setRecepts(List<Recept> recepts) {
		this.recepts = recepts;
	}
	
	public String proveriDatum() {
		String date = this.datum.toString();
		String datum = date.substring(0,7 );
		return datum;
	}

	public Recept addRecept(Recept recept) {
		getRecepts().add(recept);
		recept.setPregled(this);

		return recept;
	}

	public Recept removeRecept(Recept recept) {
		getRecepts().remove(recept);
		recept.setPregled(null);

		return recept;
	}

}