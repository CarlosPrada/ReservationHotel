package domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;

	public Reservation(Timestamp dateReservation, Timestamp dateArrive, Timestamp dateSortie, Client client) {
		super();
		this.dateReservation = dateReservation;
		this.dateArrive = dateArrive;
		this.dateSortie = dateSortie;
		this.chambres = new ArrayList<Chambre>();
		this.client = client;
	}

	public Reservation() {
		super();
	}

	private Integer idReservation;
	private Timestamp dateReservation;
	private Timestamp dateArrive;
	private Timestamp dateSortie;
	private List<Chambre> chambres;
	private Client client;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReservation", unique = true, nullable = false)
	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	@Column(name = "dateReservation", nullable = false)
	public Timestamp getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Timestamp dateReservation) {
		this.dateReservation = dateReservation;
	}

	@Column(name = "dateArrive", nullable = false)
	public Timestamp getDateArrive() {
		return dateArrive;
	}

	public void setDateArrive(Timestamp dateArrive) {
		this.dateArrive = dateArrive;
	}

	@Column(name = "dateSortie", nullable = false)
	public Timestamp getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Timestamp dateSortie) {
		this.dateSortie = dateSortie;
	}

	@ManyToMany()
	@JoinTable(name = "reservation_chambre", joinColumns = @JoinColumn(name = "idReservation", referencedColumnName = "idReservation"), inverseJoinColumns = @JoinColumn(name = "idChambre", referencedColumnName = "idChambre"))
	//@JoinTable(name = "reservation_chambres", joinColumns = @JoinColumn(name = "idReservation", referencedColumnName = "idReservation"), inverseJoinColumns = @JoinColumn(name = "idChambre", referencedColumnName = "idChambre"))
	public List<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idClient", referencedColumnName = "idClient")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
