
/**
 * Write a description of class Bispo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bispo extends Peca
{
    
    /**
     * Constructor for objects of class Bispo
     */
    public Bispo(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
        super(casa, tipo, tabuleiro);
    }
    
    public void mover(Casa destino) {
        if (podeMover(destino)) {
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
        }
    }
    
    public boolean podeMover(Casa destino) {
        int xOrigem = casa.getX();
        int yOrigem = casa.getY();
        int xDestino = destino.getX();
        int yDestino = destino.getY();
    
        int distanciaX = getDistancia(xDestino - xOrigem);
        int distanciaY = getDistancia(yDestino - yOrigem);
        
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
        
        if (destino.possuiPeca() == false || capturar(destino) == true) {
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
        }
        // se não entrar no if, não pode mover-se
        return false;
    }
}


    

