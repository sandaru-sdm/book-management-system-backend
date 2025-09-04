package com.sdm.bms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;

    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deletedAt;
}
