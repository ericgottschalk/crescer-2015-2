package br.com.cwi.crescer.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfraTest;
import br.com.cwi.crescer.domain.Material;

public class MaterialDaoTest  extends AbstractInfraTest {

    @Autowired
    private MaterialDao dao;

    @Test
    public void buscarMaterialPorId(){
        Material material = this.dao.findById(1L);
        assertNotNull(material);
    }

}