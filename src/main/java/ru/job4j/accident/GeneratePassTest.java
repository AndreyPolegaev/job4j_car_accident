package ru.job4j.accident;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class GeneratePassTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEcorder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEcorder.encode("pass");
        System.out.println(passwordEcorder.matches("pass", encodedPassword));
    }
}

