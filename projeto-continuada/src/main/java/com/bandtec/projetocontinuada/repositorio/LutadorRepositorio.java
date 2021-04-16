package com.bandtec.projetocontinuada.repositorio;

import com.bandtec.projetocontinuada.dominio.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LutadorRepositorio extends JpaRepository<Lutador, Integer> {
    @Query("select l from Lutador l order by vida")
    List<Lutador> findAllByForcaGolpe();

    @Query("select count(id) from Lutador l where vida > 0")
    Integer findAllCount();

    @Query("select count(id) from Lutador l where vida = 0.0")
    Integer findAllCountMortos();

}
