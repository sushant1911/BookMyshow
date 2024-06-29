package com.sushant.BookMyshow.BookMyshow.Entity;

import com.sushant.BookMyshow.BookMyshow.CustomConstraints.Adult;
import com.sushant.BookMyshow.BookMyshow.CustomConstraints.ValidMobileNumber;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;
import jakarta.validation.constraints.*;

import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank(message = "First name is required")
    @Size(min = 2, message = "First name should have at least 2 characters")
    String userFirstName;
    @Size(min = 2, message = "First name should have at least 2 characters")
    String userMiddleName;
    @NotBlank(message = "Last name is required")
    @Size(min = 2, message = "Last name should have at least 2 characters")
    String userLastName;
    @NonNull
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Email should be valid")
    String email;
    @NonNull
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    String password;
    @NonNull
    @ValidMobileNumber
    Integer mobileNumber;
    @Adult
    Date birthday;
}
