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

import br.com.fiap.capsuledev.domain.Medico;
import br.com.fiap.capsuledev.domain.dto.MedicoDTO;
import br.com.fiap.capsuledev.repository.MedicoRepository;

@RestController
@RequestMapping("medico")
public class MedicoResource {

	@Autowired
	MedicoRepository medicoRepository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<MedicoDTO> listar(String nome) {

		List<Medico> medicos = null;
		
		if (nome == null) {
			medicos = medicoRepository.findAll();
		} else {
			medicos = medicoRepository.findByNomeContaining(nome);
		}
		
		return MedicoDTO.converter(medicos);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<MedicoDTO> listarId(@PathVariable("id") Long codigo){
		Optional<Medico> medico = medicoRepository.findById(codigo);
		return medico.map(m -> ResponseEntity.ok(new MedicoDTO(m))).orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<MedicoDTO> adicionar(@RequestBody @Valid Medico medico, UriComponentsBuilder uriBuilder) {
		medicoRepository.save(medico);
		
		URI uri = uriBuilder.path("/medico/{id}").buildAndExpand(medico.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(new MedicoDTO(medico));
	}
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<MedicoDTO> atualizar(@PathVariable("id") Long codigo, @RequestBody @Valid Medico medicoNovo){
		Optional<Medico> medico = medicoRepository.findById(codigo);
		
		return medico.map(m -> {
			m.setNome(medicoNovo.getNome());
			m.setCrm(medicoNovo.getCrm());
			m.setMonitoramentos(medicoNovo.getMonitoramentos());
			medicoRepository.save(m);
			return ResponseEntity.ok(new MedicoDTO(m));
		}).orElse(ResponseEntity.notFound().build());
		
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> apagar(@PathVariable("id") Long codigo){
		Optional<Medico> medico = medicoRepository.findById(codigo);
		return medico.map(m -> {
			medicoRepository.deleteById(codigo);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
}
