package org.project.service;

import org.project.blindings.UnlockAccRequest;
import org.project.constants.AppConstants;
import org.project.entities.UserEntity;
import org.project.props.AppPreoperties;
import org.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UnlockAccountServiceImpl implements UnlockAccountService {
	@Autowired
  private	UserRepository userRepo; 
	@Autowired
	private AppPreoperties appProps;

	@Override
	public String unlockAccounts(UnlockAccRequest request) {

	UserEntity user=userRepo.findByUserEmailAndUserPwd(request.getEmail(),request.getTempPwd());
		
		if(user!=null) {
			user.setUserPwd(request.getNewPwd());
			user.setUserAccStatus(AppConstants.UNLOCKED);
			userRepo.save(user);
			return appProps.getMessages().get(AppConstants.ACC_UNLOCK_SUCCESS);
		}
		
		return appProps.getMessages().get(AppConstants.INVAILD_TEMP_PWD);
	}

}
