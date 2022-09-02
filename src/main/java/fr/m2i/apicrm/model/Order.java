
package fr.m2i.apicrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    
    @ManyToOne(fetch=FetchType.LAZY /*, optional=false*/)
    @JoinColumn(name ="customerId" , nullable = false)
    private Customer customer;
    
    @Column(name ="type")
    private String type;
    
    @Column(name ="label")
    private String label;
    
    @Column(name ="numberOfDays")
    private Integer numberOfDays;
    
    @Column(name ="unitPrice")
    private Double unitPrice;
    
    @Column(name ="totalExcludeTaxe")
    private Double totalExcludeTaxe;
    
    @Column(name ="totalWithTaxe")
    private Double totalWithTaxe;
    
    @Enumerated(EnumType.STRING)
    @Column(name ="status", columnDefinition = "ENUM('CANCELED','OPTION','CONFIRMED')")
    private Status status;

    public Order() {
    }

    public Order(Long id, Customer customer, String type, String label,
            Integer numberOfDays, Double unitPrice, Double totalExcludeTaxe,
            Double totalWithTaxe, Status status) {
        this.id = id;
        this.customer = customer;
        this.type = type;
        this.label = label;
        this.numberOfDays = numberOfDays;
        this.unitPrice = unitPrice;
        this.totalExcludeTaxe = totalExcludeTaxe;
        this.totalWithTaxe = totalWithTaxe;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalExcludeTaxe() {
        return totalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(Double totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public Double getTotalWithTaxe() {
        return totalWithTaxe;
    }

    public void setTotalWithTaxe(Double totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    
    
    
}
