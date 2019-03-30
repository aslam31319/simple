package org.jspiders.mvc.login.services.downloadfiles;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
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

@Service
@Transactional
public class GenerateCSV {

	@Autowired
	@Qualifier("fetch")
	private FetchAllUserInf fetchAll;

	public void downloadCSV(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		File file = new File(req.getServletContext().getRealPath("/") + "user.csv");
		this.generateCSV(req);

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

	public void generateCSV(HttpServletRequest req) throws IOException {
		File file = new File(req.getServletContext().getRealPath("/") + "user.csv");

		List<UserDTO> list = fetchAll.fetchAll();
		FileWriter writer = new FileWriter(file);
		writer.write("User Id,First Name,Last Name,Phone,Email,Gender,Date of Birth,Country,State,City");

		for (UserDTO user : list) {
			writer.append('\n');
			writer.append("" + user.getUserId());
			writer.append(',');
			writer.append(user.getFirstName());
			writer.append(',');
			writer.append(user.getLastName());
			writer.append(',');
			writer.append(user.getPhone());
			writer.append(',');
			writer.append(user.getEmail());
			writer.append(',');
			writer.append(user.getGender());
			writer.append(',');
			writer.append(user.getDOB());
			writer.append(',');
			writer.append(user.getCountry());
			writer.append(',');
			writer.append(user.getState());
			writer.append(',');
			writer.append(user.getCity());
			writer.append(',');
		}
		writer.close();
	}
}
