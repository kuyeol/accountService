package org.acme.reactive.crud.service.dto;

import java.util.Set;
import java.util.stream.Collectors;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.acme.reactive.crud.domain.User;

@RegisterForReflection
public class UserDTO {


    public Long id;
    public String email;

    public Set<String> authorities;

    public UserDTO() {
        // Empty constructor needed for Jackson.
    }


    public UserDTO(User user) {
        this.email = user.email;
        this.authorities = user.authorities.stream().map(authority -> authority.name).collect(Collectors.toSet());


    }

}
