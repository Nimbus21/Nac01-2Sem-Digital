package br.com.fiap.capsuledev.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.capsuledev.domain.Hospital;
import br.com.fiap.capsuledev.domain.dto.HospitalDTO;
import br.com.fiap.capsuledev.repository.HospitalRepository;

@RestController
@RequestMapping("hospital")
public class HospitalResource {

	@Autowired
	HospitalRepository hospitalRepository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<HospitalDTO> listar(String nome) {
		//List<Hospital> hospitais = nome == null ? hospitalRepository.findAll() : hospitalRepository.findByNomeContaining(nome);
		List<Hospital> hospitais = null;
		
		if (nome == null) {
			hospitais = hospitalRepository.findAll();
		} else {
			hospitais = hospitalRepository.findByNomeContaining(nome);
		}
		
		return HospitalDTO.converter(hospitais);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<HospitalDTO> listarId(@PathVariable("id") Long codigo){
		Optional<Hospital> hospital = hospitalRepository.findById(codigo);
		return hospital.map(h -> ResponseEntity.ok(new HospitalDTO(h))).orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<HospitalDTO> adicionar(@RequestBody Hospital hospital, UriComponentsBuilder uriBuilder) {
		hospitalRepository.save(hospital);
		
		URI uri = uriBuilder.path("/hospital/{id}").buildAndExpand(hospital.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(new HospitalDTO(hospital));
	}
	
}
