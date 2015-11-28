package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.MaterialDao;
import br.com.cwi.crescer.dao.ProdutoDao;
import br.com.cwi.crescer.dao.ServicoDao;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
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

    public void inserir(ProdutoDto dto) {
        Produto produto = this.dtoToProduto(dto);
        produto.setSituacao(SituacaoProduto.ATIVO);
        this.produtoDao.add(produto);
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
        dto.setIdMaterial(produto.getMaterial().getIdMaterial());
        dto.setIdServico(produto.getServico().getIdServico());
        dto.setPrazo(produto.getPrazo());
        dto.setValor(produto.getValor());
        dto.setSituacao(produto.getSituacao());
        return dto;
    }
}
