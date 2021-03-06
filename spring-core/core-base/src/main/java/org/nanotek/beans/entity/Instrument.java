package org.nanotek.beans.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="instrument")
public class Instrument extends LongIdGidNameEntity {

	private static final long serialVersionUID = 1720965406197902687L;
	
	@Column(name="instrument_id" , nullable=false)
	private Long instrumentId; 

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY , optional = false )
	private InstrumentType type; 
	
	@OneToOne(optional=true)
	@JoinTable(
			  name = "instrument_comment_join", 
			  joinColumns = @JoinColumn(name = "instrument_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "comment_id",referencedColumnName = "id"))
	private InstrumentComment comment;
	
	@OneToOne(optional=true)
	@JoinTable(
			  name = "description_comment_join", 
			  joinColumns = @JoinColumn(name = "instrument_id" , referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "description_id",referencedColumnName = "id"))
	private InstrumentDescription description;
	
	public Instrument() {
	}
	
	public Instrument(  @NotNull Long id,  
						@NotBlank @Size(min = 1, max = 50) String gid, 
						@NotBlank String name,
						@NotNull InstrumentType type) {
		super(gid,name);
		this.type = type;
		this.instrumentId = id;
	}

	public Instrument(
						@NotNull Long id, 
						@NotBlank @Size(min = 1, max = 50) String gid, 
						@NotBlank String name,
						@NotNull InstrumentType type, 
						InstrumentComment comment, 
						InstrumentDescription description) {
		super(gid,name);
		this.type = type;
		this.comment = comment;
		this.description = description;
		this.instrumentId = id;
	}

	public InstrumentComment getComment() {
		return comment;
	}

	public void setComment(InstrumentComment comment) {
		this.comment = comment;
	}

	public InstrumentDescription getDescription() {
		return description;
	}

	public void setDescription(InstrumentDescription description) {
		this.description = description;
	}

	public InstrumentType getType() {
		return type;
	}

	public void setType(InstrumentType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((instrumentId == null) ? 0 : instrumentId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrument other = (Instrument) obj;
		if (instrumentId == null) {
			if (other.instrumentId != null)
				return false;
		} else if (!instrumentId.equals(other.instrumentId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Instrument [instrumentId=" + instrumentId + ", type=" + type + ", comment=" + comment + ", description="
				+ description + ", gid=" + gid + ", name=" + name + ", id=" + id + "]";
	}

}
