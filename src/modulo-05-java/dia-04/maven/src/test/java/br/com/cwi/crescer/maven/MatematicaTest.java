package br.com.cwi.crescer.maven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatematicaTest {

    @Test
    public void somar() {
        int soma = new Matematica().somar(100, 100);

        assertEquals(200, soma);
    }
}
