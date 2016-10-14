package com.calculator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

@Component
@Path("operation")
public class CalculatorController {

	@GET
    @Produces("application/json")
    public Response health() {
        return Response.status(Status.OK).entity("Opeation: sum 2 numbers").build();
    }
	
	@Path("{a}/{b}")
	@GET
	@Produces("application/json")																																																																																																			
	public Response add(@PathParam("a") Double a, @PathParam("b") Double b) {
				
		if (a < 0 || b < 0) {
			return Response.status(Status.BAD_REQUEST).entity("Invalid number!").build();
		}
		
		Double sum = a + b;
 
		String result = " Result: " + sum;
		return Response.status(Status.OK).entity(result).build();
	}

	
}
