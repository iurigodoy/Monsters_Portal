package br.com.monster.portal.imagem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Upload() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		/*Obtem o caminho relatorio da pasta img*/
		String path = request.getServletContext().getRealPath("img")+ File.separator;
		
		File files = new File(path);
		response.setContentType("image/jpeg");
		
		/*Mostra o arquivo que está na pasta img onde foi realizado o upload*/
		for (String file : files.list()) {
			File f = new File(path + file);
			BufferedImage bi = ImageIO.read(f);
			OutputStream out = response.getOutputStream();
			ImageIO.write(bi, "jpg", out);
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		/*Identifica se o formulario é do tipo multipart/form-data*/
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				/*Faz o parse do request*/
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

				/*Escreve a o arquivo na pasta img*/
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						item.write(new File(request.getServletContext().getRealPath("img")+ File.separator + "uploadfile"));
					}
				}

				request.setAttribute("message", "Arquivo carregado com sucesso");
			} catch (Exception ex) {
				request.setAttribute("message", "Upload de arquivo falhou devido a: "+ ex);
			}

		} else {
			request.setAttribute("message","Desculpe este Servlet lida apenas com pedido de upload de arquivos");
		}

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
