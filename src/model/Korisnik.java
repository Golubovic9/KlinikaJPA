package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Korisnik database table.
 * 
 */
// veza izmedju objekta klase Korisnik i objekta klase Lekar/Pacijent ostvarena je 
// u fajlu Korisnici.txt na nacin kao sto je opisano u kontolerima pacijent i lekar
@Entity
@Table(name="Korisnik")
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnik;

	private String ime;

	private String korisnickoIme;

	private String lozinka;

	private String prezime;

	//bi-directional many-to-one association to KorisnikUloga
	@OneToMany(fetch= FetchType.EAGER,cascade = {CascadeType.ALL})
	@JoinColumn(name = "Korisnik_idKorisnik",referencedColumnName="idKorisnik")
	private List<KorisnikUloga> korisnikUlogas;

	public Korisnik() {
	}

	public int getIdKorisnik() {
		return this.idKorisnik;
	}

	public void setIdKorisnik(int idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getKorisnickoIme() {
		return this.korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return this.lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<KorisnikUloga> getKorisnikUlogas() {
		return this.korisnikUlogas;
	}

	public void setKorisnikUlogas(List<KorisnikUloga> korisnikUlogas) {
		this.korisnikUlogas = korisnikUlogas;
	}

	public KorisnikUloga addKorisnikUloga(KorisnikUloga korisnikUloga) {
		getKorisnikUlogas().add(korisnikUloga);
		korisnikUloga.setKorisnik(this);

		return korisnikUloga;
	}

	public KorisnikUloga removeKorisnikUloga(KorisnikUloga korisnikUloga) {
		getKorisnikUlogas().remove(korisnikUloga);
		korisnikUloga.setKorisnik(null);

		return korisnikUloga;
	}

}