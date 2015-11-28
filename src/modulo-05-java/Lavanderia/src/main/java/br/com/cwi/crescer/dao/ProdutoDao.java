package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Servico;

@Repository
public class ProdutoDao extends BaseDao<Produto>{

	public Produto findById(Long id){
    	return this.manager.find(Produto.class, id);
    }

	public List<Produto> find() {
		return this.manager.createQuery("FROM Produto", Produto.class).getResultList();
	}

	public List<Produto> findMaterialServicoFilter(Material material, Servico servico) {
		StringBuilder str = new StringBuilder();
		str.append("SELECT p FROM Produto p WHERE 1=1 ");
	    str.append("AND p.material.idMaterial = :material ");
	    str.append("AND p.servico.idServico = :servico");
		
		return this.manager.createQuery(str.toString(), Produto.class)
				.setParameter("material", material.getIdMaterial())
				.setParameter("servico", servico.getIdServico())
				.getResultList();
	}
	
	public List<Produto> findMaterialFilter(Material material){
		StringBuilder str = new StringBuilder();
		str.append("SELECT p FROM Produto p WHERE p.material.idMaterial = :material");
		
		return this.manager.createQuery(str.toString(), Produto.class)
				.setParameter("material", material.getIdMaterial())
				.getResultList();
	}
	
	public List<Produto> findServicoFilter(Servico servico){
		StringBuilder str = new StringBuilder();
		str.append("SELECT p FROM Produto p WHERE p.servivo.idServico = :servico");
		
		return this.manager.createQuery(str.toString(), Produto.class)
				.setParameter("servico", servico.getIdServico())
				.getResultList();
	}
}
