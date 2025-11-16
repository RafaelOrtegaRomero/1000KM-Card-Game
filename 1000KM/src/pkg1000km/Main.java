
//RAFAEL ORTEGA ROMERO 1BDAM
package pkg1000km;


import java.util.*;

public class Main {

    public static void CrearBaraja(ArrayList<Carta> baraja){
      //creacion de la baraja
        for(int i=0;i<=7;i++){
       
            baraja.add(new Carta("SEMAFORO VERDE",0));
            baraja.add(new Carta("SEMAFORO ROJO",0));
            baraja.add(new Carta("SIN GASOLINA",0));
            baraja.add(new Carta("GASOLINA",0));
            
         if(i>=2){
            baraja.add(new Carta("100KM",100));
         }
            
        if(i>=6){
            
            baraja.add(new Carta("25KM",25));
            baraja.add(new Carta("50KM",50));
            baraja.add(new Carta("75KM",75));
            baraja.add(new Carta("150KM",150));
            baraja.add(new Carta("200KM",200));
        }
            
        }
    }
    
     public static void CrearMano(ArrayList<Carta> baraja, ArrayList<Carta> mano){
            for(int i=0;i<=5;i++){
            int num=(int)(Math.random()*baraja.size());
            mano.add(baraja.get(num));
            baraja.remove(num);
            }
     }
    
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        
        int eleccion=0;
        Carta usada;
        
        ArrayList <Carta> baraja= new ArrayList<>();
        
        ArrayList <Carta> mano1= new ArrayList<>();
        ArrayList <Carta> mano2= new ArrayList<>();
        
        boolean turno=true;
        
        System.out.println("Bienvenido a 1000KM");
        
        CrearBaraja(baraja);
        System.out.println("Barajando cartas... ");
        Collections.shuffle(baraja);
        
        System.out.println("Repartiendo...");
        CrearMano(baraja,mano1);
        Persona jugador1= new Persona(mano1);
        CrearMano(baraja,mano2);
        Persona jugador2= new Persona(mano2);
        
        //todo el juego sera contenido en el main, podria llevarse a un metodo si llevamos todas las variables
        //por eso he preferido dejarlo aqui en el main
        
        while(jugador1.getDistanciaTotal()<1000 && jugador2.getDistanciaTotal()<1000 && !baraja.isEmpty()){
            
            if(turno==true){
                System.out.println("---------------------------------------------Turno de jugador 1----------------------------------------------");
                System.out.println("Robando carta...");
                
                mano1.add(baraja.get(0));
                baraja.remove(0);
                
                 System.out.println("-----------------------------------------ESTADOS DEL JUGADOR1----------------------------------------");
                
                System.out.println("Gasolina: "+jugador1.isGasolina() +" ,Semaforo verde: "+jugador1.isMoverse()+" ,DistanciaTotal: "+jugador1.getDistanciaTotal());
                
                System.out.println("-----------------------------------------ESTADOS DEL JUGADOR2----------------------------------------");
                
                System.out.println("Gasolina: "+jugador2.isGasolina() +" ,Semaforo verde: "+jugador2.isMoverse()+" ,DistanciaTotal: "+jugador2.getDistanciaTotal());
                
                Collections.sort(mano1);
                System.out.println("\nMostrando cartas...");
                System.out.println(mano1);
                
                System.out.println("¿Que carta quieres jugar?(numero de carta del 1 al 7)");
                eleccion=scan.nextInt();
                eleccion=eleccion-1;
                
                //carta que usamos
                usada=mano1.get(eleccion);
                
                if(jugador1.isMoverse() && jugador1.isGasolina()){
                    
                jugador1.setDistanciaTotal( (jugador1.getDistanciaTotal()+usada.getDistancia()));
              
                } 
                
                //podria hacerse con switch
                if(usada.getNombre().equals("SEMAFORO VERDE")){
                    
                      if(jugador1.isGasolina()){
                    jugador1.setMoverse(true);
                    }
                    
                }else if(usada.getNombre().equals("SEMAFORO ROJO")){
                    
                    jugador2.setMoverse(false);
                    
                }else if(usada.getNombre().equals("GASOLINA")){
                    
                    jugador1.setGasolina(true);
                    
                }else if(usada.getNombre().equals("SIN GASOLINA")){
                    
                    if(jugador2.isMoverse()){
                    jugador2.setGasolina(false);
                    jugador2.setMoverse(false);
                    }
                    
                }
                
                //quitamos la carta usada
                mano1.remove(eleccion);
                turno=false;
                
                System.out.println("Distancia Jugador1: "+jugador1.getDistanciaTotal());
                
            }else{
                System.out.println("---------------------------------------------Turno de jugador 2----------------------------------------------");
                System.out.println("Robando carta...");
                
                mano2.add(baraja.get(0));
                baraja.remove(0);
                
                System.out.println("-----------------------------------------ESTADOS DEL JUGADOR1----------------------------------------");
                
                System.out.println("Gasolina: "+jugador1.isGasolina() +" ,Semaforo verde: "+jugador1.isMoverse()+" ,DistanciaTotal: "+jugador1.getDistanciaTotal());
                
                 System.out.println("-----------------------------------------ESTADOS DEL JUGADOR2----------------------------------------");
                
                System.out.println("Gasolina: "+jugador2.isGasolina() +" ,Semaforo verde: "+jugador2.isMoverse()+" ,DistanciaTotal: "+jugador2.getDistanciaTotal());
                
                Collections.sort(mano2);
                System.out.println("\nMostrando cartas...");
                System.out.println(mano2);
                
                 System.out.println("¿Que carta quieres jugar?(numero de carta del 1 al 7)");
                eleccion=scan.nextInt();
                eleccion=eleccion-1;
                
                //carta que usamos
                usada=mano2.get(eleccion);
                
                if(jugador2.isMoverse() && jugador2.isGasolina()){
                    
                jugador2.setDistanciaTotal( (jugador2.getDistanciaTotal()+usada.getDistancia()));
            
                }
                
                //podria hacerse con switch
                if(usada.getNombre().equals("SEMAFORO VERDE")){
                    
                    if(jugador2.isGasolina()){
                    jugador2.setMoverse(true);
                    }
                    
                }else if(usada.getNombre().equals("SEMAFORO ROJO")){
                    
                    jugador1.setMoverse(false);
                    
                }else if(usada.getNombre().equals("GASOLINA")){
                    
                    jugador2.setGasolina(true);
                    
                }else if(usada.getNombre().equals("SIN GASOLINA")){
                    
                    if(jugador1.isMoverse()){
                    jugador1.setGasolina(false);
                    jugador1.setMoverse(false);
                    }
                    
                }
                
                //quitamos la carta usada
                mano2.remove(eleccion);
                turno=true;
                
                System.out.println("Distancia Jugador2: "+jugador2.getDistanciaTotal());
            }
            
        }
        //comprobamos quien gana al final del juego
        if(jugador1.getDistanciaTotal()>=1000){
            System.out.println("Enorabuena jugador 1 Ganaste!");
        }else if(jugador2.getDistanciaTotal()>=1000){
            System.out.println("Enorabuena jugador 2 Ganaste!");
        }else{
            
            System.out.println("Parece que no quedan cartas en el mazo...");
            
            System.out.println("Distancias recorridas:");
            System.out.println("Jugador 1: "+jugador1.getDistanciaTotal()+" Jugador2: "+jugador2.getDistanciaTotal());
                
            if(jugador1.getDistanciaTotal()>jugador2.getDistanciaTotal()){
                
                System.out.println("Gana Jugador 1 que ha llegado mas lejos!");
                
            }else if(jugador1.getDistanciaTotal()<jugador2.getDistanciaTotal()){
                
                System.out.println("Gana Jugador 2 que ha llegado mas lejos!");
                
            }else{
               
                System.out.println("Ambos tienen la misma distancia, empate!");
                
            }
            
        }
       
    }
    
  }

