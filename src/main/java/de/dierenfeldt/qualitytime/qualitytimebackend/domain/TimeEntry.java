package de.dierenfeldt.qualitytime.qualitytimebackend.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "TIME_ENTRY")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TimeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    @Column(name = "ID", nullable = false)
    private Long id;

    @Basic(optional = false)
    @Column(name = "BEGIN_DATE", nullable = false)
    @NotNull
    @Getter
    @Setter
    private LocalDateTime beginDate;

    @Basic(optional = false)
    @Column(name = "END_DATE", nullable = false)
    @NotNull
    @Getter
    @Setter
    private LocalDateTime endDate;

    @Basic(optional = false)
    @Column(name = "DESCRIPTION", nullable = false)
    @NotNull
    @Getter
    @Setter
    private String description;


    public TimeEntry(LocalDateTime beginDate, LocalDateTime endDate, String description) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.description = description;
    }
}
