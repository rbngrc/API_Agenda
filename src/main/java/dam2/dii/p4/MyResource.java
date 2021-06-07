package dam2.dii.p4;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("contact")
public class MyResource {

	private static GestorDatos gd = new GestorDatos();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Contacto> getList() {
		return gd.listaContactos();
	}

	@GET
	@Path("size")
	@Produces(MediaType.TEXT_PLAIN)
	public int getListSize(@QueryParam("c") String codigo) {
		int size = gd.tamanoLista();
		return size;
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String insertContact(@DefaultValue("") @QueryParam("n") String nombre,
			@DefaultValue("") @QueryParam("a1") String apellido1,
			@DefaultValue("") @QueryParam("a2") String apellido2,
			@DefaultValue("") @QueryParam("e") String email,
			@DefaultValue("") @QueryParam("t") String telefono,
			@DefaultValue("") @QueryParam("c") String comentarios) {

		String mensaje = "";

		if (nombre.equals("") || apellido1.equals("") || apellido2.equals("") 
		|| email.equals("") || telefono.equals("")|| comentarios.equals("")) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST)
						.entity("Por favor rellene los campos")
						.build());
		} else {
			Contacto contacto = new Contacto(nombre, apellido1, apellido2, email, telefono, comentarios);
			boolean insercion = gd.insertarContacto(contacto);

			if (insercion) {
				gd.insertarContacto(contacto);
				mensaje = "Se ha anadido correctamente";
			} else {
				mensaje = "Ya existe un contacto con ese email";
			}
		}

		return mensaje;
	}

	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public String deletContact(@QueryParam("e") String email) {
		boolean eliminar = gd.eliminarContacto(email);
		String mensaje = "";

		if (email == null) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("Por favor rellene los campos").build());
		} else {
			if (eliminar) {
				mensaje = "Se ha eliminado correctamente";
			} else {
				mensaje = "No se ha podido eliminar el contacto";
			}
		}

		return mensaje;
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	public String updateContact(@DefaultValue("") @QueryParam("n") String nombre,
			@DefaultValue("") @QueryParam("a1") String apellido1,
			@DefaultValue("") @QueryParam("a2") String apellido2,
			@DefaultValue("") @QueryParam("e") String email,
			@DefaultValue("") @QueryParam("t") String telefono,
			@DefaultValue("") @QueryParam("c") String comentarios) {

		String mensaje = "";

		if (nombre.equals("") || apellido1.equals("") || apellido2.equals("") 
		|| email.equals("") || telefono.equals("")|| comentarios.equals("")) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST)
						.entity("Por favor rellene los campos")
						.build());
		} else {
			Contacto contacto = new Contacto(nombre, apellido1, apellido2, email, telefono, comentarios);
	
			boolean actualizacion = gd.actualizarContacto(contacto);
			boolean existe = gd.compruebaLista(contacto);
	
			if (existe) {
				if (actualizacion) {
					gd.insertarContacto(contacto);
					mensaje = "Se ha actualizado correctamente";
				} else {
					mensaje = "No se ha podido actualizar";
				}
			} else {
				mensaje = "El usuario no existe";
			}

		}

		return mensaje;
	}

}
