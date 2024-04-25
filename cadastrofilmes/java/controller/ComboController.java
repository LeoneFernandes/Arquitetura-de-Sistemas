package controller;

import java.util.List;
import java.util.Scanner;

import model.Combo;

public class ComboController {
    private List<Combo> combos; 
    // atributo combos é protegido para garantir o encapsulamento dos dados.

    // Construtor que recebe uma lista de combos
    public ComboController(List<Combo> combos) {
        this.combos = combos; // Inicializa a lista de combos
    }

    // Método para cadastrar um novo combo
    public void cadastrarCombo(Scanner scanner) {
        System.out.println("\nCadastro de Combo:");
        scanner.nextLine(); 

        System.out.print("Digite o nome do combo: ");
        String nome = scanner.nextLine(); // Lê o nome do combo

        System.out.print("Digite os componentes do combo: ");
        String descricao = scanner.nextLine(); // Lê a descrição do combo

        System.out.print("Digite o preco do combo: ");
        double preco = scanner.nextDouble(); // Lê o preço do combo

        Combo combo = new Combo(nome, descricao, preco); // Cria um novo objeto Combo
        combos.add(combo); // Adiciona o combo à lista de combos

        System.out.println("Combo cadastrado com sucesso!");
    }
}

//GRASP - Controller:
/*A classe ComboController atua como um controlador no sistema, intermediando as interações do usuário
com as funcionalidades de cadastro de combos.*/