package com.spring.boot.jpa.onetoone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfilesRepository extends JpaRepository<UserProfiles, Integer> {

}
