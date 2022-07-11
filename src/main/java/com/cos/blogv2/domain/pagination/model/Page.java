package com.cos.blogv2.domain.pagination.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.Collection;

@Getter
@Schema(requiredProperties = {"content", "page", "size", "totalPages", "totalElements"})
public class Page<T> {
    private final Collection<? extends T> content;
    private final Integer page;
    private final Integer size;
    private final Integer totalPages;
    private final Long totalElements;

    public Page(org.springframework.data.domain.Page<T> page) {
        this.content = page.getContent();
        this.page = page.getNumber();
    }
}
