package backend.educationproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "homeworks")
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Homeworks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "deadline_date")
    private Date deadline_date;
    @Column(name = "homework_description", nullable = false)
    private String homework_description;
    @ManyToOne
    @JoinColumn(name = "teacher_subject_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private Teacher_Subjects teacher_subject;

    public Homeworks() {
    }
}
