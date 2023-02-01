package backend.educationproject.clientmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ClientStudents {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("first_name")
    private String first_name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("patronymic")
    private String patronymic;
    @JsonProperty("grades")
    private List<ClientGrades> grades;
}
