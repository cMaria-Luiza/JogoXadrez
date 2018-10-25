
/**
 * Write a description of class Rei here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rei extends Peca
{
    private boolean jogada;
    
    public Rei(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
       super(casa, tipo, tabuleiro);
       jogada = false;
    }
      
    public void mover(Casa destino) {
        //movimentação do rei branco e preto
       //movimentação do rei branco e preto
        if((tipo == 10 || tipo == 11) && podeMover(destino)){
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
            jogada = true;
        }   
     }
    
    public boolean podeMover(Casa destino){
       nt xOrigem = casa.getX();
        int yOrigem = casa.getY();
        int xDestino = destino.getX();
        int yDestino = destino.getY();
       
        if(destino.possuiPeca() == false ||  capturar(destino) == true){
            if(xOrigem+1 == xDestino || xOrigem-1 == xDestino || yOrigem+1 == yDestino || yOrigem-1 == yDestino){
                return true;
            }
        }      
        return false;
    }
    
}
