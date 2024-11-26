package Gerenciador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerencArquivos {
    public static void salvarDados(String arquivo, List<String> dados) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (String dado : dados) {
                writer.write(dado);
                writer.newLine();
            }
        }
    }

    public static List<String> carregarDados(String arquivo) throws IOException {
        List<String> dados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                dados.add(linha);
            }
        }
        return dados;
    }
}
