package cz.upce.cv01.controller;

import cz.upce.cv01.domain.AppUser;
import cz.upce.cv01.domain.Task;
import cz.upce.cv01.dto.TaskDto;
import cz.upce.cv01.repository.AppUserRepository;
import cz.upce.cv01.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class TaskQLController {
    private final TaskService taskService;

    @SchemaMapping(typeName = "AppUser")
    public List<TaskDto> tasks(final AppUser appUser) {
        return taskService.findAllByAppUserId(appUser.getId())
                .stream()
                .map(Task::toDto)
                .collect(Collectors.toList());
    }
}