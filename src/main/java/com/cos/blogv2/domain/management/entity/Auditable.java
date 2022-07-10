package com.cos.blogv2.domain.management.entity;

import com.cos.blogv2.domain.management.model.Entity;
import com.cos.blogv2.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@MappedSuperclass
public abstract class Auditable implements Entity {
    @Override
    public abstract Long getId();

    @JsonIgnore
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @JsonIgnore
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @JoinColumn(name = "created_by")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User createdBy;

    @JoinColumn(name = "updated_by")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User updatedBy;

    @Column(name = "active", nullable = false)
    private Boolean active = true;

    @JoinColumn(name = "deleted_by")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User deletedBy;

    @JsonIgnore
    public Optional<User> getCreatedBy() {
        return Optional.ofNullable(createdBy);
    }

    @JsonIgnore
    public Optional<User> getUpdateBy() {
        return Optional.ofNullable(updatedBy);
    }

    @JsonIgnore
    public Optional<User> getDeletedBy() {
        return Optional.ofNullable(deletedBy);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Boolean isActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private void save() {
        createdAt = LocalDateTime.now();
    }
}
