package cz.upce.cv01.dto;

import cz.upce.cv01.domain.AppUser;
import cz.upce.cv01.domain.Role;
import cz.upce.cv01.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {
    private String username;
    private String password;
    private Boolean active;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private List<Role> roles = Collections.emptyList();
    private List<Task> tasks = Collections.emptyList();
    public AppUser toEntity() {
        return new AppUser(
                getUsername(),
                getPassword(),
                getActive(),
                getCreationDate(),
                getUpdateDate()
        );
    }
}
