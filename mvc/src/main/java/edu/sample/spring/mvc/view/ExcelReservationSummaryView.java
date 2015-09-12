package edu.sample.spring.mvc.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import edu.sample.spring.mvc.model.Reservation;

public class ExcelReservationSummaryView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Reservation reservation = (Reservation) model.get("reservation");
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		HSSFSheet sheet = workbook.createSheet();
		
		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("Court name");
		header.createCell(1).setCellValue("Date");
		header.createCell(2).setCellValue("Hour");
		
		HSSFRow row = sheet.createRow(1);
		row.createCell(0).setCellValue(reservation.getCourtName());
		row.createCell(1).setCellValue(df.format(reservation.getDate()));
		row.createCell(2).setCellValue(reservation.getHour());
	}

}
