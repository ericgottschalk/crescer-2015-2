package br.com.cwi.crescer.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.hibernate.mapping.Array;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.AbstractInfraTest;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Pedido;

public class PedidoServiceTest extends AbstractInfraTest{

	@Autowired
	private PedidoService service;
	
	@Test
	public void deveObterValorBruto(){
		
		Double esperado = 0D;
		Pedido pedido = new Pedido();
		List<Item> list = new ArrayList<Item>();
		for (int i = 0; i < 10; i++){
			Item item = new Item();
			Double valor = 10D + i;
			esperado += valor;
			item.setValorTotal(new BigDecimal(valor));
			list.add(item);
		}
		
		pedido.setItens(list);
		pedido.setValorBruto(this.service.getValorBrutoPedido(pedido));
		
		assertEquals(new BigDecimal(esperado), pedido.getValorBruto());
		
	}
	
	@Test
	public void deveObterValorDescontoSegundaAQuarta() throws ParseException{
	
		Pedido pedido = new Pedido();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dia = format.parse("01/12/2015");
		pedido.setDataInclusao(dia);
		pedido.setValorBruto(new BigDecimal(87));
		pedido.setItens(new ArrayList<Item>());
		Double esperado = (pedido.getValorBruto().doubleValue() * 8) / 100;
		
		pedido.setValorDesconto(this.service.getValorDesconto(pedido));
		
		assertEquals(new BigDecimal(esperado), pedido.getValorDesconto());
	}
	
	@Test
	public void deveObterValorDescontoQuintaSexta() throws ParseException{
	
		Pedido pedido = new Pedido();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dia = format.parse("03/12/2015");
		pedido.setDataInclusao(dia);
		pedido.setValorBruto(new BigDecimal(39));
		pedido.setItens(new ArrayList<Item>());
		Double esperado = (pedido.getValorBruto().doubleValue() * 4) / 100;
		
		pedido.setValorDesconto(this.service.getValorDesconto(pedido));
		
		assertEquals(new BigDecimal(esperado), pedido.getValorDesconto());
	}
	
	@Test
	public void deveObterValorDescontoPesoMaiorQue15() throws ParseException{
	
		Pedido pedido = new Pedido();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dia = format.parse("05/12/2015");
		pedido.setDataInclusao(dia);
		pedido.setValorBruto(new BigDecimal(39));
		List<Item> list = new ArrayList<Item>();
		for (int i = 0; i < 10; i++){
			Item item = new Item();
			item.setPeso((double) i);
			list.add(item);
		}
		pedido.setItens(list);
		Double esperado = (pedido.getValorBruto().doubleValue() * 4.87) / 100;
		
		pedido.setValorDesconto(this.service.getValorDesconto(pedido));
		
		assertEquals(new BigDecimal(esperado), pedido.getValorDesconto());
	}
	
	@Test
	public void deveObterValorDescontoValorMaiorQue90() throws ParseException{
	
		Pedido pedido = new Pedido();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dia = format.parse("05/12/2015");
		pedido.setDataInclusao(dia);
		pedido.setValorBruto(new BigDecimal(99));
		pedido.setItens(new ArrayList<Item>());
		Double esperado = (pedido.getValorBruto().doubleValue() * 4.87) / 100;
		
		pedido.setValorDesconto(this.service.getValorDesconto(pedido));
		
		assertEquals(new BigDecimal(esperado), pedido.getValorDesconto());
	}
	
	@Test
	public void deveObterValorDescontoTodosOsCriterios8Porcento() throws ParseException{
	
		Pedido pedido = new Pedido();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dia = format.parse("01/12/2015");
		pedido.setDataInclusao(dia);
		pedido.setValorBruto(new BigDecimal(99));
		List<Item> list = new ArrayList<Item>();
		for (int i = 0; i < 10; i++){
			Item item = new Item();
			item.setPeso((double) i);
			list.add(item);
		}
		pedido.setItens(list);
		Double esperado = (pedido.getValorBruto().doubleValue() * 8) / 100;
		
		pedido.setValorDesconto(this.service.getValorDesconto(pedido));
		
		assertEquals(new BigDecimal(esperado), pedido.getValorDesconto());
	}
}
