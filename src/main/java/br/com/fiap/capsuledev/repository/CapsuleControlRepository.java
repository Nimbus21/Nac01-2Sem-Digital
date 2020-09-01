package br.com.fiap.capsuledev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.capsuledev.domain.CapsuleControl;


public interface CapsuleControlRepository extends JpaRepository<CapsuleControl, Long>{
	List<CapsuleControl> findByRemedioContaining (String remedio);
}
