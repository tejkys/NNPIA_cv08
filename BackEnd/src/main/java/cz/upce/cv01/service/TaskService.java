package cz.upce.cv01.service;

import cz.upce.cv01.domain.Task;
import cz.upce.cv01.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> findAllByAppUserId(final Long appUserId) {
        return taskRepository.findAllByAuthorId(appUserId);
    }
    public List<Task> getAll() {
        return taskRepository.findAll();
    }
    public Task findById(Long id) {
        return taskRepository.findById(id).get();
    }
}