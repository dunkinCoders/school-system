package backend.educationproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "journals")
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Journals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "teacher_subject_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private Teacher_Subjects teacher_subject;

    public Journals() {
    }
}
