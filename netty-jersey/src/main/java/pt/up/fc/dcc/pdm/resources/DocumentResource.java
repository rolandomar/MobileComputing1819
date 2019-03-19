package pt.up.fc.dcc.pdm.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pt.up.fc.dcc.pdm.core.DocumentManager;

import com.google.inject.Inject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

@Path("/resources")
public class DocumentResource {
	private final DocumentManager manager;

	@Inject
	public DocumentResource(DocumentManager manager) {
		this.manager = manager;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap getResources() {
		return manager.getResources();
	}

	@POST
	//@Consumes(MediaType.APPLICATION_JSON)
	public void createResource(String content) {
		System.out.println("Post called");
		System.out.println("value>"+content+"<");
		manager.createResource(content);
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResourceById(@PathParam("id") int id) throws IOException {
		File file = manager.getResources().get(id);
		if(file==null) {
			return Response.status(Response.Status.NOT_FOUND).entity("File not found for ID: " + id).build();
		}
		return Response.ok(new String(Files.readAllBytes(Paths.get(manager.getResources().get(id).getPath()))), MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteResourceById(@PathParam("id") int id) throws IOException {
		if(manager.getResources().remove(id)!=null) {
			return Response.ok().build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).entity("File not found for ID: " + id).build();
		}
	}


}