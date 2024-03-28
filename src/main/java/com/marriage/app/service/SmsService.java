package com.marriage.app.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marriage.app.config.TwilioConfig;
import com.marriage.app.dto.OtpRequest;
import com.marriage.app.dto.OtpResponseDto;
import com.marriage.app.dto.OtpStatus;
import com.marriage.app.dto.OtpValidationRequest;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SmsService {

	@Autowired
	private TwilioConfig twilioConfig;
	Map<String, String> otpMap = new HashMap<>();

	public OtpResponseDto sendSMS(OtpRequest otpRequest) {
		OtpResponseDto otpResponseDto = null;
		try {
			PhoneNumber to = new PhoneNumber(otpRequest.getPhoneNumber());// to
			PhoneNumber from = new PhoneNumber(twilioConfig.getPhoneNumber()); // from
			String otp = generateOTP();
			String otpMessage = "Dear Customer , Your OTP is  " + otp
					+ " for sending sms through Spring boot application. Thank You.";
			Message message = Message
					.creator(to, from,
							otpMessage)
					.create();
			otpMap.put(otpRequest.getPhoneNumber(), otp);
			otpResponseDto = new OtpResponseDto(OtpStatus.DELIVERED, otpMessage);
		} catch (Exception e) {
			e.printStackTrace();
			otpResponseDto = new OtpResponseDto(OtpStatus.FAILED, e.getMessage());
		}
		return otpResponseDto;
	}

	public String validateOtp(OtpValidationRequest otpValidationRequest) {
		String phoneNumber = otpValidationRequest.getPhoneNumber();
		String otpNumber = otpValidationRequest.getOtpNumber();

		if (otpMap.containsKey(phoneNumber) && otpMap.get(phoneNumber).equals(otpNumber)) {
			otpMap.remove(phoneNumber); // Remove the OTP entry after successful validation
			return "OTP is valid!";
		} else {
			return "OTP is invalid!";
		}
	}

	private String generateOTP() {
		return new DecimalFormat("000000")
				.format(new Random().nextInt(999999));
	}

}
