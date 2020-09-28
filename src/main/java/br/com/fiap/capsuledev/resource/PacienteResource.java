package br.com.fiap.capsuledev.resource;

import java.net.URI;
import java.util.ArrayList;
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

import br.com.fiap.capsuledev.domain.Monitoramento;
import br.com.fiap.capsuledev.domain.Paciente;
import br.com.fiap.capsuledev.domain.dto.PacienteDTO;
import br.com.fiap.capsuledev.repository.PacienteRepository;

@RestController
@RequestMapping("paciente")
public class PacienteResource {

	@Autowired
	PacienteRepository pacienteRepository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<PacienteDTO> listar(String nome) {

		List<Paciente> pacientes = null;
		
		if (nome == null) {
			pacientes = pacienteRepository.findAll();
		} else {
			pacientes = pacienteRepository.findByNomeContaining(nome);
		}
		
		return PacienteDTO.converter(pacientes);
	}
	
	@GetMapping("pacientesByMedico")
	@ResponseStatus(code = HttpStatus.OK)
	public List<PacienteDTO> listarPacientesByMedico(Long codigo){
		if (codigo == null) {
		}
		else {
		}		
		
		List<Paciente> pacientes = pacienteRepository.findAll();
		List<Paciente> listaPacientesUnicos = new ArrayList<Paciente>();
		
		for (Paciente paciente : pacientes) {
			for (Monitoramento monitoramento : paciente.getMonitoramentos()) {
				if (monitoramento.getMedico().getCodigo().equals(codigo)) {
					if (listaPacientesUnicos.contains(monitoramento.getPaciente())) {
						
					} else {
						listaPacientesUnicos.add(monitoramento.getPaciente());
					}
					
				}
			}
		}
		//System.out.println(listaPacientesUnicos.size());
		return PacienteDTO.converter(listaPacientesUnicos);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PacienteDTO> listarId(@PathVariable("id") Long codigo){
		Optional<Paciente> paciente = pacienteRepository.findById(codigo);
		return paciente.map(p -> ResponseEntity.ok(new PacienteDTO(p))).orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<PacienteDTO> adicionar(@RequestBody @Valid Paciente paciente, UriComponentsBuilder uriBuilder) {
		pacienteRepository.save(paciente);
		
		URI uri = uriBuilder.path("/paciente/{id}").buildAndExpand(paciente.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(new PacienteDTO(paciente));
	}
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<PacienteDTO> atualizar(@PathVariable("id") Long codigo, @RequestBody @Valid Paciente pacienteNovo){
		Optional<Paciente> paciente = pacienteRepository.findById(codigo);
		
		return paciente.map(p -> {
			p.setNome(pacienteNovo.getNome());
			p.setNascimento(pacienteNovo.getNascimento());
			p.setRg(pacienteNovo.getRg());
			p.setGenero(pacienteNovo.getGenero());
			p.setNomeMae(pacienteNovo.getNomeMae());
			p.setEndereco(pacienteNovo.getEndereco());
			p.setContato(pacienteNovo.getContato());
			p.setTelefone(pacienteNovo.getTelefone());
			p.setOrgao(pacienteNovo.getOrgao());
			p.setMonitoramentos(pacienteNovo.getMonitoramentos());
			p.setTransplante(pacienteNovo.getTransplante());
			pacienteRepository.save(p);
			return ResponseEntity.ok(new PacienteDTO(p));
		}).orElse(ResponseEntity.notFound().build());
		
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> apagar(@PathVariable("id") Long codigo){
		Optional<Paciente> paciente = pacienteRepository.findById(codigo);
		return paciente.map(p -> {
			pacienteRepository.deleteById(codigo);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
}

