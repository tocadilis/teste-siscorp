package br.com.siscorp.tokio.prova.adapter.mapper.fabricante;

import java.util.Optional;

import br.com.siscorp.tokio.prova.adapter.persistence.jpa.entity.fabricante.FabricanteJpaEntity;
import br.com.siscorp.tokio.prova.adapter.web.dto.fabricante.FabricanteDTO;
import br.com.siscorp.tokio.prova.domain.entity.participante.Fabricante;

public class FabricanteMapper {

    private FabricanteMapper() {
	throw new IllegalStateException("Static Mapper class");
    }
    
    public static FabricanteDTO mapToWebDTO(Fabricante fabricante) {
	return Optional.ofNullable(fabricante)
		.map(x -> FabricanteDTO.builder()
			.id(x.getId())
			.nomeFantasia(x.getNomeFantasia())
			.razaoSocial(x.getRazaoSocial())
			.cnpj(x.getCnpj())
			.build())
		.orElse(null);
    }


    public static Fabricante mapToDomainEntity(FabricanteDTO fabricanteDto) {
    	return Optional.ofNullable(fabricanteDto)
    		.map(x -> Fabricante.builder()
    			.id(x.getId())
    			.razaoSocial(x.getRazaoSocial())
    			.nomeFantasia(x.getNomeFantasia())
    			.cnpj(x.getCnpj())
    			.build())
    		.orElse(null);
        }
    
    public static Fabricante mapToDomainEntity(FabricanteJpaEntity fabricanteJpa) {
	return Optional.ofNullable(fabricanteJpa)
		.map(x -> Fabricante.builder()
			.id(x.getId())
			.razaoSocial(x.getRazaoSocial())
			.nomeFantasia(x.getNomeFantasia())
			.cnpj(x.getCnpj())
			.build())
		.orElse(null);
    }
  
    public static FabricanteJpaEntity mapToJpaEntity(Fabricante fabricante) {
    	return Optional.ofNullable(fabricante)
    		.map(x -> FabricanteJpaEntity.builder()
				.id(x.getId())
				.razaoSocial(x.getRazaoSocial())
				.nomeFantasia(x.getNomeFantasia())
				.cnpj(x.getCnpj())
				.build())
    		.orElse(null);
        }
}
