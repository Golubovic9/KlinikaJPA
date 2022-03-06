package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Pacijent database table.
 * 
 */
@Entity
@Table(name="Pacijent")
@NamedQuery(name="Pacijent.findAll", query="SELECT p FROM Pacijent p")
public class Pacijent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPacijent;

	private String adresa;

	@Temporal(TemporalType.DATE)
	private Date datumRodjenja;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Anketa
	@OneToMany(mappedBy="pacijent")
	private List<Anketa> anketas;

	//bi-directional many-to-one association to Karton
	@OneToMany(mappedBy="pacijent")
	private List<Karton> kartons;

	//bi-directional many-to-one association to Ocena
	@OneToMany(mappedBy="pacijent")
	private List<Ocena> ocenas;

	//bi-directional many-to-many association to Lekar
	@ManyToMany
	@JoinTable(
		name="OdabraniLekar"
		, joinColumns={
			@JoinColumn(name="Pacijent_idPacijent")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Lekar_idLekar")
			}
		)
	private List<Lekar> lekars;

	//bi-directional many-to-one association to Pregled
	@OneToMany(mappedBy="pacijent")
	private List<Pregled> pregleds;

	public Pacijent() {
	}

	public int getIdPacijent() {
		return this.idPacijent;
	}

	public void setIdPacijent(int idPacijent) {
		this.idPacijent = idPacijent;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
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

	public List<Anketa> getAnketas() {
		return this.anketas;
	}

	public void setAnketas(List<Anketa> anketas) {
		this.anketas = anketas;
	}

	public Anketa addAnketa(Anketa anketa) {
		getAnketas().add(anketa);
		anketa.setPacijent(this);

		return anketa;
	}

	public Anketa removeAnketa(Anketa anketa) {
		getAnketas().remove(anketa);
		anketa.setPacijent(null);

		return anketa;
	}

	public List<Karton> getKartons() {
		return this.kartons;
	}

	public void setKartons(List<Karton> kartons) {
		this.kartons = kartons;
	}

	public Karton addKarton(Karton karton) {
		getKartons().add(karton);
		karton.setPacijent(this);

		return karton;
	}

	public Karton removeKarton(Karton karton) {
		getKartons().remove(karton);
		karton.setPacijent(null);

		return karton;
	}

	public List<Ocena> getOcenas() {
		return this.ocenas;
	}

	public void setOcenas(List<Ocena> ocenas) {
		this.ocenas = ocenas;
	}

	public Ocena addOcena(Ocena ocena) {
		getOcenas().add(ocena);
		ocena.setPacijent(this);

		return ocena;
	}

	public Ocena removeOcena(Ocena ocena) {
		getOcenas().remove(ocena);
		ocena.setPacijent(null);

		return ocena;
	}

	public List<Lekar> getLekars() {
		return this.lekars;
	}

	public void setLekars(List<Lekar> lekars) {
		this.lekars = lekars;
	}

	public List<Pregled> getPregleds() {
		return this.pregleds;
	}

	public void setPregleds(List<Pregled> pregleds) {
		this.pregleds = pregleds;
	}

	public Pregled addPregled(Pregled pregled) {
		getPregleds().add(pregled);
		pregled.setPacijent(this);

		return pregled;
	}

	public Pregled removePregled(Pregled pregled) {
		getPregleds().remove(pregled);
		pregled.setPacijent(null);

		return pregled;
	}

}