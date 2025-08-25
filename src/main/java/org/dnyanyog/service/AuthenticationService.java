package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.dto.AuthenticationRequest;
import org.dnyanyog.dto.AuthenticationResponseData;
import org.dnyanyog.dto.ValidationResponse;

public interface AuthenticationService {

	Optional<AuthenticationResponseData> registerUser(AuthenticationRequest request) throws Exception ;

	ValidationResponse validate(String userName, String password);

}