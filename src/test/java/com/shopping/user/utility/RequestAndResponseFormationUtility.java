package com.shopping.user.utility;

import com.shopping.user.entity.UserEntity;
import com.shopping.user.model.request.UserRequestModel;
import com.shopping.user.model.response.UserResponseModel;

public class RequestAndResponseFormationUtility {
    public UserRequestModel requestModel=UserRequestModel.builder()
            .alternateEmail("alternateEmail@gmail.com")
            .billingAddress("billing address")
            .email("dummy@gmail.com")
            .currencyPreferences("INR")
            .emailSubscription(false)
            .languagePreferences("hindi oriya")
            .password("12345")
            .phoneNumber("12345")
            .name("Kanha")
            .shippingAddress("shipping address")
            .privacyPreferences(false)
            .userName("kanha111")
            .build();
    public UserRequestModel requestModelWithValidationError=UserRequestModel.builder()
            .alternateEmail("alternateEmail@gmail.com")
            .billingAddress("billing address")
            .email("emailgmail.com")
            .currencyPreferences("INR")
            .emailSubscription(false)
            .languagePreferences("hindi oriya")
            .password("12345")
            .phoneNumber("12345")
            .name("Kanha")
            .shippingAddress("shipping address")
            .privacyPreferences(false)
            .userName("kanha111")
            .build();
    public UserResponseModel responseModel=UserResponseModel.builder()
            .billingAddress("billing address")
            .email("dummy@gmail.com")
            .currencyPreferences("INR")
            .emailSubscription(false)
            .languagePreferences("hindi oriya")
            .password("12345")
            .phoneNumber("12345")
            .name("Kanha")
            .shippingAddress("shipping address")
            .privacyPreferences(false)
            .userName("kanha111")
            .build();
    public UserEntity userEntity=UserEntity.builder()
            .alternateEmail("alternateEmail@gmail.com")
            .billingAddress("billing address")
            .email("dummy@gmail.com")
            .currencyPreferences("INR")
            .emailSubscription(false)
            .languagePreferences("hindi oriya")
            .password("12345")
            .phoneNumber("12345")
            .name("Kanha")
            .shippingAddress("shipping address")
            .privacyPreferences(false)
            .userName("kanha111")
            .build();
}
