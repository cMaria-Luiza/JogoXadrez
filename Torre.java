
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
        roqueTorre(destino);
        
    }
    
     public boolean roqueTorre(Casa destino){
         if( primeiraJogadaTorre == true){
             if(roque(destino) == true){
               if(tabuleiro.getCasa(5,0).possuiPeca() == false && tabuleiro.getCasa(6,0).possuiPeca() == false &&
                   tabuleiro.getCasa(7,0). getTipoPeca() == 2){
                   Casa colocarTorre =  tabuleiro.getCasa(5,0);
                   colocarTorre.colocarPeca(this);
                   casa = colocarTorre;
                   return true;
                } 
                else if(tabuleiro.getCasa(5,7).possuiPeca() == false && tabuleiro.getCasa(6,7).possuiPeca() == false &&
                   tabuleiro.getCasa(7,7). getTipoPeca() == 3 ){
                   Casa colocarTorre =  tabuleiro.getCasa(5,7);
                   colocarTorre.colocarPeca(this);
                   casa = colocarTorre;     
                   return true;
                }
               else if(tabuleiro.getCasa(3,0).possuiPeca() == false && tabuleiro.getCasa(2,0).possuiPeca() == false
                     && tabuleiro.getCasa(1,0).possuiPeca() == false && tabuleiro.getCasa(0,0). getTipoPeca() == 2 ){
                   Casa colocarTorre =  tabuleiro.getCasa(0,3);
                   colocarTorre.colocarPeca(this);
                   casa = colocarTorre;
                   return true;
                } 
               else if(tabuleiro.getCasa(3,7).possuiPeca() == false && tabuleiro.getCasa(2,7).possuiPeca() == false
                     && tabuleiro.getCasa(1,7).possuiPeca() == false && tabuleiro.getCasa(0,7). getTipoPeca() == 3){
                   Casa colocarTorre =  tabuleiro.getCasa(7,3);
                   colocarTorre.colocarPeca(this);
                   casa = colocarTorre;
                   return true;              
                }
            }
        }
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
