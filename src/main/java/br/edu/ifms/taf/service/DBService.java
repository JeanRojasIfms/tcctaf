package br.edu.ifms.taf.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.taf.model.Cma;
import br.edu.ifms.taf.model.Exercito;
import br.edu.ifms.taf.repository.CmaRepository;
import br.edu.ifms.taf.repository.ExercitoRepository;

@Service
public class DBService {	
	
	@Autowired
	private ExercitoRepository exercitoRepository;	
	@Autowired
	private CmaRepository cmaRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		        
		Exercito exe1 = new Exercito(null, "Exercito Brasileiro");
		
		Cma cma1 = new Cma(null, "Comando militar de area Centro-oeste", exe1);
		Cma cma2 = new Cma(null, "Comando militar de area Nordeste", exe1);
		Cma cma3 = new Cma(null, "Comando militar de area Norte", exe1);
		
		exe1.getCmas().addAll(Arrays.asList(cma1,cma2,cma3));		
			
		exercitoRepository.saveAll(Arrays.asList(exe1));		
		cmaRepository.saveAll(Arrays.asList(cma1,cma2,cma3));
		
		
		

	}
}
