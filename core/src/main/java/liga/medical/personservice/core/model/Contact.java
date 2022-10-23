package liga.medical.personservice.core.model;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "phone_number", nullable = false, length = 32)
    private String phoneNumber;

    @Column(name = "email", nullable = false, length = 128)
    private String email;

    @Column(name = "profile_link")
    private String profileLink;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contactId")
    private Set<Address> addressIdSet;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "contactId", fetch = FetchType.LAZY)
    private PersonData personDataId;

    public void addAddressToContact(Address address) {
        if (addressIdSet == null) {
            addressIdSet = new HashSet<>();
        }
        addressIdSet.add(address);
        address.setContactId(this);
    }
}
