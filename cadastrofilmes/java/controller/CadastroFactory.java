package controller;

import java.util.List;

import cadastrofilmes.java.ComboDupla;
import cadastrofilmes.java.Individual;
import model.CadastroCombo;
import model.Combo;


public class CadastroFactory {
    // para criar instâncias de CadastroCombo com base no tipo especificado.
    public static CadastroCombo criarCadastro(String tipo, List<Combo> combos) {
        if (tipo.equalsIgnoreCase("Individual")) {
            // Cria um novo CadastroCombo Individual e o retorna.
            return new Individual(combos);
        } else if (tipo.equalsIgnoreCase("ComboDupla")) {
            // Cria um novo CadastroCombo ComboDupla e o retorna.
            return new ComboDupla(combos);
        }
        return null; // Retorna nulo se o tipo especificado não for reconhecido.
    }
}


/*
Essa classe CadastroFactory cria e retorna instâncias de CadastroCombo com base no tipo especificado,
como "Individual" ou "ComboDupla", utilizando o padrão Factory Method para delegar
a criação de objetos para subclasses específicas. */