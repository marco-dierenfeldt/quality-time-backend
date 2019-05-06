package de.dierenfeldt.qualitytime.qualitytimebackend.service;

import de.dierenfeldt.qualitytime.qualitytimebackend.domain.TimeEntry;
import de.dierenfeldt.qualitytime.qualitytimebackend.repository.TimeEntryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Service
@Transactional
public class TimeEntryService {

    @Inject
    private TimeEntryRepository timeEntryRepository;

    public Optional<TimeEntry> byId(Long id) {
        return timeEntryRepository.findById(id);
    }

    public Optional<TimeEntry> create(String beginDate, String endDate, String description) {
        try {
            TimeEntry timeEntry = new TimeEntry(
                    LocalDateTime.parse(beginDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                    LocalDateTime.parse(endDate, DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                    description
            );
            return Optional.ofNullable(timeEntryRepository.save(timeEntry));
        } catch (DateTimeParseException ex) {
            return Optional.empty();
        }

    }

}
