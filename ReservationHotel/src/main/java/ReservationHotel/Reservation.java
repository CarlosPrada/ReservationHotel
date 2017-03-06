package ReservationHotel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;

	public Reservation(Integer idReservation, Date dateReservation,
			Date dateArrive, Date dateSortie, List<Chambre> chambres,
			Client client) {
		super();
		this.idReservation = idReservation;
		this.dateReservation = dateReservation;
		this.dateArrive = dateArrive;
		this.dateSortie = dateSortie;
		this.chambres = chambres;
		this.client = client;
	}

	public Reservation() {
		super();
	}

	private Integer idReservation;
	private Date dateReservation;
	private Date dateArrive;
	private Date dateSortie;
	private List<Chambre> chambres;
	private Client client;

	@Id
	@Column(name = "idReservation", unique = true, nullable = false)
	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	@Column(name = "dateReservation", nullable = false)
	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	@Column(name = "dateArrive", nullable = false)
	public Date getDateArrive() {
		return dateArrive;
	}

	public void setDateArrive(Date dateArrive) {
		this.dateArrive = dateArrive;
	}

	@Column(name = "dateSortie", nullable = false)
	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	@ManyToMany
	public List<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client", referencedColumnName = "idClient")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
