package cz.upce.cv01.repository;

import cz.upce.cv01.domain.AppUser;
import cz.upce.cv01.domain.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends PagingAndSortingRepository<AppUser, Long> {
    List<AppUser> findAllByActiveEquals(boolean active);
    @Query("select au from AppUser au inner join au.roles r where r = :role")
    List<AppUser> findAllByRolesContaining(final Role role);
}