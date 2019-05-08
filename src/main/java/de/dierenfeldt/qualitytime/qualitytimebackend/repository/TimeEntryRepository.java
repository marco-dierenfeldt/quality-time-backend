package de.dierenfeldt.qualitytime.qualitytimebackend.repository;

import de.dierenfeldt.qualitytime.qualitytimebackend.domain.TimeEntry;
import org.springframework.data.repository.CrudRepository;

public interface TimeEntryRepository extends CrudRepository<TimeEntry, Long> {

}
