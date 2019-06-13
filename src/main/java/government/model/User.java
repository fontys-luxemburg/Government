package government.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @NotBlank
    private String name;

    @NotBlank
    @Column(unique = true)
    @Email
    private String email;

    @NotNull
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.MERGE)
    private List<Ownership> ownerships;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Ownership> getOwnerships() {
        return ownerships;
    }

    public void setOwnerships(List<Ownership> ownerships) {
        this.ownerships = ownerships;
    }

    public void addOwnership(Ownership ownership) {
        ownership.setUser(this);
        this.ownerships.add(ownership);
    }
}
