package org.nanotek.beans.csv;

import org.nanotek.Result;
import org.nanotek.beans.entity.ReleaseGroup;

public class ReleaseGroupBean extends Result<ReleaseGroupBean,ReleaseGroup<ReleaseGroupBean>> {

	private static final long serialVersionUID = -1119657398190391884L;

	private Long releaseGroupId; 
	private String gid; 
	private String name; 
	private Long artistCredit; 
	private Long type;
	private String comment; 
	private String editsPending;
	private String lastUpdated;
	
	public ReleaseGroupBean() { 
		super();
	}
	
	

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getArtistCredit() {
		return artistCredit;
	}

	public void setArtistCredit(Long artistCredit) {
		this.artistCredit = artistCredit;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getEditsPending() {
		return editsPending;
	}

	public void setEditsPending(String editsPending) {
		this.editsPending = editsPending;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}


	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}



	public Long getReleaseGroupId() {
		return releaseGroupId;
	}



	public void setReleaseGroupId(Long releaseGroupId) {
		this.releaseGroupId = releaseGroupId;
	}

}
