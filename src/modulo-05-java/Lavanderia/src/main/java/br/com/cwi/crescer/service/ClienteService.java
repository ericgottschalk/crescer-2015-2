package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.dto.ClienteDto;

@Service
public class ClienteService {

    private ClienteDao dao;

    @Autowired
    public ClienteService(ClienteDao clienteDao){
        super();
        this.dao = clienteDao;
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
}
