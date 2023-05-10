package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable//Encapsulando dois atributos dentro de uma classe só//
public class BelongingPK {

    //Relacionar dentro de uma tabela atributos de outras tabelas, no caso estamos relacionando uma tabela contendo...
    //informações sobre Games e uma listando todos os Games do BD dentro de uma unica tabela (belonging), dessa forma...
    //o ID usado nas tabelas "Game" e "GameList" serão as chaves estrangeiras usadas para relacionar os dados na...
    //terceira tabela//
    @ManyToOne//Mapeamento do objeto relacional para relacionar o Game ID e o List ID//
    @JoinColumn(name = "game_id")//Configuração do nome da chave estrangeira//
    private Game game;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

    public BelongingPK(){
    }

    public BelongingPK(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof BelongingPK that))
            return false;
        return Objects.equals(game, that.game) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, list);
    }
}
