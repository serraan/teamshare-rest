package it.linksmt.teamshare.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.dtos.ReleaseDto;
import it.linksmt.teamshare.business.request.ReleaseRequestDto;
import it.linksmt.teamshare.business.services.ReleaseService;
import it.linksmt.teamshare.converter.ReleaseConverter;
import it.linksmt.teamshare.entities.Release;
import it.linksmt.teamshare.repository.ReleaseRepository;

@Service
@Transactional
public class ReleaseServiceImpl implements ReleaseService {

	@Autowired
	private ReleaseRepository releaseRepository;
	
	@Override
	public List<ReleaseDto> searchRelease() {
		List<Release> rel = (List<Release>) releaseRepository.findAll();
		return ReleaseConverter.MAPPER.toListReleaseDTO(rel);
	}

	@Override
	public ReleaseDto getRelease(Integer id) {
		Optional<Release> att = releaseRepository.findById(id);
		return ReleaseConverter.MAPPER.toReleaseDto(att.get());
	}

	@Override
	public ReleaseDto addRelease(ReleaseRequestDto rel) {
		Release a = ReleaseConverter.MAPPER.toRelease(rel);
		a = releaseRepository.save(a);
		return ReleaseConverter.MAPPER.toReleaseDto(a);
	}

	@Override
	public ReleaseDto updateRelease(Integer relId, ReleaseRequestDto release) {
		Release a = ReleaseConverter.MAPPER.toRelease(release);
		a.setId(relId);
		a = releaseRepository.save(a);
		return ReleaseConverter.MAPPER.toReleaseDto(a);
	}

	@Override
	public void deleteRelease(Integer id) {
		releaseRepository.deleteById(id);
	}

}
