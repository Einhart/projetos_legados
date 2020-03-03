package org.nanotek.service.tranformer;

import java.util.Optional;

import org.nanotek.Transformer;
import org.nanotek.beans.csv.ReleaseBean;
import org.nanotek.beans.entity.ArtistCredit;
import org.nanotek.beans.entity.Release;
import org.nanotek.service.jpa.ArtistCreditJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier(value="ReleaseTransformer")
public class ReleaseTransformer implements Transformer<ReleaseBean , Release> {

	@Autowired 
	private ArtistCreditJpaService creditJpaService;
	
	@Override
	public Release transform(ReleaseBean i) {
		Release release = new Release(); 
		release.setId(i.getId());
		release.setBarCode(i.getBarcode());
//		release.setCountry(i.getLanguage());
		release.setName(i.getName());
		release.setGid(i.getGid());
		release.setReleaseGroup(i.getReleaseGroup());
		release.setStatus(i.getStatus() != null ? i.getStatus().toString() : null);
		Optional<ArtistCredit> opt = findArtistCredit(i.getArtistCreditId());
		if (opt.isPresent())
			release.setArtistCredit(opt.get());
		return release;
	}

	@Transactional
	private Optional<ArtistCredit> findArtistCredit(Long artistCreditId) {
		return creditJpaService.findById(artistCreditId);
	}

}
