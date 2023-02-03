package backend.educationproject.services.sorters;

import backend.educationproject.clientmodels.ClientGrades;
import backend.educationproject.repositories.EventsRepository;

import java.util.*;

public class JournalMonthPicker {
    private final EventsRepository eventsRepository;

    public JournalMonthPicker(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    public void pick(List<ClientGrades> clientGrades, Long month) {
        for (Iterator<ClientGrades> iterator = clientGrades.iterator(); iterator.hasNext();) {
            ClientGrades client_grade = iterator.next();
            Date event_date = eventsRepository.findById(client_grade.getEvent_id()).get().getEvent_date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(event_date);

            if (calendar.get(Calendar.MONTH) != month) {
                iterator.remove();
            }
        }
    }
}
