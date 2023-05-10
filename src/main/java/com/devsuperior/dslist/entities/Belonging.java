package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId//Chamando as chaves estrangeiras dentro de uma unica chave - BelongingPK//
    private BelongingPK id = new BelongingPK();//Chave primária ("Primary Key") que faz referencia ao dois Id's (Game e GameList),
    //ou seja, cria-se uma classe auxiliar para representar uma chave primaria multipla, com mais de um atributo//
    private Integer position;

    public Belonging(){
    }

    public Belonging(Game game, GameList list, Integer position) {
        id.setGame(game);
        id.setList(list);
        this.position = position;
    }

    public BelongingPK getId() {
        return id;
    }

    public void setId(BelongingPK id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Belonging belonging))
            return false;
        return Objects.equals(id, belonging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
