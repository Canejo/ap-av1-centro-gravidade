
import java.io.BufferedReader;
import java.io.FileReader;

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
        try {
            float[][] m = lerVetor();
            
            int[] cg = encontrarCentroGravidade(m);

            System.out.printf("Centro ( %d, %d )\n", cg[0] + 1, cg[1] + 1);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
    public static String[] lerArquivo() throws Exception {
        String line;
        int length = 0;
        FileReader arquivo = new FileReader("C:\\Users\\fcane\\Documents\\GitHub\\ap-av1-centro-gravidade\\src\\arquivo.txt");

        BufferedReader leitor = new BufferedReader(arquivo);
        String[] conteudo = new String[(int)leitor.lines().count()];
        while ((line = leitor.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }
            conteudo[length] = leitor.readLine();

            length += line.length();
        }
        // fechar o arquivo
        leitor.close();
        return conteudo;
    }
    
    public static float[][] lerVetor() throws Exception {
        String[] conteudo = lerArquivo();

        String[] contador = conteudo[0].split(" ");
        int linha = Integer.parseInt(contador[0]);
        int coluna = Integer.parseInt(contador[1]);
        
        // criar vetor
        float[][] matriz = new float[linha][coluna];
        
        for (int i = 1; i < conteudo.length; i++) {
            // separar os dados da linha
            String[] conteudoLinha = conteudo[i].split(" ");
            for (int j = 0; j < conteudoLinha.length; j++) {
                matriz[i-1][j] = Float.parseFloat(conteudoLinha[j]);
            }
        }
        
        return matriz;
    }     

    public static int[] encontrarCentroGravidade(float[][] m) {
        int indiceLinha = 0;
        float menorLinha = 0;
        int indiceColuna = 0;
        float menorColuna = 0;

        //Procurando gravidade das linhas        
        for (int i = 1; i < m.length - 1; i++) {
            float r = somarBlocosLinha(m, i);
            //Verificando se é o menor valor ou se é o primeiro valor
            if (i == 1 || menorLinha > r) {
                indiceLinha = i;
                menorLinha = r;
            }
        }
        
        //Procurando gravidede das colunas
        for (int i = 1; i < m[0].length - 1; i++) {
            float r = somarBlocosColuna(m, i);
            //Verificando se é o menor valor ou se é o primeiro valor
            if (i == 1 || menorColuna > r) {
                indiceColuna = i;
                menorColuna = r;
            }
        }

        return new int[] { indiceLinha, indiceColuna };
    }
    
    public static float somarBlocosLinha(float[][] m, int indice) {
        float bloco1 = 0;
        float bloco2 = 0;
        
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

        float r = bloco1 - bloco2;
        //Verificando se deu negativo e invertendo valor
        if (r < 0) {
            r *= -1;
        }
        return r;
    }
    
    public static float somarBlocosColuna(float[][] m, int indice) {
        float bloco1 = 0;
        float bloco2 = 0;
        
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
        float r = bloco1 - bloco2;
        if (r < 0) {
            r *= -1;
        }
        return r;
    }
}

