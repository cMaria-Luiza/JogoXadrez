
/**
 * Write a description of class Torre here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Torre extends Peca
{

    /**
     * Constructor for objects of class Torre
     */
    public Torre(Casa casa, int tipo, Tabuleiro tabuleiro)
    {
       super(casa, tipo, tabuleiro); 
    }
    
    public void mover(Casa destino){      
        if (podeMover(destino)) {
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
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
                    int maiorValor = xOrigem;
                    xOrigem = xDestino; // xOrigem recebe o menor valor
                    xDestino = maiorValor; // xDestino recebe o maior valor
                }
                
                // especionar casas intermediarias para saber se tem peça
                for (int posicaoX = xOrigem; posicaoX < xDestino; posicaoX++) {
                    Casa intermediaria = tabuleiro.getCasa(posicaoX, yOrigem);
                    if (intermediaria.possuiPeca() == false) {
                        return true;
                    }
                }
            }
            // movendo-se verticalmente
            else if (xOrigem == xDestino && yOrigem != yDestino) {
                if (yOrigem > yDestino) {
                    int maiorValor = yOrigem;
                    yOrigem = yDestino; // yOrigem recebe o menor valor
                    yDestino = maiorValor; // yDestino recebe o maior valor
                }
                
                // especionar casas intermediarias para saber se tem peça
                for (int posicaoY = yOrigem+1; posicaoY < yDestino; posicaoY++) {
                    Casa intermediaria = tabuleiro.getCasa(xOrigem, posicaoY);
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
