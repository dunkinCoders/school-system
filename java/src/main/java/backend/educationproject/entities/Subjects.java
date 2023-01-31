package backend.educationproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subjects")
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="subject_name",nullable = false)
    @NotBlank
    private String subject_name;

    public Subjects() {
    }
}
