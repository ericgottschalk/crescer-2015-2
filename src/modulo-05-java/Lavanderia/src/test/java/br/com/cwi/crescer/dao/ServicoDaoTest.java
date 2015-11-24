package br.com.cwi.crescer.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfraTest;
import br.com.cwi.crescer.domain.Servico;

public class ServicoDaoTest extends AbstractInfraTest {

	@Autowired
    private ServicoDao dao;

    @Test
    public void deveBuscarServicoPorId() throws Exception {
        Servico servico = this.dao.findById(1L);
        assertNotNull(servico);
    }
}
