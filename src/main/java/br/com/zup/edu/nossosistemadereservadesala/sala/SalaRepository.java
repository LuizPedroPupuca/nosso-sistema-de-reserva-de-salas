package br.com.zup.edu.nossosistemadereservadesala.sala;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala,Long> {
}

