package com.application.login.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Kullanıcı adı boş olamaz")
    @Size(min = 3, max = 20, message = "Kullanıcı adı 3 ile 20 karakter arasında olmalıdır")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "Şifre boş olamaz")
    @Size(min = 6, message = "Şifre en az 6 karakter olmalıdır")
    private String password;

    @Column(nullable = false)
    @NotBlank(message = "İsim boş olamaz")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Soyadı boş olamaz")
    private String surname;

    @Column(nullable = false)
    @NotBlank(message = "Telefon numarası boş olamaz")
    @Size(min = 11, max = 11, message = "Telefon numarası 11 karakter olmalıdır")
    private String phone;

    @Column(nullable = false)
    @NotBlank(message = "Mail adresi boş olamaz")
    private String mail;
}
