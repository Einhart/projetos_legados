package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.nanotek.LongBase;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class)
@MappedSuperclass
public class SequenceLongBase {

	@Id
	@NotNull
	@Column(name="id",nullable=false,unique=true)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sequence_id_seq")
	@SequenceGenerator(name = "sequence_id_seq", sequenceName = "sequence_id_seq")
	protected Long id;

	public SequenceLongBase() {}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "SequenceLongBase [id=" + id + "]";
	}

}
