package com.emmanuel.community_api.entities;

import java.util.ArrayList;
import java.util.List;

import com.emmanuel.community_api.enums.RoleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "roles")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private RoleType name;

    @ManyToMany(fetch = FetchType.EAGER)  
    private List<User> users = new ArrayList<User>();

    @OneToMany()
    private List<Post> posts = new ArrayList<Post>();


}
