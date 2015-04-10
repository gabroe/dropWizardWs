package com.example.helloworld.resources;

import com.wordnik.swagger.annotations.ApiParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/products")
@com.wordnik.swagger.annotations.Api(value = "/products", description = "the products API")
@Produces({ "application/json" })
public class ProductsApi {

	@GET
	@com.wordnik.swagger.annotations.ApiOperation(value = "Product Types", notes = "The Products endpoint returns information about the *Uber* products\noffered at a given location. The response includes the display name\nand other details about each product, and lists the products in the\nproper display order.\n", response = Object.class, responseContainer = "List")
	@com.wordnik.swagger.annotations.ApiResponses(value = {
			@com.wordnik.swagger.annotations.ApiResponse(code = 200, message = "An array of products"),
			@com.wordnik.swagger.annotations.ApiResponse(code = 0, message = "Unexpected error") })
	public Response productsGet(
			@ApiParam(value = "Latitude component of location.", required = true) @QueryParam("latitude") Double latitude,
			@ApiParam(value = "Longitude component of location.", required = true) @QueryParam("longitude") Double longitude)
			throws NotFoundException {
		// do some magic!
		return Response.ok().entity("SUCCESS").build();
	}

}
