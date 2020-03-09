package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value = "BaseTypeDescription")
public class BaseTypeDescription extends DescriptionBase{

	private static final long serialVersionUID = -5502992535337974047L;
	
	@OneToOne
	protected BaseType baseType;

	public BaseTypeDescription() {
	}

	public BaseTypeDescription(@NotNull String description) {
		super(description);
	}
	
	

}
