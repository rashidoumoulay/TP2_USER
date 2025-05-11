package net.rashid.User_Demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Users") @Data @AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    private String id;
    @Column(unique = true , length = 20)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ManyToMany(mappedBy = "users" , fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();
}
