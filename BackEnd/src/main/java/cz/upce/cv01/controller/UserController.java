package cz.upce.cv01.controller;

import cz.upce.cv01.domain.AppUser;
import cz.upce.cv01.dto.AppUserDto;
import cz.upce.cv01.repository.AppUserRepository;
import cz.upce.cv01.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app-user")
public class UserController {
    private final AppUserRepository appUserRepository;
    private final AppUserService userService;
    public UserController(AppUserRepository appUserRepository, AppUserService userService) {

        this.appUserRepository = appUserRepository;
        this.userService = userService;
    }

    @GetMapping("")
    public List<AppUser> findAll() {
        return appUserRepository.findAllByActiveEquals(true);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<AppUser> getEmployeesById(@PathVariable String id) {
        var result = userService.getUserById(id);
        return result;
    }

    @GetMapping("/v2/{id}")
    @ResponseBody
    public ResponseEntity getEmployeesById2(@PathVariable String id) {
        var result = userService.getUserById(id);
        if(result.isEmpty())
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );

        return ResponseEntity.ok(result.get().toDto());
    }
    @PostMapping("")
    private ResponseEntity create(@Valid @RequestBody AppUserDto user)
    {
        var result = userService.update(user.toEntity());
        return ResponseEntity.ok(result);
    }
    @PutMapping("")
    private ResponseEntity update(@RequestBody AppUserDto user)
    {
        var result = userService.update(user.toEntity());
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("{id}")
    private ResponseEntity delete(@PathVariable("id") int id)
    {
        userService.delete(id);
        return ResponseEntity.ok(id);
    }
}