package edu.sample.spring.mvc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.sample.spring.mvc.model.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Override
	public Reservation findById(int id) {
		Reservation result = null;
		for (Reservation reservation : getSample()) {
			if (reservation.getId() == id) {
				result = reservation;
			}
		}
		return result;
	}
	
	private List<Reservation> getSample() {
		List<Reservation> samples = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			Reservation reservation = new Reservation();
			reservation.setId(i);
			reservation.setCourtName("Court name " + i);
			reservation.setDate(new Date());
			reservation.setHour(i);
		}
		return samples;
	}

}
