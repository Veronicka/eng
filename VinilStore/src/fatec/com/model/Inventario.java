package fatec.com.model;

import java.util.ArrayList;

public class Inventario {
	public static Inventario instance;
	public static ArrayList<Categoria> inventario;

	public static Inventario getInstance(){
		if(instance == null){
			instance = new Inventario();
		}
		return instance;
	}
	
	private Inventario() {
		inventario = new ArrayList<Categoria>();
		Categoria ca = new Categoria(1, "Michael Jackson", "01/10/2015");
		Inventario.inventario.add(ca);
		ca = new Categoria(2, "Foo Fighters", "29/09/2015");
		Inventario.inventario.add(ca);
		ca = new Categoria(3, "Madonna", "02/10/2015");
		Inventario.inventario.add(ca);
	}
	
	public static ArrayList<Categoria> getInventario() {
		return inventario;
	}


}
