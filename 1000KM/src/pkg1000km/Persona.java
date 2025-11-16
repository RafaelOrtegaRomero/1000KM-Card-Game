/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg1000km;


import java.util.*;

public class Persona {
    
Integer distanciaTotal;

ArrayList<Carta> mano= new ArrayList<>();

boolean moverse;
boolean gasolina;

    public Persona(ArrayList<Carta> manoMain) {
        this.distanciaTotal = 0;
        this.moverse=false;
        this.gasolina=true;
        this.mano=manoMain;
    }

    public Integer getDistanciaTotal() {
        return distanciaTotal;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public boolean isMoverse() {
        return moverse;
    }

    public boolean isGasolina() {
        return gasolina;
    }

    public void setDistanciaTotal(Integer distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }

    public void setMoverse(boolean moverse) {
        this.moverse = moverse;
    }

    public void setGasolina(boolean gasolina) {
        this.gasolina = gasolina;
    }




    @Override
    public String toString() {
        return  "distanciaTotal=" + distanciaTotal + "/n mano=" + mano ;
    }

    
    
}
