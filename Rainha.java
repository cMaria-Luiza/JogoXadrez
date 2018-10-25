
/**
 * Write a description of class Rainha here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rainha extends Peca

{
    
        /**
     * Constructor for objects of class Rainha
     */
    public Rainha(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
        super(casa, tipo, tabuleiro);
    }
    
    public void mover(Casa destino){
        if(podeMover(destino) == true){
            destino.colocarPeca(this);
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
        }
    }
    
    public boolean podeMover(Casa destino) {
        // coordenadas
        int xOrigem = casa.getX();
        int yOrigem = casa.getY();
        int xDestino = destino.getX();
        int yDestino = destino.getY();
        // distancia entre as coordenadas
        int distanciaX = getDistancia(xDestino - xOrigem);
        int distanciaY = getDistancia(yDestino - yOrigem);
        
        if (destino.possuiPeca() == false || capturar(destino)) {
            // ajuda a percorrer o for do menor para o maior
            if (xOrigem > xDestino) {
                int valorMaior = xOrigem;
                xOrigem = xDestino;
                xDestino = valorMaior;
            }
            
            if (yOrigem > yDestino) {
                int valorMaior = yOrigem;
                yOrigem = yDestino;
                yDestino = valorMaior;
            }
            
            // movendo-se na diagonal
            if (xDestino != xOrigem && yDestino != yOrigem && distanciaX == distanciaY) {
                // especionar casas intermediarias para saber se tem peça
                for (int x = xOrigem + 1; x < xDestino; x++) {
                    for (int y = yOrigem + 1; y < yDestino; y++) {
                        Casa intermediaria = tabuleiro.getCasa(x, y);
                        if (intermediaria.possuiPeca() == true) {
                            return false;
                        }
                    }
                }
            }
            // movendo-se horizontalmente 
            else if (xOrigem != xDestino && yOrigem == yDestino) {
                // especionar casas intermediarias para saber se tem peça
                for (int x = xOrigem + 1; x < xDestino; x++) {
                    Casa intermediaria = tabuleiro.getCasa(x, yOrigem);
                    if (intermediaria.possuiPeca() == true) {
                        return false;
                    }
                }
            }
            // movendo-se verticalmente
            else if (xOrigem == xDestino && yOrigem != yDestino) {
                // especionar casas intermediarias para saber se tem peça
                for (int y = yOrigem + 1; y < yDestino; y++) {
                    Casa intermediaria = tabuleiro.getCasa(xOrigem, y);
                    if (intermediaria.possuiPeca() == true) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        else {
            return false;
        }
        return true;
            /*// movimento horizontal 
            if (xDestino == xOrigem){
                // determina yOrigem como menor valor e yDestino com o maior valor
                // ajuda a percorrer o for do menor para o maior
                
                // vasculhar as casas até o yDestino verificando se tem peca adversaria, se tiver, nao pode mover
                for (int i = yOrigem; i < yDestino; i++) {
                    if (tabuleiro.getCasa(xOrigem, i).possuiPeca() && tabuleiro.getCasa(xOrigem, i).getTipoPeca()%2 != casa.getTipoPeca()%2) {
                            return false;
                    }
                }
            }
            // movimento vertical
            else if (yDestino == yOrigem) {
                // vasculhar as casas até o xDestino verificando se tem peca adversaria, se tiver, nao pode mover
                for (int i = xOrigem; i < xDestino; i++) {
                    if (tabuleiro.getCasa(i, yOrigem).possuiPeca() && tabuleiro.getCasa(i, yOrigem).getTipoPeca()%2 != casa.getTipoPeca()%2) {
                            return false;
                    }
                }
            }
            // movimento diagonal
            else {                
                for (int i = xOrigem; i < xDestino; i++) {
                    for (int j = yOrigem; j < yDestino; j++) {
                        if ((tabuleiro.getCasa(i, yOrigem).possuiPeca() && tabuleiro.getCasa(i, yOrigem).getTipoPeca()%2 != casa.getTipoPeca()%2)
                             && (tabuleiro.getCasa(xOrigem, j).possuiPeca() && tabuleiro.getCasa(xOrigem, j).getTipoPeca()%2 != casa.getTipoPeca()%2)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;*/
    }
}

