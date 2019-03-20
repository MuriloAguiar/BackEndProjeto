	package com.stefanini.projeto.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stefanini.projeto.exception.TreinaException;
import com.stefanini.projeto.model.Lente;
import com.stefanini.projeto.model.Oculos;
import com.stefanini.projeto.service.OculosService;

@CrossOrigin
@Controller
@RequestMapping(value = "/oculos")
public class OculosController {

	@Autowired
	private OculosService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Oculos> findAll() throws TreinaException {
		return service.findAll();
	}	
	
	@RequestMapping(method = RequestMethod.POST, value = ("/salvar"), consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Oculos salvar(@RequestBody Oculos c) throws TreinaException {
		return service.salvar(c);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = ("/salvarLente/{id}"), consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Oculos salvarLente(@RequestBody Lente l, @PathVariable Long id) throws TreinaException {
		return service.salvarLente(l,id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = ("/excluir/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String excluir(@PathVariable Long id) throws TreinaException {
		return service.excluir(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = ("/alterar"), produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Oculos alterar(@RequestBody Oculos c) throws TreinaException {
		return service.alterar(c);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = ("/buscarId/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Oculos findById(@PathVariable Long id) throws TreinaException {
		return service.findById(id);
	}
	

	
	
	
	
}