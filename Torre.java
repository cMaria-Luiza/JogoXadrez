
/**
 * Write a description of class Torre here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Torre extends Peca
{
    private boolean jogada;

    /**
     * Constructor for objects of class Torre
     */
    public Torre(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
       super(casa, tipo, tabuleiro);
        jogada = false;
    }
    
    public void mover(Casa destino){      
        if (podeMover(destino)) {
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
            jogada = true;
        }
    }
    
    /*  public Boolean podeMover(Casa destino){
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
    }*/
    
     public Boolean podeMover(Casa destino) {
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
                for (int x = xOrigem; x < xDestino; x++) {
                    Casa intermediaria = tabuleiro.getCasa(x, yOrigem);
                    if (intermediaria.possuiPeca() == true) {
                        return false;
                    }
                }
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
}
