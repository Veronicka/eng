package fatec.com.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javafx.scene.chart.PieChart.Data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import jdk.nashorn.internal.parser.JSONParser;
import fatec.com.model.Categoria;
import fatec.com.model.Inventario;

@WebServlet("/salvar")
public class Salvar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Categoria ca;
	private static int id = 3;

	public Salvar() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		
		String nome = request.getParameter("nome");
		System.out.println(nome);
		
		DateFormat data = DateFormat.getDateTimeInstance();
		
		if (nome != null && !nome.isEmpty()) {
			id++;
			
			ca = new Categoria(id, nome, data.format(d)+"");
			Inventario.getInstance().inventario.add(ca);
			System.out.println(nome+" ae");

			String json = new Gson().toJson(ca);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			
			
		} else {
			String retorno = "{\"nome\":\"Campo Obrigatorio\"}";
			response.getWriter().write(retorno);
			response.setStatus(400);
		}
						
	}

}
