package backend.educationproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "events")
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "event_description")
    private String event_description;
    @Column(name = "event_date", nullable = false)
    @NotNull
    private Date event_date;
    @ManyToOne
    @JoinColumn(name = "event_type", referencedColumnName = "id", nullable = false)
    @NotNull
    private Event_Types event_type;
    @ManyToOne
    @JoinColumn(name = "journal_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private Journals journal;

    public Events() {
    }
}
