
/**
 * Write a description of class Rei here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rei extends Peca
{
    private boolean primeiraJogadaRei;
    
    public Rei(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
       super(casa, tipo, tabuleiro);
       primeiraJogadaRei = true;
    }
      
    public void mover(Casa destino) {
        int xOrigem = casa.getX();
        int yOrigem = casa.getY();
        int xDestino = destino.getX();
        int yDestino = destino.getY();
        if((podeMover(destino) == true)){
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
            primeiraJogadaRei = false;
        } 
        if( roqueRei(destino) == true){
            roque(destino);
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
            }
     }
    
    public boolean podeMover(Casa destino){
        int xOrigem = casa.getX();
        int yOrigem = casa.getY();
        int xDestino = destino.getX();
        int yDestino = destino.getY();
       
        if(destino.possuiPeca() == false ||  capturar(destino) == true){
            if(xOrigem+1 == xDestino || xOrigem-1 == xDestino || yOrigem+1 == yDestino || yOrigem-1 == yDestino){
                return true;
            }
            else{
                return false;
            }
        }      
        return false;
    }    
    
    public boolean primeiraJogadaRei(){
        return primeiraJogadaRei;
    }
    
    public boolean roqueRei(Casa destino){
        int xOrigem = casa.getX();
        int yOrigem = casa.getY();
        int xDestino = destino.getX();
        int yDestino = destino.getY();        
        if(primeiraJogadaRei == true){
            if(roque(destino) == true){
               if(xOrigem+2 == xDestino && yOrigem == yDestino){
                   if(tipo == 10 && tabuleiro.getCasa(5,0).possuiPeca() == false && tabuleiro.getCasa(6,0).possuiPeca() == false &&
                   tabuleiro.getCasa(7,0). getTipoPeca() == 2){
                       return true;
                    }    
                   else if(tipo == 11 && tabuleiro.getCasa(5,7).possuiPeca() == false && tabuleiro.getCasa(6,7).possuiPeca() == false &&
                   tabuleiro.getCasa(7,7). getTipoPeca() == 3){
                       return true;            
                }
              }
              else if(xOrigem-2 == xDestino && yOrigem == yDestino){
                     if((tipo == 10) && tabuleiro.getCasa(3,0).possuiPeca() == false && tabuleiro.getCasa(2,0).possuiPeca() == false
                     && tabuleiro.getCasa(1,0).possuiPeca() == false && tabuleiro.getCasa(0,0). getTipoPeca() == 2){
                       return true;
                     }
                     else if((tipo ==11) && tabuleiro.getCasa(3,7).possuiPeca() == false && tabuleiro.getCasa(2,7).possuiPeca() == false
                     && tabuleiro.getCasa(1,7).possuiPeca() == false && tabuleiro.getCasa(0,7). getTipoPeca() == 3){
                       return true;
                    }             
               }
           }
        }
        return false;
    }
    
    }
    
