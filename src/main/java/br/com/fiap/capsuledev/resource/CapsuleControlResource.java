package br.com.fiap.capsuledev.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

import br.com.fiap.capsuledev.domain.CapsuleControl;
import br.com.fiap.capsuledev.domain.Hospital;
import br.com.fiap.capsuledev.domain.dto.CapsuleControlDTO;
import br.com.fiap.capsuledev.domain.dto.HospitalDTO;
import br.com.fiap.capsuledev.repository.CapsuleControlRepository;
import br.com.fiap.capsuledev.repository.HospitalRepository;

@RestController
@RequestMapping("capsuleControl")
public class CapsuleControlResource {

	@Autowired
	CapsuleControlRepository capsuleControlRepository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<CapsuleControlDTO> listar(String remedio) {
		
		List<CapsuleControl> listaCapsuleControl = null;
		
		if (remedio == null) {
			listaCapsuleControl = capsuleControlRepository.findAll();
		} else {
			listaCapsuleControl = capsuleControlRepository.findByRemedioContaining(remedio);
		}
		
		return CapsuleControlDTO.converter(listaCapsuleControl);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CapsuleControlDTO> listarId(@PathVariable("id") Long codigo){
		Optional<CapsuleControl> capsuleControl = capsuleControlRepository.findById(codigo);
		return capsuleControl.map(cc -> ResponseEntity.ok(new CapsuleControlDTO(cc))).orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<CapsuleControlDTO> adicionar(@RequestBody CapsuleControl capsuleControl, UriComponentsBuilder uriBuilder) {
		capsuleControlRepository.save(capsuleControl);
		
		URI uri = uriBuilder.path("/capsuleControl/{id}").buildAndExpand(capsuleControl.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(new CapsuleControlDTO(capsuleControl));
	}
	
	//Testar
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<CapsuleControlDTO> atualizar(@PathVariable("id") Long codigo, @RequestBody CapsuleControl capsuleControlNovo){
		Optional<CapsuleControl> capsuleControl = capsuleControlRepository.findById(codigo);
		
		return capsuleControl.map(c -> {
			c.setData(capsuleControlNovo.getData());
			c.setDose(capsuleControlNovo.getDose());
			c.setHoraAlarme(capsuleControlNovo.getHoraAlarme());
			c.setMonitoramento(capsuleControlNovo.getMonitoramento());
			c.setRemedio(capsuleControlNovo.getRemedio());
			capsuleControlRepository.save(c);
			return ResponseEntity.ok(new CapsuleControlDTO(c));
		}).orElse(ResponseEntity.notFound().build());
		
	}
	
	//Testar
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> apagar(@PathVariable("id") Long codigo){
		Optional<CapsuleControl> capsuleControl = capsuleControlRepository.findById(codigo);
		
		return capsuleControl.map(c -> {
			capsuleControlRepository.deleteById(codigo);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
		
	}
	
}
