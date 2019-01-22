package it.linksmt.teamshare.business.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.linksmt.teamshare.business.services.ActivityStateService;

@Service
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public class ActivityStateServiceImpl implements ActivityStateService {

	
}
