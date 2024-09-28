
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
//import util.convert.WordToHtmlConverter;

import java.io.File;
import java.io.IOException;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;

/**
 * Servlet implementation class AdminServlet
 */
@MultipartConfig()
@WebServlet({ "/admin", "/upload" })
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/admin/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Part img = request.getPart("img");
		File saveDir = new File(request.getServletContext().getRealPath("/uploads"));
		if(!saveDir.exists()) {
			saveDir.mkdirs();
		}
		String path = "/uploads/" + img.getSubmittedFileName();
		String fileName = request.getServletContext().getRealPath(path);
		img.write(fileName);

		request.setAttribute("title", title);
		request.setAttribute("content", content);
		request.setAttribute("img", path);
		request.getRequestDispatcher("/admin/views/demo.jsp").forward(request, response);
//		request.getRequestDispatcher("/admin/views/demo.jsp").include(request, response);
	}
}
