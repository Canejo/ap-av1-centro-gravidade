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
        int[] cg = encontrarCentroGravidade(m);
        
        System.out.printf("Centro ( %d, %d )\n", cg[0] + 1, cg[1] + 1);
    }

    public static int[] encontrarCentroGravidade(double[][] m) {
        int indiceLinha = 0;
        double menorLinha = 0;
        int indiceColuna = 0;
        double menorColuna = 0;

        //Procurando gravidade das linhas        
        for (int i = 1; i < m.length - 1; i++) {
            double r = somarBlocosLinha(m, i);
            //Verificando se é o menor valor ou se é o primeiro valor
            if (i == 1 || menorLinha > r) {
                indiceLinha = i;
                menorLinha = r;
            }
        }
        
        //Procurando gravidede das colunas
        for (int i = 1; i < m[0].length - 1; i++) {
            double r = somarBlocosColuna(m, i);
            //Verificando se é o menor valor ou se é o primeiro valor
            if (i == 1 || menorColuna > r) {
                indiceColuna = i;
                menorColuna = r;
            }
        }

        return new int[] { indiceLinha, indiceColuna };
    }
    
    public static double somarBlocosLinha(double[][] m, int indice) {
        double bloco1 = 0;
        double bloco2 = 0;
        
        //Somando todos os valores das linhas no bloco 1
        for (int i = 0; i < indice; i++) {
            for (int j = 0; j < m[i].length; j++) {
                bloco1 += m[i][j];
            }
        }
        
        //Somando todos os valores das linhas no bloco 2
        for (int i = indice + 1; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                bloco2 += m[i][j];
            }
        }        

        double r = bloco1 - bloco2;
        //Verificando se deu negativo e invertendo valor
        if (r < 0) {
            r *= -1;
        }
        return r;
    }
    
    public static double somarBlocosColuna(double[][] m, int indice) {
        double bloco1 = 0;
        double bloco2 = 0;
        
        //Somando todos os valores das colunas no bloco 1
        for (int i = 0; i < indice; i++) {
            for (int j = 0; j < m.length; j++) {
                bloco1 += m[j][i];
            }
        }
        
        //Somando todos os valores das colunas no bloco 2
        for (int i = indice + 1; i < m[0].length; i++) {
            for (int j = 0; j < m.length; j++) {
                bloco2 += m[j][i];
            }
        }
        
        //Verificando se deu negativo e invertendo valor
        double r = bloco1 - bloco2;
        if (r < 0) {
            r *= -1;
        }
        return r;
    }
}

