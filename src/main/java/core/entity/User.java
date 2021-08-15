package core.entity;

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
    private Language language;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GregorianCalendar getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(GregorianCalendar lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
