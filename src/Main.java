import model.Endereco;
import model.Cotacao;
import service.ApiClient;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiClient apiClient = new ApiClient();

        System.out.println("=== Consultor de CEP e Cotação do Dólar ===");

        try {
            System.out.print("Digite o CEP (somente números): ");
            String cep = scanner.nextLine();

            Endereco endereco = apiClient.buscarEndereco(cep);
            System.out.println(endereco);

        } catch (Exception e) {
            System.out.println("Erro ao buscar endereço: " + e.getMessage());
        }

        System.out.println();

        try {
            System.out.print("Digite a data da cotação (formato MM-DD-AAAA, ex: 06-23-2026): ");
            String data = scanner.nextLine();

            Cotacao cotacao = apiClient.buscarCotacaoDolar(data);
            System.out.println(cotacao);

        } catch (Exception e) {
            System.out.println("Erro ao buscar cotação: " + e.getMessage());
        }

        scanner.close();
    }
}