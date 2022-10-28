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

import java.sql.Date;
import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "illness", schema = "medical")
public class Illness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type_id", nullable = false)
    private long typeId;

    @Column(name = "heaviness", nullable = false, length = 1)
    private String heaviness;

    @Column(name = "appearance_dttm", nullable = false)
    private Timestamp appearanceDttm;

    @Column(name = "recovery_dt", nullable = false)
    private Date recoveryDt;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_card_id", nullable = false)
    @JsonBackReference
    private MedicalCard medicalCardId;
}
