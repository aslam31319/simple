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

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.repository.inf.FetchAllUserInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;

@Service
@Transactional
public class GenerateXLSX {

	@Autowired
	@Qualifier("fetch")
	private FetchAllUserInf fetchAll;

	public void downloadXLSX(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		this.generateXLSX(req);

		// opening file
		File file = new File(req.getServletContext().getRealPath("/") + "user.xlsx");

		// setting mime type
		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if (mimeType == null) {
			System.out.println("mimetype : " + mimeType);
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}
		System.out.println("mimetype by Auto : " + mimeType);
		resp.setContentType(mimeType);
		System.out.println(file.getName());
		// setting header
		resp.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
		resp.setContentLength((int) file.length());

		// copying to response
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(inputStream, resp.getOutputStream());
	}

	public void generateXLSX(HttpServletRequest req) throws IOException {

		// fetching all data
		List<UserDTO> list = fetchAll.fetchAll();

		// creating XLSX
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("User Details");
		XSSFRow row = spreadsheet.createRow(1);
		XSSFCell cell;
		cell = row.createCell(1);
		cell.setCellValue("User Id");
		cell = row.createCell(2);
		cell.setCellValue("First Name");
		cell = row.createCell(3);
		cell.setCellValue("Last Name");
		cell = row.createCell(4);
		cell.setCellValue("Phone");
		cell = row.createCell(5);
		cell.setCellValue("Email");
		cell = row.createCell(6);
		cell.setCellValue("Gender");
		cell = row.createCell(7);
		cell.setCellValue("Date of birth");
		cell = row.createCell(8);
		cell.setCellValue("Country");
		cell = row.createCell(9);
		cell.setCellValue("State");
		cell = row.createCell(10);
		cell.setCellValue("City");
		int i = 2;
		for (UserDTO user : list) {

			row = spreadsheet.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue(user.getUserId());
			cell = row.createCell(2);
			cell.setCellValue(user.getFirstName());
			cell = row.createCell(3);
			cell.setCellValue(user.getLastName());
			cell = row.createCell(4);
			cell.setCellValue(user.getPhone());
			cell = row.createCell(5);
			cell.setCellValue(user.getEmail());
			cell = row.createCell(6);
			cell.setCellValue(user.getGender());
			cell = row.createCell(7);
			cell.setCellValue(user.getDOB());
			cell = row.createCell(8);
			cell.setCellValue(user.getCountry());
			cell = row.createCell(9);
			cell.setCellValue(user.getState());
			cell = row.createCell(10);
			cell.setCellValue(user.getCity());
			i++;

		}

		// saving to file
		FileOutputStream out = new FileOutputStream(new File(req.getServletContext().getRealPath("/") + "user.xlsx"));
		workbook.write(out);
		out.close();
		workbook.close();

	}

}
