package backend.educationproject.services.sorters;

import backend.educationproject.clientmodels.ClientGrades;
import backend.educationproject.repositories.EventsRepository;

import java.util.Comparator;
import java.util.Date;

public class JournalDateComparator implements Comparator<ClientGrades> {
    private final EventsRepository eventsRepository;

    public JournalDateComparator(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public int compare(ClientGrades client_grade1, ClientGrades client_grade2) {
        Date date1 = eventsRepository.findById(client_grade1.getEvent_id()).get().getEvent_date();
        Date date2 = eventsRepository.findById(client_grade2.getEvent_id()).get().getEvent_date();
        if(date2.after(date1)){
            return -1;
        }
        if (date1.after(date2)) {
            return 1;
        }
        return 0;
    }
}
