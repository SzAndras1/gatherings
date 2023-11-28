package hu.gatherings.gathering.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gathering")
public class Gathering {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GATHERING_TABLE")
    @SequenceGenerator(name = "SEQ_GATHERING_TABLE", sequenceName = "SEQ_GATHERING_TABLE", allocationSize = 1, initialValue = 25)
    private Long id;

    private Long ownerId;

    private String description;
}
