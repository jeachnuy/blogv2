package com.cos.blogv2.domain.user.entity.form;

import com.cos.blogv2.domain.mail.model.Addressable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class CreateUserProps implements Addressable {

    @NotEmpty(message = "${user.username.not-empty}")
    private String name;

    @NotEmpty(message = "${user.email.not-empty}")
    @Email(message = "{user.email.is-valid}")
    private String email;

    @NotEmpty(message = "${user.password.not-empty}")
    @Size(min = 8, max = 155, message = "{user.password.size}")
    private String password;

    public void validate(BindingResult result) {
    }
}
