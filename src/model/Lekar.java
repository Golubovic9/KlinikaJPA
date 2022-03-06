package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Lekar database table.
 * 
 */
@Entity
@Table(name="Lekar")
@NamedQuery(name="Lekar.findAll", query="SELECT l FROM Lekar l")
public class Lekar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLekar;

	private String ime;

	private String prezime;

	private String specijalnost;

	//bi-directional many-to-one association to Ocena
	@OneToMany(mappedBy="lekar")
	private List<Ocena> ocenas;

	//bi-directional many-to-many association to Pacijent
	@ManyToMany(mappedBy="lekars")
	private List<Pacijent> pacijents;

	//bi-directional many-to-one association to Pregled
	@OneToMany(mappedBy="lekar")
	private List<Pregled> pregleds;

	public Lekar() {
	}

	public int getIdLekar() {
		return this.idLekar;
	}

	public void setIdLekar(int idLekar) {
		this.idLekar = idLekar;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getSpecijalnost() {
		return this.specijalnost;
	}

	public void setSpecijalnost(String specijalnost) {
		this.specijalnost = specijalnost;
	}

	public List<Ocena> getOcenas() {
		return this.ocenas;
	}

	public void setOcenas(List<Ocena> ocenas) {
		this.ocenas = ocenas;
	}

	public Ocena addOcena(Ocena ocena) {
		getOcenas().add(ocena);
		ocena.setLekar(this);

		return ocena;
	}

	public Ocena removeOcena(Ocena ocena) {
		getOcenas().remove(ocena);
		ocena.setLekar(null);

		return ocena;
	}

	public List<Pacijent> getPacijents() {
		return this.pacijents;
	}

	public void setPacijents(List<Pacijent> pacijents) {
		this.pacijents = pacijents;
	}

	public List<Pregled> getPregleds() {
		return this.pregleds;
	}

	public void setPregleds(List<Pregled> pregleds) {
		this.pregleds = pregleds;
	}

	public Pregled addPregled(Pregled pregled) {
		getPregleds().add(pregled);
		pregled.setLekar(this);

		return pregled;
	}

	public Pregled removePregled(Pregled pregled) {
		getPregleds().remove(pregled);
		pregled.setLekar(null);

		return pregled;
	}

}