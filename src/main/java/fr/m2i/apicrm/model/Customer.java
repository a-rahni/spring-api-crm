
package fr.m2i.apicrm.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="lastname")
    private String lastname;
    
    @Column(name="firstname")
    private String firstname;
    
    @Column(name="company")
    private String company;
    
    @Column(name="mail")
    private String mail;
    
    @Column(name="phone")
    private String phone;
    
    @Column(name="address")
    private String address;
    
    @Column(name="zipCode")
    private String zipCode;
    
    @Column(name="country")
    private String country;
    
    @Column(name="active" , columnDefinition = "TINYINT(1) DEFAULT 1 NOT NULL")
    private Boolean state; // active ou inactif
    //private List<Order> orders;

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
    
    public void copy(Customer customerData){
        
        if(customerData.getLastname() != null){  // est ce que test chaine vide "" ??
            this .lastname = customerData.getLastname();
        }
        
        if(customerData.getFirstname() != null){  
            this .firstname = customerData.getFirstname();
        }
        
        if(customerData.getCompany() != null){  
            this .company = customerData.getCompany();
        }
        
        if(customerData.getMail() != null){  
            this .mail = customerData.getMail();
        }
        
        if(customerData.getPhone() != null){  
            this .phone = customerData.getPhone();
        }
        
        if(customerData.getAddress() != null){  
            this .address = customerData.getAddress();
        }
        
        if(customerData.getZipCode() != null){  
            this .zipCode = customerData.getZipCode();
        }
        
        if(customerData.getCountry() != null){  
            this .country = customerData.getCountry();
        }
        
        if(customerData.getState() != null){  
            this .state = customerData.getState();
        }  
        
    }
    
    
    
}
