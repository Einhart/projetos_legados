package org.nanotek.beans;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.nanotek.Base;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@SuppressWarnings("serial")
@Entity
@Table(name="artist_credit")
@NamedQueries(value = { 
		@NamedQuery(name = "FindArtistCreditById", query ="Select a from ArtistCredit a where a.artistCreditId = :artistCreditId"),
		@NamedQuery(name = "ArtistCreditLoadAll", query ="Select a from ArtistCredit a order by a.id asc"),
		@NamedQuery(name="FindArtistCredits" , query = "Select a from ArtistCredit a where a.artistCreditId in (:ids)"),
		@NamedQuery(name="ArtistCredit.findByArtistCreditId" , query="Select a from ArtistCredit a left outer join a.releases where a.artistCreditId = :id")
		//		@NamedQuery(name="FindArtistCreditsByArtistId" , query="Select a from ArtistCredit a inner join a.artistCreditNames n where n.artist = :artistId")
})
public class ArtistCredit implements Base<Long> {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="artist_credit_id_seq")
	@SequenceGenerator(name = "artist_credit_id_seq", sequenceName = "artist_credit_id_seq")
	private Long id;
	@Column(name="artist_credit_id" , insertable=true,nullable=false,unique = true)
	private Long artistCreditId;
	@Column (name="artist_name" ,length=1000, insertable=true,nullable=false)
	private String name; 
	@Column (name="artist_count")
	private Long artistCount; 
	@Column (name="ref_count")
	private Long refCount;

	@JsonBackReference
	@OneToMany(fetch=FetchType.LAZY,mappedBy="artistCreditReference")
	private Set<Release> releases; 

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="artist_credit_name_rel",
	inverseJoinColumns={@JoinColumn(name="artist_name_id", referencedColumnName="id") },
	joinColumns={ @JoinColumn(name="artist_credit_id", referencedColumnName="id") })
	private List<ArtistName> artists;
	
/*	@OneToMany(fetch=FetchType.LAZY,mappedBy="artistCreditReference")
	private Set<Recording> recordings; */
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	public Long getArtistCreditId() {
		return artistCreditId;
	}

	public void setArtistCreditId(Long artistCreditId) {
		this.artistCreditId = artistCreditId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getArtistCount() {
		return artistCount;
	}

	public void setArtistCount(Long artistCount) {
		this.artistCount = artistCount;
	}

	public Long getRefCount() {
		return refCount;
	}

	public void setRefCount(Long refCount) {
		this.refCount = refCount;
	}

	@Override
	public String toString() {
		return "ArtistCredit [id=" + id + ", artistCreditId=" + artistCreditId
				+ ", name=" + name + ", artistCount=" + artistCount
				+ ", refCount=" + refCount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((artistCreditId == null) ? 0 : artistCreditId.hashCode());
		return result;
	}

	public Set<Release> getReleases() {
		return releases != null ? releases : (releases = newAnyType(HashSet::new)); 
	}

	public void setReleases(Set<Release> releases) {
		this.releases = releases;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtistCredit other = (ArtistCredit) obj;
		if (artistCreditId == null) {
			if (other.artistCreditId != null)
				return false;
		} else if (!artistCreditId.equals(other.artistCreditId))
			return false;
		return true;
	}

	public List<ArtistName> getArtists() {
		return artists;
	}

	public void setArtists(List<ArtistName> artists) {
		this.artists = artists;
	}

}
