import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/FileUpLoadServlet")
@MultipartConfig
public class FileUpLoadServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
		ServletException
	{
		response.setContentType("text/html");
		InputStream is = null;
		FileOutputStream fos = null;
		Part filePart = request.getPart("upfile");
		String fileName = filePart.getName();
		PrintWriter out = response.getWriter();
		try {
			is = filePart.getInputStream();
			String path = getServletContext().getRealPath("/");
			System.out.println("Path is : " + path);
			String filename="kasi";
			fos = new FileOutputStream("/Users/kasireddysangana/eclipse-workspace/FileUpload/WebContent/images/"+filename+".jpg");
			int ch;
			while((ch=is.read())!=-1)
				fos.write(ch);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(is!=null)
					is.close();
				if(fos!=null)
					fos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
