
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

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
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
		Part filePart = request.getPart("file"); // Lấy file từ form
		File saveDir = new File(request.getServletContext().getRealPath("/uploads"));
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		String fileName = filePart.getSubmittedFileName();
		String filePath = saveDir.getAbsolutePath() + fileName;

		// Lưu file vào hệ thống
		filePart.write(filePath);

		// Chuyển đổi file Word thành HTML
		String pdfContent = readPdfContent(filePath);
		String content = convertToHtml(pdfContent);
		request.setAttribute("body", content);
//		WordToHtmlConverter.convertWordToHtml(filePath, htmlPath);
//		try {
//			// Đường dẫn đến file HTML
//			File inputFile = new File("path/to/your/file.html");
//			// Phân tích cú pháp file HTML
//			Document doc = Jsoup.parse(inputFile, "UTF-8");
//
//			// Truy xuất nội dung trong thẻ <body>
//			Element body = doc.body();
//			String bodyContent = body.html(); // Hoặc body.text() để lấy nội dung văn bản
//			// Đặt nội dung HTML vào request attribute
//			request.setAttribute("body", bodyContent);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		request.setAttribute("title", title);
		request.getRequestDispatcher("/admin/views/demo.jsp").forward(request, response);
	}
	
	private String readPdfContent(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            content.append(pdfStripper.getText(document));
        }
        return content.toString();
    }
	
	private String convertToHtml(String pdfContent) {
        // Chuyển đổi nội dung văn bản thành HTML
        return "<pre>" + pdfContent.replaceAll("\n", "<br>") + "</pre>";
    }

}
