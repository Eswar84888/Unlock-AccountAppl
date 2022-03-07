package org.project.rest;

import org.project.blindings.UnlockAccRequest;
import org.project.service.UnlockAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UnlockRestController {
	@Autowired
	private UnlockAccountService service;

	@PostMapping("/unlock")
	public String unlockAccount(@RequestBody UnlockAccRequest unlockAccount) {
		return service.unlockAccounts(unlockAccount);
}
}