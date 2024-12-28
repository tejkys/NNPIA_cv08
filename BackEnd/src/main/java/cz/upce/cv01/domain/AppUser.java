package cz.upce.cv01.domain;
import cz.upce.cv01.dto.AppUserDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Data
    @NoArgsConstructor
    @Entity
    public class AppUser {
        @Id
        private Long id;

        @Column
        @NotBlank(message = "Username is mandatory")
        @NotNull(message = "Username is mandatory")
        @Size(min = 6, message = "Username has to be at least 6 chars long")
        private String username;

        @Column
        private String password;

        @Column
        private Boolean active;

        @Column
        private LocalDateTime creationDate;

        @Column
        private LocalDateTime updateDate;
        @EqualsAndHashCode.Exclude
        @OneToMany(mappedBy = "author")
        private List<Task> tasks = Collections.emptyList();
        @EqualsAndHashCode.Exclude
        @ManyToMany(mappedBy = "users")
        private List<Role> roles = Collections.emptyList();

    public AppUser(String username, String password, Boolean active, LocalDateTime creationDate, LocalDateTime updateDate, List<Task> tasks, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.tasks = tasks;
        this.roles = roles;
    }
    public AppUser(String username, String password, Boolean active, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }
    public AppUser(Long id, String username, String password, Boolean active, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }
    public AppUserDto toDto() {
        return new AppUserDto(
                getUsername(),
                getPassword(),
                getActive(),
                getCreationDate(),
                getUpdateDate(),
                getRoles(),
                getTasks()
                );
    }
}
