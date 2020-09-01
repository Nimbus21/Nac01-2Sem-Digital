package br.com.fiap.capsuledev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.capsuledev.domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	List<Paciente> findByNomeContaining (String nome);

}
