package com.stefanini.projeto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.stefanini.projeto.model.Oculos;

public interface OculosRepository extends CrudRepository<Oculos, Long>{

	@Query("select o from Oculos o left join o.lentes where o.id = :id")
	Oculos obterPorId(@Param("id") Long id);
}
