package com.example.helloworld.resources;


import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/object")
@Api(value = "/object", description = "Operations about objects")
@Produces({"application/json"})
public class TestResource {

	@GET
	@Path("/{objectId}")
	@ApiOperation(
		value = "Find object by ID", 
		notes = "Returns a object when ID < 10. ID > 10 or nonintegers will simulate API error conditions", 
		response = Object.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid ID supplied"),
			@ApiResponse(code = 404, message = "Object not found") })
	public Response getObjectById(
			@ApiParam(value = "ID of object that needs to be fetched", allowableValues = "range[1,5]", required = true) @PathParam("objectId") String objectId)
			throws NotFoundException {
		return Response.ok().entity(new Object()).build();
	}

	@POST
	@ApiOperation(value = "Add a new object to the store")
	@ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input") })
	public Response addObject(
			@ApiParam(value = "Object object that needs to be added to the store", required = true) Object obj) {
		return Response.ok().entity("SUCCESS").build();
	}

	@PUT
	@ApiOperation(value = "Update an existing object")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid ID supplied"),
			@ApiResponse(code = 404, message = "Object not found"),
			@ApiResponse(code = 405, message = "Validation exception") })
	public Response updateObject(
			@ApiParam(value = "Object object that needs to be added to the store", required = true) Object obj) {
		return Response.ok().entity("SUCCESS").build();
	}

	@GET
	@Path("/findByStatus")
	@ApiOperation(
		value = "Finds Objects by status", 
		notes = "Multiple status values can be provided with comma seperated strings", 
		response = Object.class,
		responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid status value") })
	public Response findObjectsByStatus(
			@ApiParam(value = "Status values that need to be considered for filter", required = true, defaultValue = "available", allowableValues = "available,pending,sold", allowMultiple = true) @QueryParam("status") String status) {
		return Response.ok("OK").build();
	}

	@GET
	@Path("/findByTags")
	@ApiOperation(
		value = "Finds Objects by tags", 
		notes = "Muliple tags can be provided with comma seperated strings. Use tag1, tag2, tag3 for testing.", 
		response = Object.class, 
		responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid tag value") })
	@Deprecated
	public Response findObjectsByTags(
			@ApiParam(value = "Tags to filter by", required = true, allowMultiple = true) @QueryParam("tags") String tags) {
		return Response.ok("OK").build();
	}
}