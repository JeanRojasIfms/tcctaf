package br.edu.ifms.taf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.ifms.taf.dto.ExercitoDTO;
import br.edu.ifms.taf.model.Exercito;
import br.edu.ifms.taf.repository.ExercitoRepository;
import br.edu.ifms.taf.service.exception.DataIntegrityException;
import br.edu.ifms.taf.service.exception.ObjectNotFoundException;


@Service
public class ExercitoService {
	
	@Autowired
	private ExercitoRepository repo;
	
	public Exercito find(Integer id) {
		Optional<Exercito> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Exercito.class.getName()));		
	}
	
	public Exercito insert (Exercito obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Exercito update(Exercito obj) {
		Exercito newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		find(id);
		try {
			repo.deleteById(id);	
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover. Verifique a integridade referencial.");
		}
	}

	public List<Exercito> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	public Page<Exercito> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Exercito fromDTO(ExercitoDTO objDto) {
		return new Exercito(objDto.getId(), objDto.getNome());
	}
	
	private void updateData(Exercito newObj, Exercito obj) {
		newObj.setNome(obj.getNome());

	}

}
