package model;

import java.util.List;

public abstract class CadastroFilme {//colocamos abstrata pois é uma classe base que vai fornecer a estrutura comum para diversos tipos de cadastro
    protected List<Filme> filmes; ////protect para garantir que somente as subclasses tenham acesso direto aos dados dos Filme

    public CadastroFilme(List<Filme> filmes) {
        this.filmes = filmes; // Inicializa a lista de filmes
    }

    //CRUD (Create)
    public abstract void create(String nome, String genero, int duracao);

    //CRUD (Read)
    public abstract void readAll();

    //CRUD (Update)
    public abstract void update(String nome, String novoNome, String novoGenero, int novaDuracao);

    //CRUD (Delete)
    public abstract void delete(String nome);

}


/*Padrão GRASP: o princípio Expert é aplicado, ao atribuir a responsabilidade de gerenciamento de filmes à classe, 
 que possui acesso direto aos dados necessários para cumprir essa responsabilidade de forma eficaz.*/

/*Padrão GOF - Factory Method, foi aplicado nesta classe pois ela delega a responsabilidade de criar instâncias específicas
 de filmes para suas subclasses, mantendo a estrutura flexível e fácil de entender*/