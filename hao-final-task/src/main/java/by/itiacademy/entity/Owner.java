package by.itiacademy.entity;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement(name = "root")
@XmlType(propOrder = {"owner", "location", "emails", "cardsOfOwner"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Owner {
    @Getter
    @Setter
    private String owner;

    @Getter
    @Setter
    private String location;

    @Getter
    @Setter
    private List<String> emails = new ArrayList<>();

    @Getter
    @Setter
    private List<Card> cardsOfOwner = new ArrayList<>();


}
