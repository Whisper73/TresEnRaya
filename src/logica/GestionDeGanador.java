
package logica;

import javax.swing.JOptionPane;

public class GestionDeGanador {

    public static boolean ganadorExiste;
    
    public GestionDeGanador() {
    }
    
    public void buscarGanador(String sim, int cMagico[]){      
        
        if(sim.equals("X")){
                if((cMagico[0] + cMagico[2] + cMagico[4]) == 15 ||
                   (cMagico[0] + cMagico[2] + cMagico[6]) == 15||
                   (cMagico[0] + cMagico[2] + cMagico[8]) == 15||
                   (cMagico[0] + cMagico[4] + cMagico[8]) == 15||
                   (cMagico[2] + cMagico[4] + cMagico[6]) == 15||
                   (cMagico[2] + cMagico[6] + cMagico[8]) == 15||
                   (cMagico[4] + cMagico[6] + cMagico[8]) == 15){
                    JOptionPane.showMessageDialog(null,"X Ganador!!!");
                    GestionDeGanador.ganadorExiste = true;
                }
        }else if (sim.equals("O")){
                if((cMagico[1] + cMagico[3] + cMagico[5]) == 15||
                   (cMagico[1] + cMagico[3] + cMagico[7]) == 15||
                   (cMagico[1] + cMagico[5] + cMagico[7]) == 15||
                   (cMagico[3] + cMagico[5] + cMagico[7]) == 15){
                    JOptionPane.showMessageDialog(null,"O Ganador!!!");
                    GestionDeGanador.ganadorExiste = true;
                    }
            
        }
        GestionDeGanador.ganadorExiste = false;
    }

    public static void setGanadorExiste() {
        ganadorExiste = false;
    }

    public boolean isGanadorExiste() {
        return ganadorExiste;
    }

}
