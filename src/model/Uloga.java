package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Uloga database table.
 * 
 */
@Entity
@Table(name="Uloga")
@NamedQuery(name="Uloga.findAll", query="SELECT u FROM Uloga u")
public class Uloga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUloga;

	private String naziv;

	//bi-directional many-to-one association to KorisnikUloga
	@OneToMany(mappedBy="uloga")
	private List<KorisnikUloga> korisnikUlogas;

	public Uloga() {
	}

	public int getIdUloga() {
		return this.idUloga;
	}

	public void setIdUloga(int idUloga) {
		this.idUloga = idUloga;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<KorisnikUloga> getKorisnikUlogas() {
		return this.korisnikUlogas;
	}

	public void setKorisnikUlogas(List<KorisnikUloga> korisnikUlogas) {
		this.korisnikUlogas = korisnikUlogas;
	}

	public KorisnikUloga addKorisnikUloga(KorisnikUloga korisnikUloga) {
		getKorisnikUlogas().add(korisnikUloga);
		korisnikUloga.setUloga(this);

		return korisnikUloga;
	}

	public KorisnikUloga removeKorisnikUloga(KorisnikUloga korisnikUloga) {
		getKorisnikUlogas().remove(korisnikUloga);
		korisnikUloga.setUloga(null);

		return korisnikUloga;
	}

}