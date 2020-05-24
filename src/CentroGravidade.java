/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fcane
 * 
 **/

public class CentroGravidade {
  
    public static void main(String[] args) {
        double[][] m = new double[][] {
          {0.1, 0.2, 0.1, 0.2, 0.1},
          {0.1, 0.2, 0.3, 0.1, 0.1},
          {0.2, 0.3, 0.1, 0.1, 0.3},
          {0.4, 0.1, 0.1, 0.1, 0.2},
          {0.2, 0.2, 0.3, 0.3, 0.1},
        };
        System.out.println("Hellow world");
        int[] cg = encontrarCentroGravidade(m);
        
        System.out.printf("Centro ( %d, %d )", cg[0] + 1, cg[1] + 1);
    }

    public static int[] encontrarCentroGravidade(double[][] m) {
        int indiceLinha = 0;
        double menorLinha = 0;
        int indiceColuna = 0;
        double menorColuna = 0;

        //Procurando gravidade das linhas        
        for (int i = 1; i < m.length - 1; i++) {
            double r = somarBlocosLinha(m, i);
            if (i == 1 || menorLinha > r) {
                indiceLinha = i;
                menorLinha = r;
            }
        }
        
        //Procurando gravidede das colunas
        

        return new int[] { indiceLinha, indiceColuna };
    }
    
    public static double somarBlocosLinha(double[][] m, int indice) {
        double bloco1 = 0;
        double bloco2 = 0;
        
        for (int i = 0; i < indice; i++) {
            for (int j = 0; j < m[i].length; j++) {
                bloco1 += m[i][j];
            }
        }
        
        for (int i = indice + 1; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                bloco2 += m[i][j];
            }
        }        

        double r = bloco1 - bloco2;
        
        if (r < 0) {
            r *= -1;
        }
        
        return r;
    }
}

