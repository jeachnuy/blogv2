package com.cos.blogv2.domain.user.entity;

import com.cos.blogv2.domain.mail.model.Addressable;
import com.cos.blogv2.domain.management.entity.Auditable;
import com.cos.blogv2.domain.management.repository.Queries;
import com.cos.blogv2.model.RoleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.management.relation.Role;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter @Setter
@Entity
@NoArgsConstructor
@Table(name = "user")
@Where(clause = Queries.NON_DELETED_CLAUSE) //일반적으로 삭제할때 사용
public class User extends Auditable implements Serializable, Addressable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 30, unique = true)
    private String username;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @JsonIgnore
    @Column(name = "deleted_email")
    private String deletedEmail;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    public User(Long id) {
        this.id = id;
    }

    public User(String username, String email, String password, RoleType role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User()
    @Override
    public Long getId() {
        return null;
    }
}
