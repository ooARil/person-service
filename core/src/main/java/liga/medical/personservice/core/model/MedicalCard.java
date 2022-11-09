package liga.medical.personservice.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

import java.sql.Date;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "medical_card")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicalCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "client_status", nullable = false, length = 1)
    private String clientStatus;

    @Column(name = "med_status", length = 1)
    private String medStatus;

    @Column(name = "registry_dt", nullable = false)
    private Date registryDt;

    @Column(name = "comment")
    private String comment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalCard")
    @JsonManagedReference
    private List<Illness> illnessList;
}
