package br.com.fiap.capsuledev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.capsuledev.domain.Hospital;
import br.com.fiap.capsuledev.domain.Monitoramento;

public interface MonitoramentoRepository extends JpaRepository<Monitoramento, Long>{
	List<Monitoramento> findByHospital (Hospital hospital);
	//It worked!
}
