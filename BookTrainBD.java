/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soa.jaxrslabs.booktrainwebservicerest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dalin
 */
@XmlRootElement
public class BookTrainBD {
    
    private static List<Train> trains =new ArrayList<Train>();
    private static List<BookTrain> booktrains =new ArrayList<BookTrain>();

    static{
        trains.add(new Train ("TR123","Poitiers","Paris",1250));
        trains.add(new Train ("TR129","Poitiers","Paris",1830));
        trains.add(new Train ("TR143","Poitiers","Paris",1740));
    }
  
    public static List<Train> getTrains() {
        return trains;
    }

    public static void setTrains(List<Train> trains) {
        BookTrainBD.trains = trains;
    }

    public static void addTrains(Train train) {
        trains.add(train);
    }

    public static void setBooktrains(List<BookTrain> booktrains) {
        BookTrainBD.booktrains = booktrains;
    }
    
    public static List<BookTrain> getBookTrains(){
        return booktrains;
    }
}
