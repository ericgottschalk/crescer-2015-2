package br.com.cwi.crescer.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfraTest;
import br.com.cwi.crescer.domain.Cidade;

public class CidadeDaoTest extends AbstractInfraTest {

    @Autowired
    private CidadeDao dao;

    @Test
    public void buscarPorIdUm() {
        Cidade cidade = this.dao.findById(1L);
        assertNotNull(cidade);
    }
}
