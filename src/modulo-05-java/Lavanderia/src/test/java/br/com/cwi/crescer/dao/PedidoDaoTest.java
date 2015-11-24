package br.com.cwi.crescer.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfraTest;
import br.com.cwi.crescer.domain.Pedido;

public class PedidoDaoTest extends AbstractInfraTest {

    @Autowired
    private PedidoDao dao;

    @Test
    public void buscarPorId() {
        Pedido pedido = this.dao.findById(1L);
        assertNotNull(pedido);
        assertNotNull(pedido.getCliente());
        assertNotNull(pedido.getItens());
    }
}
