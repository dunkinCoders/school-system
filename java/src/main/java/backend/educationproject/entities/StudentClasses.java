package backend.educationproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "classes")
@Setter
@Getter
@AllArgsConstructor
@Builder
public class StudentClasses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "class_letter", nullable = false)
    @NotBlank
    private Character class_Letter;
    @Column(name = "class_number", nullable = false)
    @NotBlank
    @Min(1)
    @Max(12)
    private Integer class_Number;
    @ManyToOne
    @JoinColumn(name = "class_teacher_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private Teachers teacher;

    public StudentClasses() {
    }
}
