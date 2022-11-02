package liga.medical.personservice.core.security.service;

import liga.medical.personservice.core.security.dto.UserDto;
import liga.medical.personservice.core.security.entity.User;
import liga.medical.personservice.core.security.mapper.UserMapper;
import liga.medical.personservice.core.security.repository.RoleRepository;
import liga.medical.personservice.core.security.repository.UserRepository;
import liga.medical.personservice.core.security.service.api.UserServise;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServise {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserMapper userMapper;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        // 1L - это id=1, т.е. возвращается объект Role,
        // с полем role = USER
        user.setRoles(Set.of(roleRepository.findById(1L).get()));

        userRepository.save(user);
    }

    @Override
    public List<UserDto> getUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().stream().forEach(x -> grantedAuthorities.add(new SimpleGrantedAuthority(x.getName())));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
