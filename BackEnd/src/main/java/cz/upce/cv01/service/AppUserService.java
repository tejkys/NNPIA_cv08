package cz.upce.cv01.service;

import cz.upce.cv01.domain.AppUser;
import cz.upce.cv01.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppUserService {
    private final AppUserRepository userRepository;
    public Optional<AppUser> getUserById(final String id) {
        var result = userRepository.findById(Long.valueOf(id));
        return result;
    }
    public AppUser update(final AppUser user) {
        var result = userRepository.save(user);
        return result;
    }
    public void delete(final long id) {
        userRepository.deleteById(id);
    }
    public List<AppUser> findAllByActive(boolean active){
        return userRepository.findAllByActiveEquals(active);
    }
}
