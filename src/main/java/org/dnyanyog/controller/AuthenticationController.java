package org.dnyanyog.controller;

import java.util.Optional;

import org.dnyanyog.dto.AuthenticationRequest;
import org.dnyanyog.dto.AuthenticationResponseData;
import org.dnyanyog.dto.ValidationResponse;
import org.dnyanyog.encryption.EncryptionUtil;
import org.dnyanyog.service.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationServiceImpl service;

	@PostMapping(path = "/oauth/add-user")
	public Optional<AuthenticationResponseData> addUser( @Valid @RequestBody AuthenticationRequest request) throws Exception {
		return service.registerUser(request);
	}

	@PostMapping(path = "/oauth/validate")
	public ValidationResponse validate(@RequestBody AuthenticationRequest request) throws Exception {
		return service.validate(request.getUserName(), EncryptionUtil.encrypt(request.getPassword()));
	}
}