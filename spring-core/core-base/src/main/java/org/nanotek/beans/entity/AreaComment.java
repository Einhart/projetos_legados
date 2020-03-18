package org.nanotek.beans.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.nanotek.BaseEntity;
import org.nanotek.entities.MutableCommentEntity;

@Entity
@DiscriminatorValue(value = "AreaComment")
public class AreaComment<E extends Serializable> extends CommentBase<String, AreaComment<E>> implements  MutableCommentEntity<String>,BaseEntity{

	private static final long serialVersionUID = -68821965634755841L;
	
	@NotNull
	@OneToOne(mappedBy = "areaComment")
	public Area<?> area;

	public AreaComment() {}
	
	public AreaComment(@NotBlank String comment) {
		super(comment);
	}

	public AreaComment(@NotBlank String comment,@NotNull Area<E> area) {
		super(comment);
		this.area = area;
	}

	public Area<?> getArea() {
		return area;
	}

	public void setArea(Area<?> area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "AreaComment [area=" + area + ", comment=" + comment + ", id=" + id + "]";
	}

	@Override
	public String getComment() {
		return comment;
	}
}
