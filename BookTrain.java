/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soa.jaxrslabs.booktrainwebservicerest;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dalin
 */
@XmlRootElement(name = "booktrain")
public class BookTrain {
 private String bookNumber;
 private Train currentTrain;
 private int numberPlaces;

         
     public BookTrain(){
     }
        
     public BookTrain(String bookNumber, Train currentTrain, int numberPlaces){
     this.bookNumber=bookNumber;
     this.currentTrain=currentTrain;
     this.numberPlaces=numberPlaces;
 }
 
    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public Train getCurrentTrain() {
        return currentTrain;
    }

    public void setCurrentTrain(Train currentTrain) {
        this.currentTrain = currentTrain;
    }

    public int getNumberPlaces() {
        return numberPlaces;
    }

    public void setNumberPlaces(int numberPlaces) {
        this.numberPlaces = numberPlaces;
    }
 
 

}