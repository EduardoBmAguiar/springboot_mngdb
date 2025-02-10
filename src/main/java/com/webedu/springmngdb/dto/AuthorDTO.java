package com.webedu.springmngdb.dto;

import com.webedu.springmngdb.domain.User;

import java.io.Serializable;
import java.util.Objects;

public class AuthorDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public AuthorDTO() {}

    public AuthorDTO(User user) {
        id = user.getId();
        name = user.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
