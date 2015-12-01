package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDao extends BaseDao<Produto>{

	public Produto findById(Long id){
    	return this.manager.find(Produto.class, id);
    }

	public List<Produto> find() {
		return this.manager.createQuery("FROM Produto", Produto.class).getResultList();
	}

	public List<Produto> findMaterialServicoFilter(Long idMaterial, Long idServico) {
		StringBuilder str = new StringBuilder();
		str.append("SELECT p FROM Produto p WHERE 1=1 ");
	    str.append("AND p.material.idMaterial = :idMaterial ");
	    str.append("AND p.servico.idServico = :idServico");
		
		return this.manager.createQuery(str.toString(), Produto.class)
				.setParameter("idMaterial", idMaterial)
				.setParameter("idServico", idServico)
				.getResultList();
	}
	
	public List<Produto> findMaterialFilter(Long idMaterial){
		StringBuilder str = new StringBuilder();
		str.append("SELECT p FROM Produto p WHERE p.material.idMaterial = :idMaterial");
		
		return this.manager.createQuery(str.toString(), Produto.class)
				.setParameter("idMaterial", idMaterial)
				.getResultList();
	}
	
	public List<Produto> findServicoFilter(Long idServico){
		StringBuilder str = new StringBuilder();
		str.append("SELECT p FROM Produto p WHERE p.servico.idServico = :idServico");
		
		return this.manager.createQuery(str.toString(), Produto.class)
				.setParameter("idServico", idServico)
				.getResultList();
	}

	public Boolean podeInserir(Long idMaterial, Long idServico) {
		return !(this.findMaterialServicoFilter(idMaterial, idServico).size() > 0);
	}
}
