package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the KorisnikUloga database table.
 * 
 */
@Entity
@Table(name="KorisnikUloga")
@NamedQuery(name="KorisnikUloga.findAll", query="SELECT k FROM KorisnikUloga k")
public class KorisnikUloga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKorisnikUloga;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="Korisnik_idKorisnik")
	private Korisnik korisnik;

	//bi-directional many-to-one association to Uloga
	@ManyToOne
	@JoinColumn(name="Uloga_idUloga")
	private Uloga uloga;

	public KorisnikUloga() {
	}

	public int getIdKorisnikUloga() {
		return this.idKorisnikUloga;
	}

	public void setIdKorisnikUloga(int idKorisnikUloga) {
		this.idKorisnikUloga = idKorisnikUloga;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Uloga getUloga() {
		return this.uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

}