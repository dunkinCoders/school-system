package backend.educationproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "credits")
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Credits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="login",nullable = false)
    private String login;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name="is_admin",nullable = false)
    private Boolean is_admin;
    public Credits() {
    }
}
