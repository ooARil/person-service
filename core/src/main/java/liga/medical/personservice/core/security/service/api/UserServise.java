package liga.medical.personservice.core.security.service.api;

import liga.medical.personservice.core.security.dto.UserDto;
import liga.medical.personservice.core.security.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserServise extends UserDetailsService {

    void save(User user);

    User findByUsername(String username);

    List<UserDto> getUsers();

    boolean deleteUser(Long userId);
}
