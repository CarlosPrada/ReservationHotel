package ReservationHotel;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "chambre")
public class Chambre implements Serializable {

	private static final long serialVersionUID = 1L;

	public Chambre(Integer idChambre, Integer numero, Integer etage,
			String categorie, Double prix, Boolean disponibilite, Hotel hotel,
			List<Reservation> reservation) {
		super();
		this.idChambre = idChambre;
		this.numero = numero;
		this.etage = etage;
		this.categorie = categorie;
		this.prix = prix;
		this.disponibilite = disponibilite;
		this.hotel = hotel;
		this.reservation = reservation;
	}

	public Chambre() {
		super();
	}

	private Integer idChambre;
	private Integer numero;
	private Integer etage;
	private String categorie;
	private Double prix;
	private Boolean disponibilite;

	private Hotel hotel;
	private List<Reservation> reservation;

	@Id
	@Column(name = "idClient", unique = true, nullable = false)
	public Integer getIdChambre() {
		return idChambre;
	}

	public void setIdChambre(Integer idChambre) {
		this.idChambre = idChambre;
	}

	@Column(name = "numero", nullable = false)
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Column(name = "etage", nullable = false)
	public Integer getEtage() {
		return etage;
	}

	public void setEtage(Integer etage) {
		this.etage = etage;
	}

	@Column(name = "categorie", nullable = false)
	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	@Column(name = "prix", nullable = false)
	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	@Column(name = "disponibilite", nullable = false)
	public Boolean getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(Boolean disponibilite) {
		this.disponibilite = disponibilite;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel", referencedColumnName = "idHotel")
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@ManyToMany(mappedBy = "chambres")
	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

}
