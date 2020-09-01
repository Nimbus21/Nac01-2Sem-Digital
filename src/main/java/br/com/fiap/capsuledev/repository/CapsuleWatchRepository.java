package br.com.fiap.capsuledev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.capsuledev.domain.CapsuleWatch;

public interface CapsuleWatchRepository extends JpaRepository<CapsuleWatch, Long>{
	List<CapsuleWatch> findBySintomasContaining (String sintomas);
}
