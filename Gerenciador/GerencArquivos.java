package Gerenciador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GerencArquivos {

    /**
     * Lê todas as linhas de um arquivo.
     *
     * @param caminho O caminho do arquivo.
     * @return Uma lista com as linhas do arquivo.
     */
    public static List<String> lerArquivo(String caminho) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + caminho);
        }
        return linhas;
    }

    /**
     * Sobrescreve um arquivo com uma lista de linhas.
     *
     * @param caminho O caminho do arquivo.
     * @param linhas  As linhas que devem ser escritas no arquivo.
     */
    public static void escreverArquivo(String caminho, List<String> linhas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + caminho);
        }
    }

    /**
     * Adiciona uma linha ao final de um arquivo.
     *
     * @param caminho O caminho do arquivo.
     * @param linha   A linha a ser adicionada.
     */
    public static void adicionarLinha(String caminho, String linha) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, true))) {
            writer.write(linha);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao adicionar linha no arquivo: " + caminho);
        }
    }

    /**
     * Gera um relatório em formato TXT com os dados fornecidos.
     * 
     * @param nome     O nome do professor ou aluno.
     * @param matricula A matrícula do professor ou aluno.
     * @param idade    A idade do professor ou aluno.
     * @param curso    O curso do professor ou aluno.
     */
    public static void gerarRelatorio() {
        // Gerar relatório dos alunos
        List<String> alunos = GerencArquivos.lerArquivo("dados/alunos.txt");

        // Gerar relatório dos professores
        List<String> professores = GerencArquivos.lerArquivo("dados/professores.txt");

        // Gerar relatório dos estudantes
        List<String> estudantes = GerencArquivos.lerArquivo("dados/estudantes.txt");

        // Criar o conteúdo do relatório
        StringBuilder relatorio = new StringBuilder();

        relatorio.append("Relatório de Dados Cadastrados\n");
        relatorio.append("====================================\n\n");

        relatorio.append("ALUNOS:\n");
        for (String aluno : alunos) {
            relatorio.append(aluno).append("\n");
        }

        relatorio.append("\nPROFESSORES:\n");
        for (String professor : professores) {
            relatorio.append(professor).append("\n");
        }

        relatorio.append("\nESTUDANTES:\n");
        for (String estudante : estudantes) {
            relatorio.append(estudante).append("\n");
        }

        // Gerar o arquivo de relatório
        String caminho = "relatorio.txt"; // Caminho onde o relatório será gerado

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            writer.write(relatorio.toString());
            JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório: " + e.getMessage());
        }
    }
}

