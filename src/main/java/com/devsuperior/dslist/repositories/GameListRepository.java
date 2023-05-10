package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

//Camada de Acesso a Dados - Componente que faz consulta no BD, atualiza e todas as...//
//outras operações graças a configurações ja feitas dentro do JpaRepository//
public interface GameListRepository extends JpaRepository<GameList, Long> {
}
