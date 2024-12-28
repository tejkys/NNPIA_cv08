package cz.upce.cv01.domain;

import cz.upce.cv01.dto.TaskDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Task {
    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private LocalDateTime creationDate;

    @Column
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    @ToString.Exclude
    private AppUser author;

    public TaskDto toDto() {
        return new TaskDto(
                getId(),
                getTitle(),
                getDescription(),
                getCreationDate(),
                getUpdateDate()
        );
    }
}