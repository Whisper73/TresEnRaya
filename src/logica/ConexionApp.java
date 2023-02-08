
package logica;

import java.util.ArrayList;

public class ConexionApp {

    public Turno turno;
    public MachinePlayer mp;

    public ConexionApp() {
        this.turno = new Turno();
        this.mp = new MachinePlayer();
    }

    public int Jugar(int pos) {
        int num = 0;
        if (turno.validarTurno(pos)) {
            if (turno.getNumTurnos() % 2 != 0) {
                num = 1;
            } else {
                num = 2;
            }
        }

        return num;
    }

    public void JugarVsMachine(int pos) {

        turno.validarTurno(pos);
    }

    public int MachineConector() {

        return mp.jugada(turno.getNumTurnos(), turno.getPosicionTurno(), turno.getCuadroMagico());
    }

    public void BorrarTablero(ArrayList<javax.swing.JTextField> tablero) {
        for (javax.swing.JTextField p : tablero) {
            p.setText("");
        }
    }
}
