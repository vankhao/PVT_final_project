package by.itiacademy.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.*;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;

@ToString
@AllArgsConstructor
@NoArgsConstructor
//@XmlType(propOrder = {"id", "name", "number", "year", "remainder", "available"})
@XmlRootElement(name = "cards")
public class Card {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String number;

    @Getter
    @Setter
    private LocalDate year;

    @Getter
    @Setter
    private Long remainder;

    @Getter
    @Setter
    private boolean available;


}
