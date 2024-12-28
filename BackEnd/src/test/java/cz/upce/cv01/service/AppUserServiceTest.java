package cz.upce.cv01.service;

import cz.upce.cv01.domain.AppUser;
import cz.upce.cv01.repository.AppUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppUserServiceTest {
    public static final AppUser APP_USER = new AppUser(100L, "st55774", "12345", true, LocalDateTime.now(), LocalDateTime.now());
    private AppUser existing = null;
    @Autowired
    private AppUserService appUserService;

    //@MockBean
    @Autowired
    private AppUserRepository appUserRepository;

    @BeforeEach
    void setUp() {
        //Mockito.when(appUserRepository.findById(100L)).thenReturn(Optional.of(APP_USER));
        existing = appUserRepository.save(APP_USER);
    }

    @AfterEach
    void tearDown() {
        appUserRepository.deleteAll();
    }

    @Test
    void findById(){
        //var actual = appUserService.getUserById(100L + "");
        var actual = appUserService.getUserById(existing.getId() + "");

        //assertEquals(APP_USER, actual);
        assertEquals(existing, actual);
    }
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetUserById() {
        ResponseEntity<AppUser> response = restTemplate.getForEntity("/api/v1/app-user/{id}", AppUser.class, 1);
        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(response.getBody().getId(), 1);
    }

    @Test
    public void testGetNonExistingUserById() {
        ResponseEntity<AppUser> response = restTemplate.getForEntity("/api/v1/app-user/{id}", AppUser.class, 100);
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }
}