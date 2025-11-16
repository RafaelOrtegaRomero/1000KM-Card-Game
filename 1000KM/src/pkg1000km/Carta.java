/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1000km;

/**
 *
 * @author Rafae
 */
public class Carta implements Comparable{
    
    String nombre;
    Integer distancia;
    Integer peso;
    
    public Carta(String nombre, Integer distancia) {
        
       int pesoCarta=distancia;
        if(distancia==0){
        pesoCarta=2000;
        }
        
        this.nombre = nombre;
        this.distancia = distancia;
        this.peso=pesoCarta;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getDistancia() {
        return distancia;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return  nombre;
    }

    @Override
    public int compareTo(Object o) {
      Carta carta= (Carta) o;
 
      

      return peso.compareTo(carta.peso);
    }
    
    
    
}
