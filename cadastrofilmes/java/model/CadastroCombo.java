package model;

import java.util.List;

public abstract class CadastroCombo { //colocamos abstrata pois é uma classe base que vai fornecer a estrutura comum para diversos tipos de cadastro
    protected List<Combo> combos;
//protect para garantir que somente as subclasses tenham acesso direto aos dados dos combos


    // Construtor que recebe uma lista de combos
    public CadastroCombo(List<Combo> combos) {
        this.combos = combos; // Inicializa a lista de combos
    }

     //CRUD Create, Read, Update, Delete
    public abstract void create(String nome, String descricao, double preco);

    public abstract void readAll();

    public abstract void update(String nome, String descricao, double novoPreco);

    public abstract void delete(String nome);
}


 /*Padrão GRASP: o princípio Expert é aplicado, ao atribuir a responsabilidade de gerenciamento de Combos à classe, 
 que possui acesso direto aos dados necessários para cumprir essa responsabilidade de forma eficaz.*/

 /*o padrão GOF - Factory Method foi aplicado nesta classe pois ela delega a responsabilidade de criar instâncias específicas
 de Combos para suas subclasses, mantendo a estrutura flexível e fácil de entender*/