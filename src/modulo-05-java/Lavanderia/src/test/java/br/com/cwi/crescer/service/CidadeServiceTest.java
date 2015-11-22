package br.com.cwi.crescer.service;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.cwi.crescer.dao.CidadeDao;
import br.com.cwi.crescer.domain.Cidade;

public class CidadeServiceTest {

	@Test
	public void buscarCidadePorId(){
		CidadeDao dao = new CidadeDao();
		CidadeService service = new CidadeService(dao);
		
		Cidade cidade = service.findById(1);
		
		assertNotNull(cidade);
	}
}
