package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Camada de Serviço//
@Service//injetando dependcias de compenentes//
public class GameService {

    @Autowired//injetando uma instancia do GameRepository dentro do GameService//
    private GameRepository gameRepository;

    @Transactional(readOnly = true)//Assegurando que nao serão feitas operações de escrita no banco de dados, melhora performance//
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        //transformou a lista de "Games" numa lista "GameMinDTO"//
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}

