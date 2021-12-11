package com.spring.boot.jpa.onetoone;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user_profiles")
public class UserProfiles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	@Column(length = 100)
	private String address1;
	private String address2;
	private String city;
	private String country;
	private Date dob;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Gender gender;
	@Column(name = "phone_number")
	private String phoneNumber;
	private String state;
	private String street;
	@Column(name = "zip_code")
	private String zipCode;
	@OneToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "user_id",nullable = false)
	private Users users;
}
