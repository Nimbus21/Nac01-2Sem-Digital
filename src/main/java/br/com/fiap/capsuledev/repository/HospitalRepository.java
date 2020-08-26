package br.com.fiap.capsuledev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.capsuledev.domain.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long>{
	List<Hospital> findByNomeContaining (String nome);
}
