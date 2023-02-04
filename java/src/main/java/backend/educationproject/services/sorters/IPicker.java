package backend.educationproject.services.sorters;

import backend.educationproject.clientmodels.ClientGrades;

import java.util.List;

public interface IPicker {
    public void pick(List<ClientGrades> clientGrades, Long month);
}
