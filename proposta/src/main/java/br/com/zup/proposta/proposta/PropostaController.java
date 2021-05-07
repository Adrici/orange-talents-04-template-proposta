package br.com.zup.proposta.proposta;


import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposta")
public class PropostaController {
	
	@Autowired
	private  PropostaRepository propostaRepository; 
	

	
	@PostMapping
	@Transactional
	public ResponseEntity<PropostaDtoResponse> cadastrar(@RequestBody @Valid PropostaDtoRequest request) {
	
		PropostaModel proposta = request.toModel(); 
		propostaRepository.save(proposta); 
		
		return ResponseEntity.ok(new PropostaDtoResponse(proposta)); 		
	}

}
