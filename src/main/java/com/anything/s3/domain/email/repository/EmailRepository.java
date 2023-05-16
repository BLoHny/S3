package com.anything.s3.domain.email.repository;

import com.anything.s3.domain.email.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, String> {
}
