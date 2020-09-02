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

import br.com.fiap.capsuledev.domain.CapsuleWatch;
import br.com.fiap.capsuledev.domain.dto.CapsuleWatchDTO;
import br.com.fiap.capsuledev.repository.CapsuleWatchRepository;

@RestController
@RequestMapping("capsuleWatch")
public class CapsuleWatchResource {

	@Autowired
	CapsuleWatchRepository capsuleWatchRepository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<CapsuleWatchDTO> listar(String sintomas) {
		List<CapsuleWatch> listaCapsuleWatch = null;
		
		if (sintomas == null ) {
			listaCapsuleWatch = capsuleWatchRepository.findAll();
		} else {
			listaCapsuleWatch = capsuleWatchRepository.findBySintomasContaining(sintomas);
		}
		return CapsuleWatchDTO.converter(listaCapsuleWatch);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CapsuleWatchDTO> listarId(@PathVariable("id") Long codigo) {
		Optional<CapsuleWatch> capsuleWatch = capsuleWatchRepository.findById(codigo);
		return capsuleWatch.map(c -> ResponseEntity.ok(new CapsuleWatchDTO(c))).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CapsuleWatchDTO> adicionar(@RequestBody CapsuleWatch capsuleWatch, UriComponentsBuilder uriBuilder) {
		capsuleWatchRepository.save(capsuleWatch);
		
		URI uri = uriBuilder.path("/capsuleWatch/{id}").buildAndExpand(capsuleWatch.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(new CapsuleWatchDTO(capsuleWatch));
	}
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<CapsuleWatchDTO> atualizar(@PathVariable("id") Long codigo, @RequestBody CapsuleWatch capsuleWatchNovo) {
		Optional<CapsuleWatch> capsuleWatch = capsuleWatchRepository.findById(codigo);
		
		return capsuleWatch.map(c -> {
			c.setBatimentos(capsuleWatchNovo.getBatimentos());
			c.setDataHora(capsuleWatchNovo.getDataHora());
			c.setImc(capsuleWatchNovo.getImc());
			c.setMonitoramento(capsuleWatchNovo.getMonitoramento());
			c.setPressao(capsuleWatchNovo.getPressao());
			c.setSintomas(capsuleWatchNovo.getSintomas());
			c.setTemperatura(capsuleWatchNovo.getTemperatura());
			capsuleWatchRepository.save(c);
			return ResponseEntity.ok(new CapsuleWatchDTO(c));
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> apagar(@PathVariable("id") Long codigo){
		Optional<CapsuleWatch> capsuleWatch = capsuleWatchRepository.findById(codigo);
		
		return capsuleWatch.map(c -> {
			capsuleWatchRepository.deleteById(codigo);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
