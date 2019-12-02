package pl.piotrlenar.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UserDto {

    private String username;
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String repeatPassword;

}
