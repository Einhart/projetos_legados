package org.nanotek.repository.jpa;

import java.io.Serializable;
import java.util.Optional;

import org.nanotek.BaseDescriptionBase;

public interface BaseDescriptionBaseRepository<O extends BaseDescriptionBase<ID> , ID extends Serializable>{
	Optional<O> findByDescription(ID id);
}