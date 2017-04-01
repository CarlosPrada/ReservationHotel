package domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	public Client(String nom, String prenom,
			Timestamp dateNaissance, String sexe, String adresse, String ville,
			String telephone, String email, String pays, Hotel hotel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.adresse = adresse;
		this.ville = ville;
		this.telephone = telephone;
		this.email = email;
		this.pays = pays;
		this.hotel = hotel;
	}

	public Client() {
		super();
	}

	private Integer idClient;
	private String nom;
	private String prenom;
	private Timestamp dateNaissance;
	private String sexe;
	private String adresse;
	private String ville;
	private String telephone;
	private String email;
	private String pays;
	private Hotel hotel;
	private List<Reservation> reservations;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idClient", unique = true, nullable = false)
	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	@Column(name = "nom", nullable = false)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", nullable = false)
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "dateNaissance", nullable = false)
	public Timestamp getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Timestamp dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Column(name = "sexe", nullable = false)
	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
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

	@Column(name = "telephone", nullable = false)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "pays", nullable = false)
	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@ManyToOne(optional = false, targetEntity = Hotel.class)
	@JoinColumn(name = "idhotel", referencedColumnName = "idhotel")
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}
