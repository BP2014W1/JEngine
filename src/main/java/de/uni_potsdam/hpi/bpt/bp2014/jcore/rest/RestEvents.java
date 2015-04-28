package de.uni_potsdam.hpi.bpt.bp2014.jcore.rest;

import de.uni_potsdam.hpi.bpt.bp2014.jcore.EventHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("events/v2")
public class RestEvents {


    @GET
    @Path("subscribe")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEventProducerList(
            @Context UriInfo uriInfo,
            @QueryParam("filter") String filterString) {

        EventHandler eventHandler = new EventHandler();
        //TODO: retrieve List of
        eventHandler.retrieveListofEventProducer();
        //TODO: encode List as JSON and return it
        return Response
                .ok()
                .type(MediaType.APPLICATION_JSON)
                .entity("".toString())
                .build();
    }

    @GET
    @Path("activities")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEventActivityList(
            @Context UriInfo uriInfo,
            @QueryParam("filter") String filterString) {

        EventHandler eventHandler = new EventHandler();
        //TODO: retrieve List of EventActivities
        //TODO: encode List as JSON and return it
        return Response
                .ok()
                .type(MediaType.APPLICATION_JSON)
                .entity("".toString())
                .build();
    }

    @POST
    @Path("subscribe/{eventProducerID}/{eventActivityID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response setSubscription(
            @Context UriInfo uriInfo,
            @PathParam("eventProducerID") int eventProducerID,
            @PathParam("eventActivityID") int eventActivityID,
            @QueryParam("filter") String filterString) {

        EventHandler eventHandler = new EventHandler();
        Boolean result = eventHandler.subscribeEventProducer(eventActivityID, eventProducerID);
        if(result) {
            return Response
                    .ok()
                    .type(MediaType.APPLICATION_JSON)
                    .entity("ok".toString())
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .type(MediaType.APPLICATION_JSON)
                    .entity("{\"error\":\"The subscription didnt work out!\"}")
                    .build();
        }
    }
}
