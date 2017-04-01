package main;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import domain.Chambre;
import domain.Client;
import domain.Hotel;
import domain.Reservation;
import service.ServiceReservation;

@SpringBootApplication
public class ReservationHotelApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(ReservationHotelApplication.class, args);

		System.out.println("TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-TEST-");

		ServiceReservation serviceReservation = new ServiceReservation();

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateFormat.parse("07/11/1991");
		long time = date.getTime();
		Timestamp dateNaissance = new Timestamp(time);
		Hotel hotel = serviceReservation.getHotel(752);
		List<Chambre> chambresList = serviceReservation.getChambreList();

		// Test Insert Hotel
		// Hotel hotel = new Hotel("Rue 1", "Paris", "France", 4);
		// serviceReservation.addHotel(hotel);

		// Test Insert Chambre
		// Chambre chambre = new Chambre(2, 1, "double", 50.0, true, hotel);
		// serviceReservation.addChambre(chambre);

		// Test Insert Client
		// Client client = new Client("Prada", "Carlos", dateNaissance, "H",
		// "24,26 Rue André Karman ", "Aubervilliers",
		// "0769305696", "carlos.prada;remolina@gmail.com", "Colombie", hotel);
		// serviceReservation.addClient(client);

		// Test Insert Client
		Client client = serviceReservation.getClientByID(1);
		Reservation reservation = new Reservation(dateNaissance, dateNaissance, dateNaissance, client);
		serviceReservation.addReservation(reservation, chambresList);

	}
}
