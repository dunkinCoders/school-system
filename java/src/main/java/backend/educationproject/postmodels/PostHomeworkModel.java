package backend.educationproject.postmodels;

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
public class PostHomeworkModel {
    @JsonProperty("homework_description")
    private String description;
    @JsonProperty("homework_deadline")
    private Date deadline_date;
}
