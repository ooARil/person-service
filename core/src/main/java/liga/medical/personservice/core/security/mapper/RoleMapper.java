package liga.medical.personservice.core.security.mapper;

import liga.medical.personservice.core.security.dto.RoleDto;
import liga.medical.personservice.core.security.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto toDto(Role role);

    Role toEntity(RoleDto roleDto);

    List<RoleDto> toDtoList(List<Role> role);

    List<Role> toEntityList(List<RoleDto> roleDto);
}
