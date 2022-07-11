package com.cos.blogv2.domain.mail.validation;

import com.cos.blogv2.domain.mail.model.Addressable;
import com.cos.blogv2.domain.user.repository.UserRepository;
import com.cos.blogv2.errors.exceptions.BadRequestException;
import com.cos.blogv2.errors.model.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailValidations {
    private static UserRepository repository;

    @Autowired
    public EmailValidations(UserRepository repository) {
        EmailValidations.repository = repository;
    }
    public static void validateEmailUniqueness(Addressable entity) {
        if (repository.existsByEmail(entity.getEmail())) {
            throw new BadRequestException(List.of(ValidationError("email", message)))
        }
    }
}
