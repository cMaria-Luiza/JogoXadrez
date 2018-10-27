package JogoXadrez;


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
            if (distanciaX == distanciaY) {
                int x = xOrigem;
                int y = yOrigem;
                // checagem de casas intermediarias
                while(x < xDestino-1 && y < yDestino-1) { 
                    x++;
                    y++;
                    Casa intermediaria = tabuleiro.getCasa(x, y);
                    if (intermediaria.possuiPeca() == true) {
                        return false;
                    }
                }
                return true;
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
    }
}

