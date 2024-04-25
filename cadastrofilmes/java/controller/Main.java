package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Combo;
import model.Filme;
import view.ComboController;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para entrada de dados
        List<Filme> filmes = new ArrayList<>(); // Cria uma lista de filmes vazia
        List<Combo> combos = new ArrayList<>(); // Cria uma lista de combos vazia
        ComboController comboController = new ComboController(combos); // Cria um objeto ComboController

        System.out.println("Bem vindo ao Cinemax!"); // Mensagem de boas-vindas ao usuário

        int opcao;

        do {
            // Menu de opções para o usuário
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Filme"); // Create - Cadastrar filme
            System.out.println("2. Cadastrar Combo de Alimentacao"); // Create - Cadastrar combo
            System.out.println("3. Listar Todos os Filmes"); // Read - Listar filmes
            System.out.println("4. Listar Todos os Combos de Alimentacao"); // Read - Listar combos
            System.out.println("5. Atualizar Filmes"); // Update - Atualizar filme
            System.out.println("6. Atualizar Combos de Alimentacao"); // Update - Atualizar combo
            System.out.println("7. Excluir Filme"); // Delete - Excluir filme
            System.out.println("8. Excluir Combo de Alimentacao");// Delete - Excluir combo
            System.out.println("9. Listar Filmes e Combos");  // Read - Listar filmes e combos
            System.out.println("10. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário

            switch (opcao) {
                case 1:
                    cadastrarFilme(filmes, scanner); // Chama o método para cadastrar um filme
                    break;
                case 2:
                    comboController.cadastrarCombo(scanner); // Chama o método do ComboController para cadastrar um combo
                    break;
                case 3:
                    listarFilmes(filmes); // Chama o método para listar os filmes
                    break;
                case 4:
                    listarCombos(combos); // Chama o método para listar os combos
                    break;
                case 5:
                    atualizarFilme(filmes, scanner); // Chama o método para atualizar um filme
                    break;
                case 6:
                    atualizarCombo(combos, scanner); // Chama o método para atualizar um combo
                    break;
                case 7:
                    excluirFilme(filmes, scanner); // Chama o método para excluir um filme
                    break;
                case 8:
                    excluirCombo(combos, scanner); // Chama o método para excluir um combo
                    break;
                case 9:
                    listarFilmesECombos(filmes, combos); // Chama o método para listar filmes e combos
                    break;
                case 10:
                    System.out.println("Saindo..."); // Exibe mensagem de saída
                    break;
                default:
                    System.out.println("Opcao invalida! Por favor, escolha uma opcao valida."); // Exibe mensagem de opção inválida
            }
        } while (opcao != 10); // Loop continua até o usuário escolher a opção de saída

        scanner.close(); // Fecha o Scanner após o término da execução
    }

    // Métodos auxiliares para cada operação do menu

    // Método para cadastrar um filme na lista de filmes
    private static void cadastrarFilme(List<Filme> filmes, Scanner scanner) {
        System.out.println("\nCadastro de Filme:");
        scanner.nextLine();

        System.out.print("Digite o nome do filme: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o genero do filme: ");
        String genero = scanner.next();

        System.out.print("Digite a duracao do filme (em minutos): ");
        int duracao = scanner.nextInt();

        Filme filme = new Filme(nome, genero, duracao); // Cria um objeto Filme com os dados fornecidos
        filmes.add(filme); // Adiciona o filme à lista de filmes

        System.out.println("Filme cadastrado com sucesso!"); // Mensagem de confirmação
    }

    // Método para listar todos os filmes da lista de filmes
    private static void listarFilmes(List<Filme> filmes) {
        System.out.println("\nFilmes cadastrados:");
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado ainda.");
        } else {
            for (Filme filme : filmes) {
                System.out.println(filme); // Imprime cada filme da lista
            }
        }
    }

    // Método para listar todos os combos da lista de combos
    private static void listarCombos(List<Combo> combos) {
        System.out.println("\nCombos de alimentacao cadastrados:");
        if (combos.isEmpty()) {
            System.out.println("Nenhum combo cadastrado ainda.");
        } else {
            for (Combo combo : combos) {
                System.out.println(combo); // Imprime cada combo da lista
            }
        }
    }

    // Método para atualizar informações de um filme na lista de filmes
    private static void atualizarFilme(List<Filme> filmes, Scanner scanner) {
        System.out.println("\nAtualizar Filme:");
        scanner.nextLine();

        System.out.print("Digite o nome do filme que deseja atualizar: ");
        String nome = scanner.nextLine();

        boolean encontrado = false;
        for (Filme filme : filmes) {
            if (filme.getNome().equalsIgnoreCase(nome)) { // Procura pelo filme com o nome fornecido
                System.out.print("Novo nome: ");
                String novoNome = scanner.nextLine();
                System.out.print("Novo genero: ");
                String novoGenero = scanner.nextLine();
                System.out.print("Nova duracao (em minutos): ");
                int novaDuracao = scanner.nextInt();
                scanner.nextLine();

                filme.setNome(novoNome); // Atualiza as informações do filme
                filme.setGenero(novoGenero);
                filme.setDuracao(novaDuracao);

                System.out.println("Filme atualizado com sucesso!"); // Mensagem de confirmação
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Filme nao encontrado!"); // Mensagem se o filme não for encontrado
        }
    }

    // Método para excluir um filme da lista de filmes
    private static void excluirFilme(List<Filme> filmes, Scanner scanner) {
        System.out.println("\nExcluir Filme:");
        scanner.nextLine();

        System.out.print("Digite o nome do filme que deseja excluir: ");
        String nome = scanner.nextLine();

        boolean removido = filmes.removeIf(filme -> filme.getNome().equalsIgnoreCase(nome)); // Remove o filme se encontrar pelo nome
        if (removido) {
            System.out.println("Filme excluido com sucesso!"); // Mensagem de confirmação
        } else {
            System.out.println("Filme nao encontrado!"); // Mensagem se o filme não for encontrado
        }
    }

    // Método para atualizar informações de um combo na lista de combos
    private static void atualizarCombo(List<Combo> combos, Scanner scanner) {
        System.out.println("\nAtualizar Combo de Alimentacao:");
        scanner.nextLine();

        System.out.print("Digite o nome do combo que deseja atualizar: ");
        String nome = scanner.nextLine();

        boolean encontrado = false;
        for (Combo combo : combos) {
            if (combo.getNome().equalsIgnoreCase(nome)) { // Procura pelo combo com o nome fornecido
                System.out.print("Novo nome: ");
                String novoNome = scanner.nextLine();
                System.out.print("Nova descricao: "); // Solicita a nova descrição
                String novaDescricao = scanner.nextLine(); // Lê a nova descrição
                System.out.print("Novo preco: ");
                double novoPreco = scanner.nextDouble();
                scanner.nextLine();

                combo.setNome(novoNome); // Atualiza as informações do combo
                combo.setDescricao(novaDescricao);
                combo.setPreco(novoPreco);

                System.out.println("Combo atualizado com sucesso!"); // Mensagem de confirmação
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Combo nao encontrado!"); // Mensagem se o combo não for encontrado
        }
    }

    // Método para excluir um combo da lista de combos
    private static void excluirCombo(List<Combo> combos, Scanner scanner) {
        System.out.println("\nExcluir Combo de Alimentacao:");
        scanner.nextLine();

        System.out.print("Digite o nome do combo que deseja excluir: ");
        String nome = scanner.nextLine();

        boolean removido = combos.removeIf(combo -> combo.getNome().equalsIgnoreCase(nome)); // Remove o combo se encontrar pelo nome
        if (removido) {
            System.out.println("Combo excluido com sucesso!"); // Mensagem de confirmação
        } else {
            System.out.println("Combo nao encontrado!"); // Mensagem se o combo não for encontrado
        }
    }

    // Método para listar todos os filmes e combos cadastrados
    private static void listarFilmesECombos(List<Filme> filmes, List<Combo> combos) {
        System.out.println("\nFilmes cadastrados:");
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado ainda.");
        } else {
            for (Filme filme : filmes) {
                System.out.println(filme); // Imprime cada filme da lista
            }
        }

        System.out.println("\nCombos de alimentacao cadastrados:");
        if (combos.isEmpty()) {
            System.out.println("Nenhum combo cadastrado ainda.");
        } else {
            for (Combo combo : combos) {
                System.out.println(combo); // Imprime cada combo da lista
            }
        }
    }
}
