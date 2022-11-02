package liga.medical.personservice.core.security.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "roles", schema = "medical")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Override
    public String getAuthority() {
        return getName();
    }
}
