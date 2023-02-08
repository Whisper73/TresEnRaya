
package logica;

public class MachinePlayer {

    public final int CMagico[] = {4, 9, 2, 3, 5, 7, 8, 1, 6};

    public int jugada(int jugadaDeX, int posicionTurno[], int cuadroMagico[]) {
        
        switch (jugadaDeX) {
            case 1 -> {
                return analisisJ1(posicionTurno);
            }
            case 3,5,7 -> {

                return BestPlay(posicionTurno, cuadroMagico);
            }
            default -> {
                return 20;
            }
        }
    }

    private int analisisJ1(int posicionTurno[]) {
        return (posicionTurno[0] == 4) ? 8 : 4;
    }

    private int BestPlay(int posicionTurno[], int cuadroMagico[]) {
        int numMagico;
        for (int i = 0; i < 7; i += 2) {
            for (int y = i + 2; y < 9; y += 2) {
                if (cuadroMagico[i] != 16 && cuadroMagico[y] != 16) {
                    numMagico = 15 - cuadroMagico[i] - cuadroMagico[y];
                    numMagico = transformarAPosicion(numMagico);
                    if (espacioDisponible(numMagico, posicionTurno)) {
                        return numMagico;
                    }
                } else {
                    return BuscaGanar(posicionTurno, cuadroMagico);
                }
            }
        }
        return 20;
    }

    private int BuscaGanar(int[] posicionTurno, int[] cuadroMagico) {
        int numMagico;
        for (int i = 1; i < 5; i += 2) {
            for (int y = i + 2; y < 8; y += 2) {
                if (cuadroMagico[i] != 16 && cuadroMagico[y] != 16) {
                    numMagico = 15 - cuadroMagico[i] - cuadroMagico[y];
                    numMagico = transformarAPosicion(numMagico);
                    if (espacioDisponible(numMagico, posicionTurno)) {
                        return numMagico;
                    }
                } else {
                    return BuscaPosicionRandom(posicionTurno);
                }
            }
        }
        return 20;
    }

    private int transformarAPosicion(int n) {
        int pos = 10;
        for (int p = 0; p < 9; p++) {
            if (this.CMagico[p] == n) {
                pos = p;
            }
        }
        return pos;
    }

    private boolean espacioDisponible(int pos, int posicionTurno[]) {
        if (pos < 9) {
            for (int i = 0; i < 9; i++) {
                if (posicionTurno[i] == pos) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private int BuscaPosicionRandom(int[] posicionTurno) {

        for(int i = 0; i<9; i++){
            if(espacioDisponible(i, posicionTurno)){    
                return i;
            }
        }
      return 16; 
    }

}
