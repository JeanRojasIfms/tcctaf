package br.edu.ifms.taf.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.taf.model.Cma;
import br.edu.ifms.taf.model.Exercito;
import br.edu.ifms.taf.model.Gu;
import br.edu.ifms.taf.repository.CmaRepository;
import br.edu.ifms.taf.repository.ExercitoRepository;
import br.edu.ifms.taf.repository.GuRepository;

@Service
public class DBService {

	@Autowired
	private ExercitoRepository exercitoRepository;
	@Autowired
	private CmaRepository cmaRepository;
	@Autowired
	private GuRepository guRepository;

	public void instantiateTestDatabase() throws ParseException {

		Exercito exe1 = new Exercito(null, "Exercito Brasileiro");

		Cma cma1 = new Cma(null, "Comando militar de area Centro-oeste", exe1);
		Cma cma2 = new Cma(null, "Comando militar de area Nordeste", exe1);
		Cma cma3 = new Cma(null, "Comando militar de area Norte", exe1);

		exe1.getCmas().addAll(Arrays.asList(cma1, cma2, cma3));

		exercitoRepository.saveAll(Arrays.asList(exe1));
		// cmaRepository.saveAll(Arrays.asList(cma1,cma2,cma3));

		Gu gu1 = new Gu(null, "Quarta brigada de cavalaria mecanizada", cma1);
		Gu gu2 = new Gu(null, "Decima terceira brigada de infantaria motorizada", cma1);
		Gu gu3 = new Gu(null, "Decima oitava brigada de infantaria do pantanal", cma1);

		Gu gu4 = new Gu(null, "Setima brigada de infantaria motorizada", cma2);
		Gu gu5 = new Gu(null, "Decima brigada de infantaria motorizada", cma2);

		Gu gu6 = new Gu(null, "Vegesima terceira brigada de infantaria de selva", cma3);

		cma1.getGus().addAll(Arrays.asList(gu1, gu2, gu3));
		cma2.getGus().addAll(Arrays.asList(gu4, gu5));
		cma3.getGus().addAll(Arrays.asList(gu6));

		cmaRepository.saveAll(Arrays.asList(cma1, cma2, cma3));
		guRepository.saveAll(Arrays.asList(gu1,gu2,gu3,gu4,gu5,gu6));

	}
}
