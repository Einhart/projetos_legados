package org.nanotek;

import java.io.Serializable;

public interface BaseDescriptionBase<K extends Serializable, ID extends Serializable> extends MutableDescriptionBase<K , ID>{

	@Override
	default ID getId() {
		return get().getId();
	}
	
	@Override
	default void setId(ID id) {
		get().setId(id);
	}
	
	@Override
	default BaseDescriptionBase<K,ID> withId(ID id) {
		return get().withId(id);
	}
	
	default K getDescription() { 
		return get().getDescription();
	}
	
	@Override
	default void setDescription(K id) {
		get().setDescription(id);
	}
	
	@Override
	default BaseDescriptionBase<K,ID> get() {
		return this;
	}
	
}
