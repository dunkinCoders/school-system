package backend.educationproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name",nullable = false)
    @NotBlank
    private String first_name;
    @Column(name = "surname", nullable = false)
    @NotBlank
    private String surname;
    @Column(name="patronymic",nullable = false)
    @NotBlank
    private String patronymic;
    @Column(name="phone",nullable = false)
    @NotBlank
    @Pattern(regexp = "(\\+\\d{3}\\d{9})" +
            "|(\\+\\d{2}\\(\\d{3}\\)\\d{7})|" +
            "(\\(\\d{3}\\)\\d{7})|" +
            "(0\\(\\d{3}\\)\\d{6})")
    private Long phone;
    @Column(name="email")
    @Email
    private String email;
    @Column(name="student_login",nullable = false)
    @NotBlank
    private String student_login;
    @Column(name="student_password",nullable = false)
    @NotBlank
    private String student_password;
    @ManyToOne
    @JoinColumn(name = "class_id",referencedColumnName = "id",nullable = false)
    @NotNull
    private StudentClasses studentClass;
    public Students() {
    }
}
