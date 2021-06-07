package dam2.dii.p4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestorDatos {
	
	private Map<String, Contacto> listaContactos = cargarContactos();
	
	private static Map<String, Contacto> cargarContactos(){
		Map<String, Contacto> lista = new HashMap<String, Contacto>();
		
		Contacto c = new Contacto("Pedro", "Pedrez", "Pedrez", "pedro@pedrez.com", "123112233",
				"Sin comentarios");
		lista.put("pedro@pedrez.com", c);
		
		c = new Contacto("Gonzalo", "Gonzalez", "Gonzalez", "gonzalo@gonzalez.com", "456112233",
				"Sin comentarios");
		lista.put("gonzalo@gonzalez.com", c);
		
		c = new Contacto("Ramiro", "Ramirez", "Ramirez", "ramiro@ramirez.com", "789112233",
				"Sin comentarios");
		lista.put("ramiro@ramirez.com", c);
		
		return lista;
	}
	
	public ArrayList<Contacto> listaContactos(){
		ArrayList<Contacto> listado = new ArrayList<>();
		
		for(Map.Entry<String, Contacto> entry : listaContactos.entrySet()) {
			Contacto c = entry.getValue();
			listado.add(c);
		}
		
		return listado;
	}
	
	public Contacto leerContactos(String clave) {
		Contacto c = listaContactos.get(clave);
		
		return c;
	}
	
	public int tamanoLista() {
		return listaContactos.size();
	}
	
	public boolean insertarContacto(Contacto contacto) {
		boolean resultado = false;
		if (!listaContactos.containsKey(contacto.getEmail())) {
			listaContactos.put(contacto.getEmail(), contacto);
			resultado = true;
		}
		return resultado;
	}
	
	public boolean eliminarContacto(String email) {
		boolean resultado = false;
		if (listaContactos.containsKey(email)) {
			listaContactos.remove(email);
			resultado = true;
		}
		return resultado;
	}
	
	public boolean actualizarContacto(Contacto contacto) {
		boolean resultado = false;
		if (listaContactos.containsKey(contacto.getEmail())) {
			listaContactos.replace(contacto.getEmail(), null);
			listaContactos.replace(contacto.getEmail(), contacto);
			resultado = true;
		}
		return resultado;
	}
	
	public boolean compruebaLista (Contacto contacto) {
		boolean resultado = false;
		if (listaContactos.containsKey(contacto.getEmail())){
			return true;
		}
		return resultado;
	}

}
