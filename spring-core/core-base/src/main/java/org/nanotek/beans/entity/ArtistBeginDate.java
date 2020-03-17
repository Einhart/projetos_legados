package org.nanotek.beans.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.nanotek.BaseEntity;

@Entity
@DiscriminatorValue("ArtistBeginDate")
public class ArtistBeginDate extends DatableBase<Integer,Integer,Integer> implements BaseEntity{

	private static final long serialVersionUID = 4339317283945952774L;

	public ArtistBeginDate() {
	}

	public ArtistBeginDate(Integer year, Integer month, Integer day) {
		super(year, month, day);
	}

	public ArtistBeginDate(Integer year, Integer month) {
		super(year, month);
	}

	public ArtistBeginDate(Integer year) {
		super(year);
	}

}
