package org.nanotek.repository;

import java.util.List;

import org.nanotek.beans.ArtistCreditName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistCreditNameRepository extends JpaRepository<ArtistCreditName,Long> {
	
	public List<ArtistCreditName> findByArtistCreditId(Long id);
	
}