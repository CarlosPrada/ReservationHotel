package web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import service.ServiceReservation;

@Controller
public class ControllerReservation {

	ServiceReservation serviceReservation = new ServiceReservation();

//	@RequestMapping(value = "/voitures", method = RequestMethod.GET)
//	@ResponseBody
//	@ResponseStatus(HttpStatus.OK)
//	public List<Voiture> getListeVoiture() {
//		return serviceLocation.listerVoitures();
//	}

//	@RequestMapping(value = "/voiture", method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.OK)
//	public void addVoitureParBodyHTTP(@RequestBody Voiture voiture) {
//		serviceLocation.ajouterVoiture(voiture);
//	}

//	@RequestMapping(value = "/voiture", method = RequestMethod.PUT)
//	@ResponseStatus(HttpStatus.OK)
//	public void modifierVoiture(@RequestBody Voiture voiture) {
//		System.out.println("modifierVoiture : " + voiture);
//		// ...
//	}

//	@RequestMapping(value="/voiture", method=RequestMethod.DELETE)
//		@ResponseStatus(HttpStatus.OK)
//		public void deleteVoiture( @RequestBody Voiture voiture){
//			System.out.println("deleteVoiture : " + voiture);
//			// ...
//	}

}
