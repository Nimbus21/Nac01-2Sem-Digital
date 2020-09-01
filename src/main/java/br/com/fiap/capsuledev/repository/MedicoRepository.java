package br.com.fiap.capsuledev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.capsuledev.domain.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
	List<Medico> findByNomeContaining (String nome);
}
