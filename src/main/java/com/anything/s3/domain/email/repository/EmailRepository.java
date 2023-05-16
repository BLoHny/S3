package com.anything.s3.domain.email.repository;

import com.anything.s3.domain.email.entity.Email;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<Email, String> {
}
