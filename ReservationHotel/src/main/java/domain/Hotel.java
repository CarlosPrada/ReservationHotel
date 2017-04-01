package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;

	public Hotel() {
		super();
	}

	public Hotel(String adresse, String ville, String pays, Integer nombreEtage) {
		super();

		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
		this.nombreEtage = nombreEtage;
	}

	private Integer idHotel;
	private String adresse;
	private String ville;
	private String pays;
	private Integer nombreEtage;
	private List<Client> clients;
	private List<Chambre> chambres;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdHotel", unique = true, nullable = false)
	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

	@Column(name = "adresse", nullable = false)
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "ville", nullable = false)
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Column(name = "pays", nullable = false)
	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Column(name = "nombreEtage", nullable = false)
	public Integer getNombreEtage() {
		return nombreEtage;
	}

	public void setNombreEtage(Integer nombreEtage) {
		this.nombreEtage = nombreEtage;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hotel")
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hotel")
	public List<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}
}
