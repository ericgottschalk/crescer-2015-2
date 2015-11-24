package br.com.cwi.crescer.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfraTest;
import br.com.cwi.crescer.domain.Produto;

public class ProdutoDaoTest extends AbstractInfraTest{

	@Autowired
    private ProdutoDao dao;

    @Test
    public void buscarProdutoPorId() throws Exception {
        Produto produto = this.dao.findById(1L);
        assertNotNull(produto);
        assertNotNull(produto.getServico());
        assertNotNull(produto.getMaterial());
    }
}
