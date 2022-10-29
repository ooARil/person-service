package liga.medical.personservice.core.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "address", schema = "medical")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "country_id", nullable = false)
    private long countryId;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "index", nullable = false)
    private long index;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "buildings", nullable = false, length = 32)
    private String buildings;

    @Column(name = "flat", nullable = false, length = 32)
    private String flat;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id", nullable = false)
    @JsonBackReference
    private Contact contactId;
}
