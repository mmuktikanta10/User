package com.shopping.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "full_name")
    private String name;
    @Column(name = "username")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "alternate_email")
    private String alternateEmail;
    @Column(name = "hashed_password")
    private String password;
    @Column(name = "shipping_address")
    private String shippingAddress;
    @Column(name = "billing_address")
    private String billingAddress;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "user_status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Column(name = "language_preference")
    private String languagePreferences;
    @Column(name = "currency_preference")
    private String currencyPreferences;
    @Column(name = "privacy_preferences")
    private boolean privacyPreferences;
    @Column(name = "email_subscription")
    private boolean emailSubscription;

}
