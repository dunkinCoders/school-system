package backend.educationproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "event_types")
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Event_Types {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="event_type_name",nullable = false)
    @NotBlank
    private String event_type_name;
    public Event_Types() {
    }
}
