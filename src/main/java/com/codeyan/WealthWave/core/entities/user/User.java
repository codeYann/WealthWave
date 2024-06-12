package com.codeyan.WealthWave.core.entities.user;

import com.codeyan.WealthWave.core.entities.account.BusinessAccount;
import com.codeyan.WealthWave.core.entities.account.IndividualAccount;
import com.codeyan.WealthWave.core.entities.address.Address;
import com.codeyan.WealthWave.core.exceptions.InvalidUserDataException;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "users")
@Getter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Column(unique = true, nullable = false)
    private UUID publicId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Date birthday;

    @Column(length = 15, unique = true, nullable = false)
    private String phone;

    @Column(length = 100, unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "individual_account_id")
    private IndividualAccount individualAccount;

    @OneToOne
    @JoinColumn(name = "business_account_id")
    private BusinessAccount businessAccount;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public User() {

    }

    public User(String firstName,
                String lastName,
                String gender,
                Date birthday,
                String phone,
                String email,
                String password
    ) {
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setBirthday(birthday);
        setPhone(phone);
        setEmail(email);
        setPassword(password);
        setPublicId(UUID.randomUUID());
    }

    private void checkIfNullOrEmpty(String value, String message) throws InvalidUserDataException {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidUserDataException(message);
        }
    }

    public void setFirstName(String firstName) {
        checkIfNullOrEmpty(firstName, "First name cannot be null or empty");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        checkIfNullOrEmpty(firstName, "Last name cannot be null or empty");
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        checkIfNullOrEmpty(gender, "Gender cannot be null or empty");
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        if (birthday == null || birthday.after(new Date())) {
            throw new InvalidUserDataException("Birthday must be a valid date");
        }
        this.birthday = birthday;
    }

    public void setPhone(String phone) {
        checkIfNullOrEmpty(phone, "Phone cannot be null or empty");

        if (phone.length() != 12) {
            throw new InvalidUserDataException("Phone number must be 12 characters");
        }

        if (!phone.matches("^\\d+$")) {
            throw new InvalidUserDataException("Phone number is not a valid phone number");
        }

        this.phone = phone;
    }

    public void setEmail(String email) {
        checkIfNullOrEmpty(email, "Email cannot be null or empty");
        this.email = email;
    }

    public void setPassword(String password) {
        checkIfNullOrEmpty(password, "Password cannot be null or empty");
        this.password = password;
    }

    public void setAddress(Address address) {
        if (address == null) {
            throw new InvalidUserDataException("Address cannot be null");
        }
        this.address = address;
    }

    public void setIndividualAccount(IndividualAccount account) {
        if (account == null) {
            throw new InvalidUserDataException("Individual account cannot be null");
        }
        this.individualAccount = account;
    }

    public void setBusinessAccount(BusinessAccount account) {
        if (account == null) {
            throw new InvalidUserDataException("Business account cannot be null");
        }
        this.businessAccount = account;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
