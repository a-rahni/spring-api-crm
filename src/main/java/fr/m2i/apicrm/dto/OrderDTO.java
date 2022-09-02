
package fr.m2i.apicrm.dto;

import fr.m2i.apicrm.model.Customer;
import fr.m2i.apicrm.model.Status;


public class OrderDTO {
    
    private Long id;
    private CustomerDTO customerDto;
    private String type;
    private String label;
    private Integer numberOfDays;
    private Double unitPrice;
    private Double totalExcludeTaxe;
    private Double totalWithTaxe;
    private String status;

    public OrderDTO() {
    }

    public OrderDTO(Long id, CustomerDTO customerDto, String type, String label,
            Integer numberOfDays, Double unitPrice, Double totalExcludeTaxe,
            Double totalWithTaxe, String status) {
        this.id = id;
        this.customerDto = customerDto;
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

    public CustomerDTO getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDTO customer) {
        this.customerDto = customer;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
    

