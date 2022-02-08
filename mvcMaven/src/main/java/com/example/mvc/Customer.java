package com.example.mvc;

import javax.validation.constraints.*;

public class Customer {
    @NotEmpty(message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 chars")
    private String postalCode;

    @NotNull(message = "is required")
    @Min(value = 0, message = "Must be greater than equal to 0")
    @Max(value = 10, message = "Must be less then equal to 10")
    private Integer freePass;

    public Integer getFreePass() {
        return freePass;
    }

    public void setFreePass(Integer freePass) {
        this.freePass = freePass;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
