
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
        //movimentação do rei branco e preto
        //movimentação do rei branco e preto
        if((podeMover(destino) == true)){
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
            primeiraJogadaRei = false;
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
            else if((xOrigem+2 == xDestino || xOrigem-2 == xDestino) && primeiraJogadaRei == true){
                roque(destino);
                return true;
            }
        }      
        return false;
    }    
    
    public boolean primeiraJogadaRei(){
        return primeiraJogadaRei;
    }
    
     
    public void roque(Casa destino){
        int xOrigem = casa.getX();
        int yOrigem = casa.getY();
        int xDestino = destino.getX();
        int yDestino = destino.getY();
        if((primeiraJogadaTorre() == true) && (primeiraJogadaRei == true)){
           if(xOrigem+2 == xDestino && yOrigem == yDestino){
               if(tipo == 10 && tabuleiro.getCasa(5,0).possuiPeca() == false && tabuleiro.getCasa(6,0).possuiPeca() == false){
                   Peca torre = tabuleiro.getCasa(7,0).getPeca();
                   casa.removerPeca();
                   destino.colocarPeca(this); 
                   tabuleiro.getCasa(7,0).removerPeca();
                   tabuleiro.getCasa(5,0).colocarPeca(torre);
               }
               else if(tipo == 11 && tabuleiro.getCasa(5,7).possuiPeca() == false && tabuleiro.getCasa(6,7).possuiPeca() == false){
                   Peca torre = tabuleiro.getCasa(7,7).getPeca();
                   casa.removerPeca();
                   destino.colocarPeca(this); 
                   tabuleiro.getCasa(7,7).removerPeca();
                   tabuleiro.getCasa(5,7).colocarPeca(torre);  
               }
           } 
           else if(xOrigem-2 == xDestino && yOrigem == yDestino){
                 if((tipo == 10) && tabuleiro.getCasa(3,0).possuiPeca() == false && tabuleiro.getCasa(2,0).possuiPeca() == false
                 && tabuleiro.getCasa(1,0).possuiPeca() == false){
                   Peca torre = tabuleiro.getCasa(0,0).getPeca();
                   casa.removerPeca();
                   destino.colocarPeca(this); 
                   tabuleiro.getCasa(0,0).removerPeca();
                   tabuleiro.getCasa(3,0).colocarPeca(torre);  
                 }
                 else if((tipo ==11) && tabuleiro.getCasa(3,7).possuiPeca() == false && tabuleiro.getCasa(2,7).possuiPeca() == false
                 && tabuleiro.getCasa(1,7).possuiPeca() == false){
                   Peca torre = tabuleiro.getCasa(0,7).getPeca();
                   casa.removerPeca();
                   destino.colocarPeca(this); 
                   tabuleiro.getCasa(0,7).removerPeca();
                   tabuleiro.getCasa(3,7).colocarPeca(torre);  
                }            
                              
           }
        }
    }
        
    }
    
