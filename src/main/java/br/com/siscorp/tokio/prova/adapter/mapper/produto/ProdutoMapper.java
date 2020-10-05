package br.com.siscorp.tokio.prova.adapter.mapper.produto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import br.com.siscorp.tokio.prova.adapter.mapper.fabricante.FabricanteMapper;
import br.com.siscorp.tokio.prova.adapter.persistence.jpa.entity.produto.ProdutoJpaEntity;
import br.com.siscorp.tokio.prova.adapter.web.dto.produto.ProdutoDTO;
import br.com.siscorp.tokio.prova.domain.entity.produto.Produto;

public class ProdutoMapper {

    private ProdutoMapper() {
	throw new IllegalStateException("Static Mapper class");
    }

    public static List<ProdutoDTO> mapToWebDTO(List<Produto> produtos) {
		if (Objects.nonNull(produtos)) {
		    return produtos.stream()
			    .filter(Objects::nonNull)
			    .map(ProdutoMapper::mapToWebDTO)
			    .collect(Collectors.toList());
		}
		return Collections.emptyList();
    }

    public static Optional<Produto> mapToDomainEntity(Optional<ProdutoJpaEntity> produto) {
		Optional<Produto> optProduto = Optional.empty();
		if (produto.isPresent()) {
		    optProduto = produto.map(ProdutoMapper::mapToDomainEntity);
		}
		return optProduto;
    }
    
    public static ProdutoDTO mapToWebDTO(Produto produto) {
	return Optional.ofNullable(produto)
		.map(x -> ProdutoDTO.builder()
			.id(x.getId())
			.nome(x.getNome())
			.ean(x.getEan())
			.fabricante(FabricanteMapper.mapToWebDTO(x.getFabricante()))
			.build())
		.orElse(null);
    }

    public static Produto mapToDomainEntity(ProdutoJpaEntity produtoJpaEntity) {
	return Optional.ofNullable(produtoJpaEntity)
		.map(x -> Produto.builder()
			.id(x.getId())
			.nome(x.getNome())
			.ean(x.getEan())
			.fabricante(FabricanteMapper.mapToDomainEntity(x.getFabricante()))		
			.build())
		.orElse(null);
    }

    public static List<Produto> mapToDomainEntity(List<ProdutoJpaEntity> produtosJpa) {
    	List<Produto> produtos = Collections.emptyList();

    	if (!CollectionUtils.isEmpty(produtosJpa)) {
    		produtos = produtosJpa.stream().filter(Objects::nonNull).map(ProdutoMapper::mapToDomainEntity)
    		    .collect(Collectors.toList());
    	}

    	return produtos;
    }
    
    public static Produto mapToDomainEntity(ProdutoDTO produtoDTO) {
    	return Optional.ofNullable(produtoDTO)
    		.map(x -> Produto.builder()
    			.id(x.getId())
    			.nome(x.getNome())
    			.ean(x.getEan())
    			.fabricante(FabricanteMapper.mapToDomainEntity(x.getFabricante()))		
    			.build())
    		.orElse(null);
        }
    
    
    
    public static ProdutoJpaEntity mapToJpaEntity(Produto produto) {
    	return Optional.ofNullable(produto)
    		.map(x -> ProdutoJpaEntity.builder()
				.id(x.getId())
				.nome(x.getNome())
				.ean(x.getEan())
				.fabricante(FabricanteMapper.mapToJpaEntity(x.getFabricante()))	  			
				.build())
    		.orElse(null);
        }

}
