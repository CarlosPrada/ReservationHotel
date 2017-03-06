package ReservationHotel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel implements Serializable  {

	private static final long serialVersionUID = 1L;

	public Hotel() {
		super();
	}

	public Hotel(Integer idHotel, String adresse, String ville, String pays,
			Integer etageMax, List<Client> clients, List<Chambre> chambres) {
		super();
		this.idHotel = idHotel;
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
		this.etageMax = etageMax;
		this.clients = clients;
		this.chambres = chambres;
	}

	private Integer idHotel;
	private String adresse;
	private String ville;
	private String pays;
	private Integer etageMax;
	private List<Client> clients;
	private List<Chambre> chambres;

	@Id
	@Column(name = "IdHotel", unique = true, nullable = false)
	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Integer getEtageMax() {
		return etageMax;
	}

	public void setEtageMax(Integer etageMax) {
		this.etageMax = etageMax;
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
