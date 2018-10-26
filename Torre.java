package JogoXadrez;


/**
 * Write a description of class Torre here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Torre extends Peca{
    private boolean primeiraJogadaTorre;
    /**
     * Constructor for objects of class Torre
     */
    public Torre(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
       super(casa, tipo, tabuleiro);
       primeiraJogadaTorre = true;
    }
        
    public void mover(Casa destino){      
        if (podeMover(destino)) {
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
            primeiraJogadaTorre = false;
        }
    }
    
    public boolean roque(Casa destino){
        return false;
    }
    
    public boolean podeMover(Casa destino){
        int xOrigem = casa.getX();
        int yOrigem = casa.getY();
        int xDestino = destino.getX();
        int yDestino = destino.getY();
        
        if (destino.possuiPeca() == false || capturar(destino) == true) {
            // movendo-se horizontamente 
            if (xOrigem != xDestino && yOrigem == yDestino) {
                if (xOrigem > xDestino) {
                    int valorMaior = xOrigem;
                    xOrigem = xDestino; // xOrigem recebe o menor valor
                    xDestino = valorMaior; // xDestino recebe o maior valor
                }
                
                // especionar casas intermediarias para saber se tem peça
                for (int x = xOrigem+1; x < xDestino; x++) {
                    Casa intermediaria = tabuleiro.getCasa(x, yOrigem);
                    if (intermediaria.possuiPeca() == true) {
                        return false;
                    }
                }
                return true;
            }
            // movendo-se verticalmente
            else if (xOrigem == xDestino && yOrigem != yDestino) {
                if (yOrigem > yDestino) {
                    int valorMaior = yOrigem;
                    yOrigem = yDestino; // yOrigem recebe o menor valor
                    yDestino = valorMaior; // yDestino recebe o maior valor
                }
                
                // especionar casas intermediarias para saber se tem peça
                for (int y = yOrigem+1; y < yDestino; y++) {
                    Casa intermediaria = tabuleiro.getCasa(xOrigem, y);
                    if (intermediaria.possuiPeca() == true) {
                        return false;
                    }
                }
                return true;
            } 
        }
        return false;
    }
    
    public boolean primeiraJogadaTorre(){
       return primeiraJogadaTorre;
    }      
}
