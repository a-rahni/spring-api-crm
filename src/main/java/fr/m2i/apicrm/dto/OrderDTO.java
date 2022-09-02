
package fr.m2i.apicrm.dto;

public class OrderDTO {

    private Long id;
    private CustomerDTO customer;
    private String type;
    private String label;
    private Integer numberOfDays;
    private Float unitPrice;
    private Float totalExcludeTaxe;
    private Float totalWithTaxe;
    private String state;

    public OrderDTO() {

    }

    public OrderDTO(Long id, CustomerDTO customer, String type, String label,
            Integer numberOfDays, Float unitPrice, Float totalExcludeTaxe,
            Float totalWithTaxe, String state) {
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

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customer=" + customer + ", type=" + type + ", label=" + label + ", numberOfDays=" + numberOfDays + ", unitPrice=" + unitPrice + ", totalExcludeTaxe=" + totalExcludeTaxe + ", totalWithTaxe=" + totalWithTaxe + ", state=" + state + '}';
    }
}
    

