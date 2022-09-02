
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name="type")
    private String type;
    
    @Column(name="label")
    private String label;
    
    @Column(name="nb_days")
    private Integer numberOfDays;
    
    @Column(name="unit_price")
    private Float unitPrice;
    
    @Column(name="total_exclude_taxe")
    private Float totalExcludeTaxe;

    @Column(name="total_with_taxe")
    private Float totalWithTaxe;

    @Enumerated(EnumType.STRING)
    @Column(name="state", columnDefinition = "ENUM('CANCELED', 'OPTION', 'CONFIRMED') NOT NULL")
    private OrderState state;

    public Order() {

    }

    public Order(Long id, Customer customer, String type, String label,
            Integer numberOfDays, Float unitPrice, Float totalExcludeTaxe,
            Float totalWithTaxe, OrderState state) {
        this.id = id;
        this.customer = customer;
        this.type = type;
        this.label = label;
        this.numberOfDays = numberOfDays;
        this.unitPrice = unitPrice;
        this.totalExcludeTaxe = totalExcludeTaxe;
        this.totalWithTaxe = totalWithTaxe;
        this.state = state;
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

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getTotalExcludeTaxe() {
        return totalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(Float totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public Float getTotalWithTaxe() {
        return totalWithTaxe;
    }

    public void setTotalWithTaxe(Float totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customer=" + customer + ", type=" + type + ", label=" + label + ", numberOfDays=" + numberOfDays + ", unitPrice=" + unitPrice + ", totalExcludeTaxe=" + totalExcludeTaxe + ", totalWithTaxe=" + totalWithTaxe + ", state=" + state + '}';
    }
}




/*
@Entity
@Table(name="orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    
    @ManyToOne(fetch=FetchType.LAZY , optional=false)
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
    private OrderState status;
    
}
*/
