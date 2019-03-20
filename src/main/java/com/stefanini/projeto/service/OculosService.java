package com.stefanini.projeto.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Lente;
import com.stefanini.projeto.model.Oculos;
import com.stefanini.projeto.repository.OculosRepository;

@Service
public class OculosService {

	@Autowired
	private OculosRepository repository;
	
	public List<Oculos> findAll() throws TreinaException {
		return (List<Oculos>) repository.findAll();
	}
	
	public Oculos salvar(Oculos c) throws TreinaException{
		List<Oculos> o = (List<Oculos>) repository.findAll();
		for(int i=0;i<o.size();i++) {
			if(o.get(i).getNome().equalsIgnoreCase(c.getNome())) {
				throw new TreinaException("Nome do Oculos já existe");
			}
		}
		return repository.save(c);
	}
	
	public Oculos salvarLente(Lente l, Long id) throws TreinaException{
		List<Oculos> o = (List<Oculos>) repository.findAll();
		for(int i=0; i<o.size();i++) {
			if(o.get(i).getId()==id) {
				if(o.get(i).getLentes().size()<5) {
					l.setOculos(o.get(i));
					o.get(i).setLente(l);
					return repository.save(o.get(i));
				}
			}
		}
		throw new TreinaException("A quantidade de filhos atingiu o limite (max. 5)");
		
	}
	
	public String excluir(Long id) throws TreinaException{
		repository.deleteById(id);
		return "Excluido com sucesso";
	}
	
	public Oculos alterar(Oculos c)throws TreinaException{
		String s = c.getNome();
		Long l= c.getId();
		if(repository.findById(l)!=null) {
			c=repository.findById(l).get();
			c.setNome(s);
			return repository.save(c);
			
		} else {
			throw new TreinaException("Nao existe");
		}
		
	}
	
	public Oculos findById(Long id) throws TreinaException {
		return repository.obterPorId(id);
	}
	

	
	
	
}