package org.nanotek.service.tranformer;

import org.nanotek.beans.Artist;
import org.nanotek.beans.csv.ArtistBean;
import org.springframework.stereotype.Service;

@Service
public class ArtistTransformer implements Transformer<ArtistBean , Artist>{

	@Override
	public Artist transform(ArtistBean i) {
		Artist artistName = new Artist();
		artistName.setId(i.getId());
		artistName.setName(i.getName());
		artistName.setGid(i.getGid());
		artistName.setSortName(i.getSortName());
		return artistName;
	}

}