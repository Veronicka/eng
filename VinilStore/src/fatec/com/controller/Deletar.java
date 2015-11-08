package fatec.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fatec.com.model.Categoria;
import fatec.com.model.Inventario;

@WebServlet("/deletar")
public class Deletar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Deletar(){
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		String i = request.getParameter("id");
		

		if (i != null) {

			try {
				id = Integer.parseInt(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
			for (Categoria c : Inventario.getInstance().inventario) {
				if (c.getId().equals(id)) {
					Inventario.getInstance().inventario.remove(c);
				}

			}
			String retorno = "{\"nome\":\"Sucesso\"}";
			response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
			response.getWriter().write(retorno);

		} else {
			String retorno = "{\"nome\":\"Campo Obrigatorio\"}";
			response.getWriter().write(retorno);
			response.setStatus(400);
		}

	}

}
