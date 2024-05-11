package everestate.bidding.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Document(collection = "users")
public class User {
    //in project, wherever there is time related thing, datatype will be Instant
    @Id
    private String id;

    @NotBlank(message = "Name is required")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email is required")
    private String email;

    private String password; // No validation or encryption

    // Getters and setters
}
