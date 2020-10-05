package br.com.siscorp.tokio.prova.adapter.mapper.fabricante;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

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

    public static List<FabricanteDTO> mapToWebDTO(Collection<Fabricante> fabricante) {
    	if (Objects.nonNull(fabricante)) {
    	    return fabricante.stream()
    		    .filter(Objects::nonNull)
    		    .map(FabricanteMapper::mapToWebDTO)
    		    .collect(Collectors.toList());
    	}
    	return Collections.emptyList();
    }
    
    public static List<Fabricante> mapToDomainEntity(List<FabricanteJpaEntity> fabricantesJpa) {
    	List<Fabricante> embalagens = Collections.emptyList();

    	if (!CollectionUtils.isEmpty(fabricantesJpa)) {
    		embalagens = fabricantesJpa.stream().filter(Objects::nonNull).map(FabricanteMapper::mapToDomainEntity)
    		    .collect(Collectors.toList());
    	}

    	return embalagens;
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

    public static Optional<Fabricante> mapToDomainEntity(Optional<FabricanteJpaEntity> fabricante) {
		Optional<Fabricante> optProduto = Optional.empty();
		if (fabricante.isPresent()) {
		    optProduto = fabricante.map(FabricanteMapper::mapToDomainEntity);
		}
		return optProduto;
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
