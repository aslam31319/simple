package org.jspiders.mvc.login.services.downloadfiles;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.repository.inf.FetchAllUserInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
@Transactional
public class GeneratePDF {

	@Autowired
	@Qualifier("fetch")
	private FetchAllUserInf fetchAll;

	public void downloadPDF(HttpServletRequest req, HttpServletResponse resp) throws IOException, DocumentException {
		this.generatePDF(req);
		File file = new File(req.getServletContext().getRealPath("/") + "user.pdf");

		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if (mimeType == null) {
			System.out.println("mimetype : " + mimeType);
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}
		System.out.println("mimetype by Auto : " + mimeType);
		resp.setContentType(mimeType);
		resp.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
		resp.setContentLength((int) file.length());

		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(inputStream, resp.getOutputStream());

	}

	public void generatePDF(HttpServletRequest req) throws IOException, DocumentException {

		Document my_pdf_report = new Document();
		PdfWriter.getInstance(my_pdf_report,
				new FileOutputStream(req.getServletContext().getRealPath("/") + "user.pdf"));
		my_pdf_report.open();

		// we have four columns in our table
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100); // Width 100%
		table.setSpacingBefore(10f); // Space before table
		table.setSpacingAfter(10f); // Space after table
		float[] columnWidths = { .5f, .75f, .75f, .65f, 1f };
		table.setWidths(columnWidths);

		// create a cell object
		PdfPCell table_cell;
		Font head = FontFactory.getFont(FontFactory.TIMES_BOLD);
		table_cell = new PdfPCell(new Paragraph("User Id", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("First Name", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("Second Name", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("Phone", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("Email", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		/*
		 * table_cell = new PdfPCell(new Phrase("Gender")); table.addCell(table_cell);
		 * table_cell = new PdfPCell(new Phrase("Date of birth"));
		 * table.addCell(table_cell); table_cell = new PdfPCell(new Phrase("Country"));
		 * table.addCell(table_cell); table_cell = new PdfPCell(new Phrase("State"));
		 * table.addCell(table_cell); table_cell = new PdfPCell(new Phrase("City"));
		 * table.addCell(table_cell);
		 */

		// fetching all data
		List<UserDTO> list = fetchAll.fetchAll();

		for (UserDTO user : list) {

			table_cell = new PdfPCell(new Phrase("" + user.getUserId()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getFirstName()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getLastName()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getPhone()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getEmail()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			/*
			 * table_cell = new PdfPCell(new Phrase(user.getGender()));
			 * table.addCell(table_cell); table_cell = new PdfPCell(new
			 * Phrase(user.getDOB())); table.addCell(table_cell); table_cell = new
			 * PdfPCell(new Phrase(user.getCountry())); table.addCell(table_cell);
			 * table_cell = new PdfPCell(new Phrase(user.getState()));
			 * table.addCell(table_cell); table_cell = new PdfPCell(new
			 * Phrase(user.getCity())); table.addCell(table_cell);
			 */
		}

		my_pdf_report.add(table);
		table.flushContent();

		table_cell = new PdfPCell(new Phrase("Gender", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("Date of birth", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("Country", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("State", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);
		table_cell = new PdfPCell(new Phrase("City", head));
		table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(table_cell);

		for (UserDTO user : list) {

			table_cell = new PdfPCell(new Phrase(user.getGender()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getDOB()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getCountry()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getState()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);
			table_cell = new PdfPCell(new Phrase(user.getCity()));
			table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table_cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(table_cell);

		}
		my_pdf_report.add(table);
		my_pdf_report.close();

	}
}
