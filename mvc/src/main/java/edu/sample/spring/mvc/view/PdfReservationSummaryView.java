/*
 * ----------------------------------------------------------------------------
 * Creating PDF View
 * 
 * Spring provides AbstractPdfView for itext lowagie
 * 
 * Note:
 * need to create resolvers for pdf view.
 * This example uses resource bundle.
 * ----------------------------------------------------------------------------
 */
package edu.sample.spring.mvc.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import edu.sample.spring.mvc.model.Reservation;

public class PdfReservationSummaryView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Reservation reservation = (Reservation) model.get("reservation");
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		
		Table table = new Table(4);
		table.addCell("ID");
		table.addCell("Court name");
		table.addCell("Date");
		table.addCell("Hour");
		
		table.addCell(Integer.toString(reservation.getId()));
		table.addCell(reservation.getCourtName());
		table.addCell(df.format(reservation.getDate()));
		table.addCell(Integer.toString(reservation.getHour()));
		document.add(table);
	}

}
