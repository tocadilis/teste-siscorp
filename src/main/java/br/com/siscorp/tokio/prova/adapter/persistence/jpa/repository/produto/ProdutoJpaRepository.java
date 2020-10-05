package br.com.siscorp.tokio.prova.adapter.persistence.jpa.repository.produto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.siscorp.tokio.prova.adapter.persistence.jpa.entity.produto.ProdutoJpaEntity;

@Repository
public interface ProdutoJpaRepository extends JpaRepository<ProdutoJpaEntity, Long> {
	@Query("select p FROM ProdutoJpaEntity p ")
	Page<ProdutoJpaEntity> findAllPageable(Pageable pageable);
}
