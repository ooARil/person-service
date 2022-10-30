package liga.medical.personservice.core.security.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {

    private Long id;

    private String username;

    private Set<RoleDto> roles;
}
