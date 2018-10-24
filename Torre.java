
/**
 * Write a description of class Torre here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Torre extends Peca
{
    private Tabuleiro tabuleiro;

    /**
     * Constructor for objects of class Torre
     */
    public Torre(Casa casa, int tipo)
    {
       super(casa, tipo); 
       tabuleiro = new Tabuleiro();
    }
    
    public void mover(Casa destino){      
        if (podeMover(destino)) {
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
        }
    }
    /*
    public boolean podeMover(Casa destino) {
        int xOrigem = casa.getX();
        int yOrigem = casa.getY();
        int xDestino = destino.getX();
        int yDestino = destino.getY();
        
        if ((xDestino == yOrigem && yDestino != yOrigem) || (xDestino != xOrigem && yDestino == yOrigem)) {
            return true;
        }
        return false;
    }
    */
   
    public boolean podeMover(Casa destino){
        int xOrigem = casa.getX();
        int yOrigem = casa.getY();
        int xDestino = destino.getX();
        int yDestino = destino.getY();
        //verifica se esta andando na horizontal e vertical
        // verifica se possui peça entre a casa de origem e a casa de destino
        if(tipo == 2 || tipo == 3){
            if((xOrigem != xDestino && yOrigem == yDestino) || (yOrigem != yDestino && xOrigem == xDestino)){
                if(destino.possuiPeca() == false || capturar(destino) == true){                                     
                    if(xOrigem > xDestino){
                        for(int linha = xOrigem; linha >= xDestino; linha--){

                            if(tabuleiro.getCasa(linha,yOrigem).possuiPeca()==false){
                                return true;
                            }
                            
                        }
                    } 
                    else if(xOrigem < xDestino){
                        for(int linha = xOrigem; linha <= xDestino; linha++){
                            
                            if(tabuleiro.getCasa(linha,yOrigem).possuiPeca()==false){
                                return true;
                            }
                           
                        }
                    } else if(yOrigem > yDestino){
                        for(int coluna = yOrigem; coluna >= yDestino; coluna--){
                            
                            if(tabuleiro.getCasa(xOrigem, coluna).possuiPeca()==false){
                                return true;
                            } 
                            
                        }
                    }
                    else if(yOrigem < yDestino){
                        for(int coluna = yOrigem; coluna <= yDestino; coluna++){
                            
                            if( tabuleiro.getCasa(xOrigem, coluna).possuiPeca()==false){
                                return true;
                            }
                            
                        }
                    }
                }
            }          
                    
        }
        return false;
    }
}
