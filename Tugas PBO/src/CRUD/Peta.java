/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD;

/**
 *
 * @author dr. Yoe
 */
public class Peta {
    
    String Longitude, Latitude;
    
    public Peta (){}
    
    public Peta (String Longitude, String Latitude){
        this.Longitude = Longitude;
        this.Latitude = Latitude;
       
    }
    
    public void inputLongitude(String Longitude){
        this.Longitude = Longitude;
    }
    
    public String ambilLongitude(){
        return this.Longitude;
    }
    
    public void inputLatitude(String Latitude){
        this.Latitude = Latitude;
    }
    
    public String ambilLatitude(){
        return this.Latitude;
    }
    
    
}