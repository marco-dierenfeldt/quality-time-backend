package de.dierenfeldt.qualitytime.qualitytimebackend.api;

import de.dierenfeldt.qualitytime.qualitytimebackend.domain.TimeEntry;
import de.dierenfeldt.qualitytime.qualitytimebackend.service.TimeEntryService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Optional;

@RestController
@RequestMapping(value = "/timebooking")
public class TimeBookingResource {

    @Inject
    private TimeEntryService timeEntryService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TimeEntry get(@PathVariable("id") Long id) throws InvalidRequestException {
        Optional<TimeEntry> timeEntry = timeEntryService.byId(id);
        return timeEntry.orElseThrow(
                () -> new InvalidRequestException("No TimeEntry found for id=" + id)
        );
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public TimeEntry create(@RequestBody TimeEntry timeEntry) throws InvalidRequestException {
        Optional<TimeEntry> timeEntryOptional = timeEntryService.create(timeEntry);
        return timeEntryOptional.orElseThrow(
                () -> new InvalidRequestException("Can not persist TimeEntry=" + timeEntry.toString())
        );
    }
}
