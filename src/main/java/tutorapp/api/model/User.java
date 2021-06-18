package tutorapp.api.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "f_name")
    private String firstName;

    @Column(name = "l_name")
    private String lastName;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Enumerated
    @Column(name = "role")
    private Role role;

    @Transient
    private String token;
}
