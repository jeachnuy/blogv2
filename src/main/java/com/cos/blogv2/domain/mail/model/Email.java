package com.cos.blogv2.domain.mail.model;

import org.thymeleaf.context.Context;

public interface Email {
    String getDestination();

    String getSubject();

    String getTemplate();

    Context getContext();
}
