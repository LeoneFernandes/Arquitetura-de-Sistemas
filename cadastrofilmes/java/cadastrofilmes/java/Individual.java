package cadastrofilmes.java;
                                   
import java.util.List;

import model.CadastroCombo;
import model.Combo;                           

public class Individual extends CadastroCombo {
    // Construtor que recebe uma lista de combos
    public Individual(List<Combo> combos) {
        super(combos); // Chama o construtor da superclasse CadastroCombo
    }

    @Override
    //CRUD (Create)
    public void create(String nome, String descricao, double preco) {
        combos.add(new Combo(nome, descricao, preco)); // Adiciona um novo combo à lista
    }

    @Override
    //CRUD (Read)
    public void readAll() {
        for (Combo combo : combos) {
            System.out.println(combo); // Exibe todos os combos cadastrados
        }
    }

    @Override
    //CRUD (Update)
    public void update(String nome, String descricao, double novoPreco) {
        for (Combo combo : combos) {
            if (combo.getNome().equals(nome)) { // Verifica se o nome do combo corresponde
                combo.setDescricao(descricao); // Atualiza a descrição do combo
                combo.setPreco(novoPreco); // Atualiza o preço do combo
                System.out.println("Combo atualizado com sucesso!"); // Exibe mensagem de sucesso
                return;
            }
        }
        System.out.println("Combo não encontrado!"); // Exibe mensagem se o combo não for encontrado
    }

    // Implementação do método delete da superclasse
    @Override
    //CRUD (Delete)
    public void delete(String nome) {
        combos.removeIf(combo -> combo.getNome().equals(nome)); // Remove o combo com o nome especificado
        System.out.println("Combo excluído com sucesso!"); // Exibe mensagem de sucesso
    }
}


/*Aqui é um tipo especifico de CadastroCombo que ao ser instanciada recebe uma lista de combos no contrutor e
 herda os métodos */