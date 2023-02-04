package backend.educationproject.clientmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ClientHomework {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("homework_description")
    private String description;
    @JsonProperty("deadline_date")
    private Date date;
}
