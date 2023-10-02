package com.shopping.user.model.request;

import com.shopping.user.entity.Status;
import com.shopping.user.entity.UserType;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class UserRequestModel {
    @NotNull
    @Length(min = 5, max = 100)
    private String name;
    @NotNull
    @Length(min = 5, max = 100)
    private String userName;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Email
    private String alternateEmail;
    @NotNull
    private String password;
    @NotNull
    @Length(min = 1, max = 500)
    private String shippingAddress;
    @NotNull
    @Length(min = 1, max = 500)
    private String billingAddress;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String languagePreferences;
    @NotNull
    private String currencyPreferences;
    @NotNull
    private boolean privacyPreferences;
    @NotNull
    private boolean emailSubscription;
}
