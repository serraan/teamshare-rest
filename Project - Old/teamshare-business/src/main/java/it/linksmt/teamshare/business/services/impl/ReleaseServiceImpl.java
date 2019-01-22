package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.converter.ReleaseConverter;
import it.linksmt.teamshare.business.dto.request.ReleaseRequestDto;
import it.linksmt.teamshare.business.dtos.ReleaseDto;
import it.linksmt.teamshare.business.services.ReleaseService;
import it.linksmt.teamshare.dao.entities.Release;
import it.linksmt.teamshare.dao.repositories.ReleaseRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class ReleaseServiceImpl implements ReleaseService {
	
	@Autowired
	private ReleaseRepository releaseRepository;

	@Override
	public List<ReleaseDto> getReleases() {

		List<Release> releases = (List<Release>) releaseRepository.findAll();
		
		return ReleaseConverter.MAPPER.toListReleaseDto(releases);
	}

	@Override
	public ReleaseDto getRelease(Integer releaseId) {

		Optional<Release> release = releaseRepository.findById(releaseId);

		return ReleaseConverter.MAPPER.toReleaseDto(release.get());
	}

	@Override
	public ReleaseDto addRelease(ReleaseRequestDto releaseRequestDto) {

		Release release = ReleaseConverter.MAPPER.toRelease(releaseRequestDto);
		
		release = releaseRepository.save(release);
		
		return ReleaseConverter.MAPPER.toReleaseDto(release);
	}

	@Override
	public ReleaseDto updateRelease(Integer releaseId, ReleaseRequestDto releaseRequestDto) {

		Release release = ReleaseConverter.MAPPER.toRelease(releaseRequestDto);
		release.setId(releaseId);
		
		release = releaseRepository.save(release);

		return ReleaseConverter.MAPPER.toReleaseDto(release);
	}

	@Override
	public void deleteRelease(Integer releaseId) {

		releaseRepository.deleteById(releaseId);
	}
	
}
