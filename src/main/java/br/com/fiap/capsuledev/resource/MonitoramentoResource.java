package br.com.fiap.capsuledev.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.capsuledev.domain.Hospital;
import br.com.fiap.capsuledev.domain.Monitoramento;
import br.com.fiap.capsuledev.domain.dto.MonitoramentoDTO;
import br.com.fiap.capsuledev.repository.HospitalRepository;
import br.com.fiap.capsuledev.repository.MonitoramentoRepository;

@RestController
@RequestMapping("monitoramento")
public class MonitoramentoResource {
	
	@Autowired
	MonitoramentoRepository monitoramentoRepository;
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<MonitoramentoDTO> listar(String nomeHospital){
		
		List<Monitoramento> monitoramentos = null;
		
		if (nomeHospital == null) {
			monitoramentos = monitoramentoRepository.findAll();
		} else {
			List<Hospital> hospital = hospitalRepository.findByNomeContaining(nomeHospital);
			monitoramentos = monitoramentoRepository.findByHospital(hospital.get(0));
		}
		
		return MonitoramentoDTO.converter(monitoramentos);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<MonitoramentoDTO> listarId(@PathVariable("id") Long codigo) {
		Optional<Monitoramento> monitoramento = monitoramentoRepository.findById(codigo);
		return monitoramento.map(m -> ResponseEntity.ok(new MonitoramentoDTO(m))).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<MonitoramentoDTO> adicionar(@RequestBody @Valid Monitoramento monitoramento, UriComponentsBuilder uriBuilder) {
		monitoramentoRepository.save(monitoramento);
		
		URI uri = uriBuilder.path("/monitoramento/{id}").buildAndExpand(monitoramento.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(new MonitoramentoDTO(monitoramento));
	}
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<MonitoramentoDTO> atualizar(@PathVariable("id") Long codigo, @RequestBody @Valid Monitoramento monitoramentoNovo){
		Optional<Monitoramento> monitoramento = monitoramentoRepository.findById(codigo);
		
		return monitoramento.map(m -> {
			m.setCapsuleWatch(monitoramentoNovo.getCapsuleWatch());
			m.setFim(monitoramentoNovo.getFim());
			m.setHospital(monitoramentoNovo.getHospital());
			m.setInicio(monitoramentoNovo.getInicio());
			m.setListaCapsuleControl(monitoramentoNovo.getListaCapsuleControl());
			m.setMedico(monitoramentoNovo.getMedico());
			m.setPaciente(monitoramentoNovo.getPaciente());
			monitoramentoRepository.save(m);
			return ResponseEntity.ok(new MonitoramentoDTO(m));
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> apagar(@PathVariable("id") Long codigo) {
		Optional<Monitoramento> monitoramento = monitoramentoRepository.findById(codigo);
		
		return monitoramento.map(m -> {
			monitoramentoRepository.deleteById(codigo);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
