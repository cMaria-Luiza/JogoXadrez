
/**
 * Write a description of class Bispo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bispo extends Peca
{
    private Tabuleiro tabuleiro;
    
    /**
     * Constructor for objects of class Bispo
     */
    public Bispo(Casa casa, int tipo)
    {
        super(casa, tipo);
         tabuleiro = new Tabuleiro();
    }
    
<<<<<<< HEAD
    public void mover(Casa destino) {
        if (podeMover(destino)) {
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
        }
    }
    
    public Boolean podeMover(Casa destino) {
        int xOrigem = casa.getX();
        int yOrigem = casa.getY();
        int xDestino = destino.getX();
        int yDestino = destino.getY();
        
        if (xDestino != xOrigem && yDestino != yOrigem) {
            for (int i = xOrigem; i < xDestino; i++) {
                for (int j = yOrigem; j < yDestino; j++) {
                    if ((tabuleiro.getCasa(i, yOrigem).possuiPeca() && tabuleiro.getCasa(i, yOrigem).getTipoPeca()%2 != casa.getTipoPeca()%2)
                        && (tabuleiro.getCasa(xOrigem, j).possuiPeca() && tabuleiro.getCasa(xOrigem, j).getTipoPeca()%2 != casa.getTipoPeca()%2)) {
                            return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
=======
>>>>>>> ad77ba043b387673ac492a83abc2445ceacbb073
}
    

