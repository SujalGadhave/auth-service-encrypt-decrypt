package org.dnyanyog.service;

import java.util.Optional;

import org.dnyanyog.common.ResponseCode;
import org.dnyanyog.dto.AuthenticationRequest;
import org.dnyanyog.dto.AuthenticationResponseData;
import org.dnyanyog.dto.ValidationResponse;
import org.dnyanyog.encryption.EncryptionUtil;
import org.dnyanyog.entity.Authentication;
import org.dnyanyog.repository.AuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	AuthenticationRepo repo;

	@Override
	public Optional<AuthenticationResponseData> registerUser(AuthenticationRequest request) throws Exception {

		Authentication addUser = Authentication
				.getInstance()
				.setUserName(request.getUserName())
				.setPassword(EncryptionUtil.encrypt(request.getPassword()))
				.setUserDob(request.getUserDoB())
				.setUserEmail(request.getUserEmail())
				.setUserRole(request.getUserRole());

		addUser = repo.save(addUser);

		AuthenticationResponseData response = new AuthenticationResponseData();

		if (addUser != null) {
			response.setUserName(addUser.getUserName());
			response.setUserDoB(addUser.getUserDob());
			response.setUserEmail(addUser.getUserEmail());
			response.setUserRole(addUser.getUserRole());
			response.setCode(ResponseCode.SUCCESS_ADD_USER.getCode());
			response.setMessage(ResponseCode.SUCCESS_ADD_USER.getMessage());
		} else {
			response.setCode(ResponseCode.FAIL_ADD_USER.getCode());
			response.setMessage(ResponseCode.FAIL_ADD_USER.getMessage());
		}
		return Optional.of(response);
	}

	@Override
	public ValidationResponse validate(String userName, String password) {

		ValidationResponse response = new ValidationResponse();

		if (userName == null || password == null) {
			response.setCode(ResponseCode.FAIL_LOGIN.getCode());
			response.setMessage(ResponseCode.FAIL_LOGIN.getMessage());
			return response;
		}

		try {

			Optional<Authentication> validateUser = repo.findByUserNameAndPassword(userName, password);

			if (validateUser.isPresent()) {
				response.setCode(ResponseCode.SUCCESS_AUTHENTICATION.getCode());
				response.setMessage(ResponseCode.SUCCESS_AUTHENTICATION.getMessage());
			} else {
				response.setCode(ResponseCode.FAIL_AUTHENTICATION.getCode());
				response.setMessage(ResponseCode.FAIL_AUTHENTICATION.getMessage());
			}
			return response;

		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(ResponseCode.UNKOWN_ERROR.getCode());
			response.setMessage(ResponseCode.UNKOWN_ERROR.getMessage());
			return response;
		}

	}

}
