/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soa.jaxrslabs.booktrainwebservicerest;

import java.util.Iterator;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author dalin
 */
@Path("books")
public class BookTrainResource {
    
 @POST 
 public Response createBookTrain(@QueryParam("numTrain")String numTrain, 
         @QueryParam("numberPlaces")int numberPlaces) {
     
         Train currentTrain = null;
         for (Train current : BookTrainBD.getTrains()) {
          if (current.getNumTrain().equals(numTrain)) {
          currentTrain = current;
        }
        }
          if (currentTrain == null) {
          return Response
                 .status(Status.NO_CONTENT)
                 .build();
        }
    BookTrain newBookTrain = new BookTrain();
    newBookTrain.setNumberPlaces(numberPlaces);
    newBookTrain.setCurrentTrain(currentTrain);
    newBookTrain.setBookNumber(Long.toString(System.currentTimeMillis()));
    BookTrainBD.getBookTrains().add(newBookTrain);
 
         return Response
                .status(Status.OK)
                .entity(newBookTrain.getBookNumber())
                .build();
 }
 
 @GET 
 public Response getBookTrains() {
 System.out.println("getBookTrains");
         return Response
         .status(Status.OK)
         .entity(BookTrainBD.getBookTrains())
         .build();
 }
 
 @GET 
 @Path("{id}") 
 public Response getBookTrain(@PathParam("id") String bookNumber) {
    List<BookTrain> bookTrains = BookTrainBD.getBookTrains();
       for (BookTrain current : bookTrains) {
        if (current.getBookNumber().equals(bookNumber)) {
         return Response
                .status(Status.OK)
                .entity(current)
                .build();
        }
       }
         return Response
                .status(Status.NO_CONTENT).entity("there is no id")
                .build();
 }
 
@DELETE
@Path("{id}")
public Response removeBookTrain(@PathParam("id") String bookNumber) {

    Iterator<BookTrain> iterator = BookTrainBD.getBookTrains().iterator();
    while (iterator.hasNext()) {
        BookTrain current = iterator.next();
        if (current.getBookNumber().equals(bookNumber)) {
            iterator.remove();
            return Response
                   .status(Status.ACCEPTED)
                   .entity("deleted")
                   .build();
            
        }
    }
    return Response
           .status(Status.NO_CONTENT)
           .entity("there is no bookNumber")
           .build();
}
}