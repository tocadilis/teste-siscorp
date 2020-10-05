package br.com.siscorp.tokio.prova.adapter.persistence.jpa.repository.fabricante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.siscorp.tokio.prova.adapter.persistence.jpa.entity.fabricante.FabricanteJpaEntity;

@Repository
public interface FabricanteJpaRepository extends JpaRepository<FabricanteJpaEntity, Long> {

}
