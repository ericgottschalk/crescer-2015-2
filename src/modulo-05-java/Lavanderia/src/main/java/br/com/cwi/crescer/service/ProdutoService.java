package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.exception.ProdutoExistenteException;
import br.com.cwi.crescer.dao.MaterialDao;
import br.com.cwi.crescer.dao.ProdutoDao;
import br.com.cwi.crescer.dao.ServicoDao;
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ProdutoDto;

@Service
public class ProdutoService {

    private ProdutoDao produtoDao;
    private MaterialDao materialDao;
    private ServicoDao servicoDao;

    @Autowired
    public ProdutoService(ProdutoDao produtoDao, MaterialDao materialDao, ServicoDao servicoDao) {
        super();
        this.produtoDao = produtoDao;
        this.materialDao = materialDao;
        this.servicoDao = servicoDao;
    }

    public ProdutoDto findById(Long id) {
        return this.produtoToDto((this.produtoDao.findById(id)));
    }
    
    public List<ProdutoDto> find(){
    	List<ProdutoDto> list = new ArrayList<ProdutoDto>();
    	for (Produto produto : this.produtoDao.find()){
    		list.add(this.produtoToDto(produto));
    	}
    	
    	return list;
    }

    public void add(ProdutoDto dto) throws Exception{
        Produto produto = this.dtoToProduto(dto);
        produto.setSituacao(SituacaoProduto.ATIVO);
        Boolean podeInserir = this.produtoDao.podeInserir(produto.getMaterial().getIdMaterial(),
        												  produto.getServico().getIdServico());
        
        if (podeInserir){
        	this.produtoDao.add(produto);
        	return;
        }
        
        throw new ProdutoExistenteException();
    }
    
    public void update(ProdutoDto dto) {
		Produto produto = this.merge(dto);
		this.produtoDao.update(produto);
	}

    private Produto dtoToProduto(ProdutoDto dto) {
        Produto produto = new Produto();
        produto.setValor(dto.getValor());
        produto.setServico(this.servicoDao.findById(dto.getIdServico()));
        produto.setMaterial(this.materialDao.findById(dto.getIdMaterial()));
        produto.setPrazo(dto.getPrazo());
        return produto;
    }

    private ProdutoDto produtoToDto(Produto produto) {
        ProdutoDto dto = new ProdutoDto();
        dto.setIdProduto(produto.getIdProduto());
        dto.setIdMaterial(produto.getMaterial().getIdMaterial());
        dto.setIdServico(produto.getServico().getIdServico());
        dto.setPrazo(produto.getPrazo());
        dto.setValor(produto.getValor());
        dto.setSituacao(produto.getSituacao());
        dto.setServico(produto.getServico());
        dto.setMaterial(produto.getMaterial());
        return dto;
    }
    
    private Produto merge(ProdutoDto dto){
    	Produto produto = this.produtoDao.findById(dto.getIdProduto());
    	produto.setValor(dto.getValor());
    	produto.setSituacao(dto.getSituacao());
    	produto.setPrazo(dto.getPrazo());
    	
    	return produto;	
    }

	public List<ProdutoDto> findFilter(ProdutoDto dto) {
		List<ProdutoDto> list = new ArrayList<ProdutoDto>();
		if (dto.getIdMaterial() != null && dto.getIdServico() != null){
			Material material = this.materialDao.findById(dto.getIdMaterial());
			Servico servico = this.servicoDao.findById(dto.getIdServico());
			for (Produto produto : this.findByMaterialServico(material, servico)){
				list.add(this.produtoToDto(produto));
			}
			
			return list;
		}
		
		if (dto.getIdMaterial() != null){
			Material material = this.materialDao.findById(dto.getIdMaterial());
			for (Produto produto : this.findByMaterial(material)){
				list.add(this.produtoToDto(produto));
			}
			
			return list;
		}
		
		if (dto.getIdServico() != null){
			Servico servico = this.servicoDao.findById(dto.getIdServico());
			for (Produto produto : this.findByServico(servico)){
				list.add(this.produtoToDto(produto));
			}
			
			return list;
		}
	
		return list;
	}
	
	private List<Produto> findByMaterial(Material material){
		return this.produtoDao.findMaterialFilter(material.getIdMaterial());
	}
	
	private List<Produto> findByServico(Servico servico){
		return this.produtoDao.findServicoFilter(servico.getIdServico());
	}
	
	private List<Produto> findByMaterialServico(Material material, Servico servico){
		return this.produtoDao.findMaterialServicoFilter(material.getIdMaterial(), servico.getIdServico());
	}
}