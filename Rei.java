
/**
 * Write a description of class Rei here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rei extends Peca
{

    public Rei(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
       super(casa, tipo, tabuleiro);
    }
      
    public void mover(Casa destino) {
        //movimentação do rei branco e preto
        if(tipo == 10 || tipo == 11){
          if (destino.possuiPeca() == false ||  capturar(destino) == true){
            if((casa.getX()+1 == destino.getX() || casa.getX()-1 == destino.getX() || casa.getX() == destino.getX())
                                            &&
            (casa.getY()+1 == destino.getY() || casa.getY()-1 == destino.getY() || casa.getY() == destino.getY())){
                destino.colocarPeca(this);
                     casa.removerPeca();
                     casa=destino;
            }
            
          }
          
        }        
     }
    
    public Boolean podeMover(Casa destino){
        
        if(tipo == 10 || tipo == 11 && (destino.possuiPeca() == false ||  capturar(destino) == true)&&
        (casa.getX()+1 == destino.getX() || casa.getX()-1 == destino.getX() || casa.getX() == destino.getX()) &&
        (casa.getY()+1 == destino.getY() || casa.getY()-1 == destino.getY() || casa.getY() == destino.getY())){
          return true;
        }
        
        return false;
    }
    
}
