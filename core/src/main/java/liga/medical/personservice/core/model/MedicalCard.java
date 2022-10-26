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

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "medical_card")
public class MedicalCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "client_status", nullable = false, length = 1)
    private String clientStatus;

    @Column(name = "med_status", length = 1)
    private String medStatus;

    @Column(name = "registry_dt", nullable = false)
    private Date registryDt;

    @Column(name = "comment")
    private String comment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalCardId")
    private List<Illness> illnessIdList;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "medicalCardId", fetch = FetchType.LAZY)
    private PersonData personDataId;

    public void addIllnessToMedicalCard(Illness illness) {
        if (illnessIdList == null) {
            illnessIdList = new ArrayList<>();
        }
        illnessIdList.add(illness);
        illness.setMedicalCardId(this);
    }
}
