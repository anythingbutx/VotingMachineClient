/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network.util;

import com.google.api.client.util.Key;


/**
 *
 * @author Hudson
 */
public class CandidateDTO {

    @Key
    private Long id;
    @Key
    private String firstName;
    @Key
    private String middleName;
    @Key
    private String lastName;
    @Key
    private String photoURL;

    
    public CandidateDTO() {}

    
    public String getDisplayName() {
        if (this.middleName == null || this.middleName.isEmpty()) {
            return this.firstName + " " + this.lastName;
        }
        return this.firstName + " " + this.middleName.toUpperCase().charAt(0) + "." + " " + this.lastName;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    @Override
    public String toString() {
        return "id-" + id + "_firstName-" + firstName + "_middleName-" + middleName + "_lastName-" + lastName;
    }
    
    

}
