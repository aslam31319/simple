package org.jspiders.mvc.login.services;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jspiders.mvc.login.services.downloadfiles.GenerateCSV;
import org.jspiders.mvc.login.services.downloadfiles.GeneratePDF;
import org.jspiders.mvc.login.services.downloadfiles.GenerateXLSX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;

@Service
public class DownloadService {
	
	@Autowired
	private GenerateCSV getCSV;

	@Autowired
	private GeneratePDF getPDF;

	@Autowired
	private GenerateXLSX getXLSX;
	public void downloadFile(HttpServletRequest req,HttpServletResponse resp,String fileEXT) {
		
		if (fileEXT.equals("XLSX")) {

			try {
				getXLSX.downloadXLSX(req, resp);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (fileEXT.equals("PDF")) {

			try {
				getPDF.downloadPDF(req, resp);
			} catch (IOException | DocumentException e) {
				e.printStackTrace();
			}
		}
		if (fileEXT.equals("CSV")) {
			try {
				getCSV.downloadCSV(req, resp);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
