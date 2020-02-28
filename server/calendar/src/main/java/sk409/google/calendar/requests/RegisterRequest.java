package sk409.google.calendar.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotNull
    @Size(min = 1, max = 256)
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Size(min = 1, max = 256)
    @Email
    private String email;

}