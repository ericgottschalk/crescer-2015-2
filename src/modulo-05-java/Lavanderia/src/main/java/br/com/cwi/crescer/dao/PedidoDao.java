package br.com.cwi.crescer.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

@Repository
public class PedidoDao extends BaseDao<Pedido>{

	public Pedido findById(Long id){
    	return this.manager.find(Pedido.class, id);
    }

	public List<Pedido> find() {
		return this.manager.createQuery("FROM Pedido", Pedido.class).getResultList();
	}

	public List<Pedido> findByCpfSituacao(String cpf, SituacaoPedido situacao) {
		StringBuilder str = new StringBuilder();
		str.append("SELECT p FROM Pedido p where p.situacao = :situacao ");
		str.append("AND p.cliente.cpf = :cpf");
		return this.manager.createQuery(str.toString(), Pedido.class)
				.setParameter("situacao", situacao)
				.setParameter("cpf", cpf)
				.getResultList();	
	}

	public List<Pedido> findBySituacao(SituacaoPedido situacao) {
		return this.manager.createQuery("SELECT p FROM Pedido p where p.situacao = :situacao", Pedido.class)
				.setParameter("situacao", situacao)
				.getResultList();
	}
	
	public List<Pedido> findByCpf(String cpf) {
		return this.manager.createQuery("SELECT p FROM Pedido p where p.cliente.cpf = :cpf", Pedido.class)
				.setParameter("cpf", cpf)
				.getResultList();
	}
}
