package dam2.dii.p4;

import java.io.Serializable;

public class Contacto implements Serializable {

	private String nombre;
	private String apellido1;
	private String apellido2;
	private String email;
	private String telefono;
	private String comentarios;

	public Contacto() {
		super();
	}

	public Contacto(String nombre, String apellido1, String apellido2, String email, String telefono,
			String comentarios) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.email = email;
		this.telefono = telefono;
		this.comentarios = comentarios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", email="
				+ email + ", telefono=" + telefono + ", comentarios=" + comentarios + "]";
	}
	
}
