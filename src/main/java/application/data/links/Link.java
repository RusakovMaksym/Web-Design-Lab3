package application.data.links;

import application.data.users.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

@Data
@Entity
@Table(name = "links")
@ToString
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_link")
    private String fullLink;

    @Column(name = "short")
    private String shortLink;

    @Column(name = "created" , nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp created = new Timestamp(Calendar.getInstance().getTime().getTime());

    @JsonIgnoreProperties("links")
    @JsonProperty("user")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}