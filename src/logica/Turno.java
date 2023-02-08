
package logica;

public class Turno {

    private int numTurnos = 0;
    private String listaTurnos[]; //ingresa en el arreglo el simbolo
    private int posicionTurno[]; // ingresa en el arreglo la posicion del simbolo
    private int cuadroMagico[]; // rellena el cuadrado magico
    public GestionDeGanador gg = new GestionDeGanador();

    public Turno() {
        this.cuadroMagico = new int[9];
        this.posicionTurno = new int[9];
        for (int i = 0; i < 9; i++) {
            this.cuadroMagico[i] = 16;
            this.posicionTurno[i] = 16;
        }

        this.listaTurnos = new String[9];
        this.numTurnos = 0;
    }

    public void InicializarTurno() {
        this.numTurnos = 0;
    }

    public void listarTurno(int pos) {

        if (numTurnos % 2 != 0) {
            listaTurnos[numTurnos - 1] = "X";
            posicionTurno[numTurnos - 1] = pos;
            cuadroMagico[numTurnos - 1] = asignarValorCuadroMagico(pos);

            if (numTurnos >= 5) {
                gg.buscarGanador("X", cuadroMagico);
            }

        } else {
            listaTurnos[numTurnos - 1] = "O";
            posicionTurno[numTurnos - 1] = pos;
            cuadroMagico[numTurnos - 1] = asignarValorCuadroMagico(pos);

            if (numTurnos >= 5) {
                gg.buscarGanador("O", cuadroMagico);
            }
        }
    }

    public boolean validarTurno(int pos) {
        numTurnos++;
        listarTurno(pos);
        return numTurnos <= 9;
    }

    private int asignarValorCuadroMagico(int pos) {

        switch (pos) {
            case 0 -> {
                return 4;
            }

            case 1 -> {
                return 9;
            }

            case 2 -> {
                return 2;
            }

            case 3 -> {
                return 3;
            }

            case 4 -> {

                return 5;
            }

            case 5 -> {
                return 7;
            }

            case 6 -> {
                return 8;
            }

            case 7 -> {
                return 1;
            }

            case 8 -> {
                return 6;
            }

            default -> {
                return 16;
            }

        }
    }

    public int getNumTurnos() {
        return numTurnos;
    }

    public String[] getListaTurnos() {
        return listaTurnos;
    }

    public int[] getPosicionTurno() {
        return posicionTurno;
    }

    public int[] getCuadroMagico() {
        return cuadroMagico;
    }

}
