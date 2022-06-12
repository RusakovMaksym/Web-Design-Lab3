package application.data.users;

import application.data.links.Link;
import application.data.users.attributes.Role;
import application.data.users.attributes.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username" , nullable = false , unique = true)
    private String username;

    @Column(name = "mail" , nullable = false , unique = true)
    private String mail;

    @Column(name = "password" , nullable = false)
    private String password;

    @Column(name = "birth_date" , nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "role" , nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    @Column(name = "status" , nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.ENABLE;

    @JsonIgnoreProperties("user")
    @JsonProperty("links")
    @OneToMany(fetch = FetchType.EAGER , mappedBy = "user" , orphanRemoval = true , cascade = CascadeType.ALL)
    private List<Link> links;
}