package br.edu.ifms.taf.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.taf.model.Cma;
import br.edu.ifms.taf.model.Companhia;
import br.edu.ifms.taf.model.Exercito;
import br.edu.ifms.taf.model.Gu;
import br.edu.ifms.taf.model.Omds;
import br.edu.ifms.taf.model.Pelotao;
import br.edu.ifms.taf.repository.CmaRepository;
import br.edu.ifms.taf.repository.CompanhiaRepository;
import br.edu.ifms.taf.repository.ExercitoRepository;
import br.edu.ifms.taf.repository.GuRepository;
import br.edu.ifms.taf.repository.OmdsRepository;
import br.edu.ifms.taf.repository.PelotaoRepository;

@Service
public class DBService {

	@Autowired
	private ExercitoRepository exercitoRepository;
	@Autowired
	private CmaRepository cmaRepository;
	@Autowired
	private GuRepository guRepository;
	@Autowired
	private OmdsRepository omdsRepository;
	@Autowired
	private CompanhiaRepository companhiaRepository;
	@Autowired
	private PelotaoRepository pelotaoRepository;

	public void instantiateTestDatabase() throws ParseException {

		Exercito exe1 = new Exercito(null, "Exercito Brasileiro");

		Cma cma1 = new Cma(null, "Comando militar de area Centro-oeste", exe1);
		Cma cma2 = new Cma(null, "Comando militar de area Nordeste", exe1);
		Cma cma3 = new Cma(null, "Comando militar de area Norte", exe1);

		exe1.getCmas().addAll(Arrays.asList(cma1, cma2, cma3));

		
		// cmaRepository.saveAll(Arrays.asList(cma1,cma2,cma3));

		Gu gu1 = new Gu(null, "Quarta brigada de cavalaria mecanizada", cma1);
		Gu gu2 = new Gu(null, "Décima oitava brigada de infantaria do pantanal", cma1);
		Gu gu3 = new Gu(null, "Décima terceira brigada de infantaria motorizada", cma1);
		

		Gu gu4 = new Gu(null, "Sétima brigada de infantaria motorizada", cma2);
		Gu gu5 = new Gu(null, "Decima brigada de infantaria motorizada", cma2);

		Gu gu6 = new Gu(null, "Vegésima terceira brigada de infantaria de selva", cma3);

		cma1.getGus().addAll(Arrays.asList(gu1, gu2, gu3));
		cma2.getGus().addAll(Arrays.asList(gu4, gu5));
		cma3.getGus().addAll(Arrays.asList(gu6));
		
		
		
		Omds om1 = new Omds(null,"Decimo regimento de cavalaria mecanizada",gu1);
		Omds om2 = new Omds(null,"Decimo primeiro regimento de cavalaria mecanizada",gu1);
		Omds om3 = new Omds(null,"Decimo setimo regimento de cavalaria mecanizada",gu1);
		
		Omds om4 = new Omds(null,"Decimo oitava pelotao de policia do exercito",gu2);
		Omds om5 = new Omds(null,"Decimo setimo batalhão de fronteira",gu2);
		Omds om6 = new Omds(null,"Quadragesimo setimo batalha de fronteira",gu2);
		Omds om7 = new Omds(null,"Decimo oitavo pelotão de comunicações",gu2);
		Omds om8 = new Omds(null,"Companhia de comando da 18º brigada de infantaria do pantanal",gu2);
		
		Companhia cp1 = new Companhia(null,"Primeira companhia de fuzileiros",om5);
		Companhia cp2 = new Companhia(null,"Segunda companhia de fuzileiros",om5);
		Companhia cp3 = new Companhia(null,"Terceira companhia de fuzileiros",om5);
		Companhia cp4 = new Companhia(null,"Companhia de comando de apoio",om5);
		
		om5.getCompanhias().addAll(Arrays.asList(cp1,cp2,cp3,cp4));
		
		Pelotao pl1 = new Pelotao(null,"Primeiro pelotao de fuzileiros",cp1);
		Pelotao pl2 = new Pelotao(null,"Segundo pelotao de fuzileiros",cp1);
		Pelotao pl3 = new Pelotao(null,"Terceiro pelotao de fuzileiros",cp1);
		Pelotao pl4 = new Pelotao(null,"Seção de  comando",cp1);
		
		cp1.getPelotoes().addAll(Arrays.asList(pl1,pl2,pl3,pl4));
		
		exercitoRepository.saveAll(Arrays.asList(exe1));
		cmaRepository.saveAll(Arrays.asList(cma1, cma2, cma3));
		guRepository.saveAll(Arrays.asList(gu1,gu2,gu3,gu4,gu5,gu6));
		omdsRepository.saveAll(Arrays.asList(om1,om2,om3,om4,om5,om6,om7,om8));
		companhiaRepository.saveAll(Arrays.asList(cp1,cp2,cp3,cp4));
		pelotaoRepository.saveAll(Arrays.asList(pl1,pl2,pl3,pl4));
		
		
		
		

	}
}
