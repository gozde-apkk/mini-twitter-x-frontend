package com.workintech.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


@Data
@NoArgsConstructor
@Entity
@Table(name = "roles",schema = "public")
public class Role implements  GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int roleId;

    @Column(name = "authority")
    private String authority;
}
