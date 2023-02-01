package backend.educationproject.clientmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ClientGrades {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("grade")
    private Integer grade;
}
