package br.com.cwi.crescer.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfraTest;
import br.com.cwi.crescer.domain.Cliente;

public class ClienteDaoTest extends AbstractInfraTest {

    @Autowired
    private ClienteDao dao;

    @Test
    public void buscarPorId() {
        Cliente cliente = this.dao.findById(1L);
        assertNotNull(cliente);
        assertNotNull(cliente.getCidade());
        assertNotNull(cliente.getPedidos());
    }
}
