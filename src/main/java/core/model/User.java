package core.model;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String fullname;
    private String password;
    private GregorianCalendar lastLogin;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Company company;
}
