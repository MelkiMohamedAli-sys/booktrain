/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soa.jaxrslabs.booktrainwebservicerest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author dalin
 */
@Path("trains")
public class TrainResource {
 public TrainResource() {
 }
 @GET 
 @Produces(MediaType.APPLICATION_XML)
  public List<Train> getAllTrains(){
        return BookTrainBD.getTrains();
 }
 
 @GET
 @Produces(MediaType.APPLICATION_JSON)
 @Path("all")
  public Response getAllTrainsV2(){
      System.out.println("getTrains");
        return Response.status(Status.FOUND)
               .entity(BookTrainBD.getTrains())
               .build();
  }
  
 @GET 
 @Path("numTrain-{id}") 
  public Response getTrain(@PathParam("id") String numTrain) {
      System.out.println("getTrain");
        for (Train current : BookTrainBD.getTrains()) {
         if (numTrain.equals(current.getNumTrain())) {
            return Response
                   .status(Status.OK)
                   .entity(current)
                   .build();
         }
        }
            return Response
                   .status(Status.NO_CONTENT)
                   .build();
 }
 @GET 
 @Path("/search") 
 @Produces(MediaType.APPLICATION_JSON)
  public Response searchTrainsByCriteria
        (@QueryParam("departure") String departure,
         @QueryParam("arrival") String arrival, 
         @QueryParam("arrivalhour") String arrivalHour) {
     
      System.out.println("searchTrainsByCriteria");

            return  Response
                    .status(Status.OK)
                    .entity(BookTrainBD.getTrains().subList(0, 2))
                    .build();
 }
 
 @POST
 @Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
 @Produces(MediaType.APPLICATION_JSON)
  public Response addTrain (Train train){
      BookTrainBD.addTrains(train);
            return Response.status(Response.Status.OK)
                   .entity(train)
                    .build(); 
  }      
        
  @POST
 @Produces(MediaType.TEXT_PLAIN)
  @Path("add")
  public Response addTrain2 (Train t){
      BookTrainBD.addTrains(t);
           return Response.status(Response.Status.CREATED)
                  .entity("train ajoute")
                  .build(); 
  }        
        
 @GET
 @Path("/booktrains")
 public BookTrainResource getBookTrainResource() {
 return new BookTrainResource();
 }
}
