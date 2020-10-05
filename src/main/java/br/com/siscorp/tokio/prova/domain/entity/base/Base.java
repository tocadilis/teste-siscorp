package br.com.siscorp.tokio.prova.domain.entity.base;

import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
@EqualsAndHashCode
public abstract class Base {
	
	@Getter
	private long id;
}
