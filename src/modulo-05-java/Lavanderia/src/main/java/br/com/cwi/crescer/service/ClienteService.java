package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.CidadeDao;
import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.dto.ClienteDto;
import br.com.cwi.crescer.mapper.ClienteMapper;

@Service
public class ClienteService {

    private ClienteDao dao;
    private CidadeDao cidadeDao;

    @Autowired
    public ClienteService(ClienteDao clienteDao, CidadeDao cidadeDao){
        super();
        this.dao = clienteDao;
        this.cidadeDao = cidadeDao;
    }

    public void add(ClienteDto dto){
        Cliente entity = ClienteMapper.getNewEntity(dto);
        entity.setCidade(this.cidadeDao.findById(dto.idCidade));
        entity.setSituacao(SituacaoCliente.ATIVO);
        this.dao.add(entity);
    }

    public void update(ClienteDto dto) {
        Cliente entity = this.dao.findById(dto.id);
        ClienteMapper.merge(dto, entity);
        entity.setCidade(this.cidadeDao.findById(dto.idCidade));
        this.dao.update(entity);
    }

    public void remove(Long id){
        Cliente cliente = this.dao.findById(id);
        cliente.setSituacao(SituacaoCliente.INATIVO);
        this.dao.update(cliente);
    }

    public ClienteDto findById(long id) {
        return new ClienteDto(this.dao.findById(id));
    }

    public List<ClienteDto> find() {
        List<ClienteDto> list = new ArrayList<ClienteDto>();
        for (Cliente cliente : this.dao.find()) {
            list.add(new ClienteDto(cliente));
        }

        return list;
    }

	public List<ClienteDto> findByName(String name) {
		List<ClienteDto> list = new ArrayList<ClienteDto>();
        for (Cliente cliente : this.dao.findByName(name)) {
            list.add(new ClienteDto(cliente));
        }

        return list;
	}
}
