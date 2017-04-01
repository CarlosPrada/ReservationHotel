package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Chambre;
import domain.Client;
import domain.Hotel;
import domain.Reservation;

public class ServiceReservation {

	EntityManager entityManager;

	public ServiceReservation() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		entityManager = emf.createEntityManager();
	}

	public void addHotel(Hotel hotel) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(hotel);
		tx.commit();
	}

	public Hotel getHotel(Integer idHotel) {
		Hotel hotel = (Hotel) entityManager.find(Hotel.class, idHotel);
		return hotel;
	}

	public void addChambre(Chambre chambre) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(chambre);
		tx.commit();
	}

	public void addClient(Client client) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(client);
		tx.commit();
	}

	public void addReservation(Reservation reservation, List<Chambre> chambresList) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(reservation);
		reservation.getChambres().addAll(chambresList);
		entityManager.merge(reservation);
		tx.commit();
	}

	public List<Chambre> getChambreList() {
		List<Chambre> chambresList = (List<Chambre>) entityManager
				.createQuery("SELECT C FROM Chambre C WHERE C.disponibilite = true").getResultList();
		return chambresList;
	}

	public Client getClientByID(Integer idClient) {
		Client client = (Client) entityManager.find(Client.class, idClient);
		return client;
	}

	/**
	 * Recherche dans la base de données des chambres JPA et création d'une
	 * liste de voiture (Data Transfert Object) pour retourner au web service.
	 * 
	 * @return
	 */
	// public List<com.descartes.web.Voiture> listerVoitures(){
	// List voituresJPA = entityManager.createQuery("select v from Voiture
	// v").getResultList();
	// List<com.descartes.web.Voiture> voituresDTO = new
	// ArrayList<com.descartes.web.Voiture>();
	// com.descartes.domain.Voiture jpa;
	// for(int i=0; i<voituresJPA.size(); i++){
	// jpa = (Voiture) voituresJPA.get(i);
	// com.descartes.web.Voiture dto = new
	// com.descartes.web.Voiture(jpa.getImmatriculation(), jpa.getMarque());
	// voituresDTO.add(dto);
	// }
	// return voituresDTO;
	// }
	//

	String query = "SELECT P" + " FROM HceMedPaquete P" + " WHERE indHabilitado = :indHabHceMedPaquete"
			+ " AND P.idPaquete" + " IN (SELECT HMU.id.idUsual" + " FROM HceMedUsual HMU"
			+ " WHERE HMU.id.idMedicamento" + " IN (:listVademecum))";

}
