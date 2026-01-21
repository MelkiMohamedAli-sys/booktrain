/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soa.jaxrslabs.booktrainwebservicerest;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dalin
 */
@XmlRootElement(name = "train")
public class Train {
 private String numTrain;
 private String villeDepart;
 private String villeArrivee;
 private int heureDepart; // Format : 1230 = 12h30
 public Train() {
 }
 public Train(String numTrain, String villeDepart, String villeArrivee,
int heureDepart) {
 this.numTrain = numTrain;
 this.villeDepart = villeDepart;
 this.villeArrivee = villeArrivee;
 this.heureDepart = heureDepart;
 
 }

    public String getNumTrain() {
        return numTrain;
    }

    @XmlAttribute
    public void setNumTrain(String numTrain) {
        this.numTrain = numTrain;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public int getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(int heureDepart) {
        this.heureDepart = heureDepart;
    }
 

}