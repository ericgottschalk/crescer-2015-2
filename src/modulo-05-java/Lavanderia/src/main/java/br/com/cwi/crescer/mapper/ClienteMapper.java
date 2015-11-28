package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.dto.ClienteDto;

public class ClienteMapper {

	public static Cliente getNewEntity(ClienteDto dto) {
		return new Cliente(dto.name, dto.cpf, dto.email, dto.endereco, dto.bairro, dto.cep);
	}

	public static ClienteDto toDTO(Cliente entity) {
		ClienteDto dto = new ClienteDto();
		dto.id = entity.getIdCliente();
		dto.name = entity.getName();
		dto.cpf = entity.getCpf();
		dto.email = entity.getEmail();
		dto.idCidade = entity.getCidade().getIdCidade();
		dto.endereco = entity.getEndereco();
		dto.bairro = entity.getBairro();
		dto.cep = entity.getCep();
		dto.uf = entity.getCidade().getUf();
		dto.cidade = entity.getCidade().getName();
		return dto;
	}

	public static Cliente merge(ClienteDto dto, Cliente entity) {
		entity.setName(dto.name);
		entity.setCpf(dto.cpf);
		entity.setEmail(dto.email);
		entity.setEndereco(dto.endereco);
		entity.setBairro(dto.bairro);
		entity.setCep(dto.cep);
		entity.setSituacao(dto.getSituacao());
		return entity;
	}
}