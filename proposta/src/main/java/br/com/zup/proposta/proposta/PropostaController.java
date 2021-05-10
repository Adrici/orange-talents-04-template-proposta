package br.com.zup.proposta.proposta;


import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.proposta.analise.AnaliseClienteFeing;
import br.com.zup.proposta.analise.AnaliseSolicitacaoRequest;
import br.com.zup.proposta.analise.AnaliseResultadoResponse;

@RestController
@RequestMapping("/proposta")
public class PropostaController {
	
	@Autowired
	private  PropostaRepository propostaRepository; 
	
	
	@PostMapping 
	@Transactional
	public ResponseEntity<?> criaCadastro(@Valid @RequestBody PropostaDtoRequest request, UriComponentsBuilder builder) {
		PropostaModel  proposta = request.toModel();
		proposta = propostaRepository.save(proposta);

		return ResponseEntity
				.created(builder.path("/proposta/{id}").buildAndExpand(proposta.getId()).toUri()).build();
	}
	
	
}
