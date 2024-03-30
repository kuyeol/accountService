package org.acme.reactive.crud.service.dto;

<<<<<<< HEAD
import java.time.Instant;
=======
>>>>>>> origin/main
import java.util.Set;
import java.util.stream.Collectors;

import io.quarkus.runtime.annotations.RegisterForReflection;
<<<<<<< HEAD
import jakarta.validation.constraints.Pattern;
import org.acme.reactive.crud.config.Constants;
=======
>>>>>>> origin/main
import org.acme.reactive.crud.domain.User;

@RegisterForReflection
public class UserDTO {


    public Long id;
    public String email;
<<<<<<< HEAD
    public Instant createdDate;

    @Pattern(regexp = Constants.LOGIN_REGEX)
    public String login;

=======
>>>>>>> origin/main

    public Set<String> authorities;

    public UserDTO() {
        // Empty constructor needed for Jackson.
    }


    public UserDTO(User user) {
<<<<<<< HEAD
        this.id=user.id;
        this.login=user.login;
        this.email = user.email;
        this.createdDate = user.createdDate;
=======
        this.email = user.email;
>>>>>>> origin/main
        this.authorities = user.authorities.stream().map(authority -> authority.name).collect(Collectors.toSet());


    }

}
