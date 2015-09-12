package edu.sample.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sample.spring.mvc.model.Reservation;
import edu.sample.spring.mvc.service.ReservationService;

@Controller
@RequestMapping("/reservationSummary*")
public class ExcelPdfController {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String generateSummary(
			@RequestParam(required = true, value = "id") int id, Model model) {
		
		Reservation reservation = reservationService.findById(id);
		
		if (reservation == null) {
			throw new IllegalArgumentException("Reservation not found. id: " + id);
		}
		
		model.addAttribute("reservation", reservation);
		
		return "reservationSummary";
	}

}
