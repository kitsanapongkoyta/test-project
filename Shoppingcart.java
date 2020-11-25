/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kitsa
 */
@Entity
@Table(name = "SHOPPINGCART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingcart.findAll", query = "SELECT s FROM Shoppingcart s"),
    @NamedQuery(name = "Shoppingcart.findByName", query = "SELECT s FROM Shoppingcart s WHERE s.name = :name"),
    @NamedQuery(name = "Shoppingcart.findByRate", query = "SELECT s FROM Shoppingcart s WHERE s.rate = :rate"),
    @NamedQuery(name = "Shoppingcart.findByYears", query = "SELECT s FROM Shoppingcart s WHERE s.years = :years"),
    @NamedQuery(name = "Shoppingcart.findByPrice", query = "SELECT s FROM Shoppingcart s WHERE s.price = :price"),
    @NamedQuery(name = "Shoppingcart.findByQuantity", query = "SELECT s FROM Shoppingcart s WHERE s.quantity = :quantity")})
public class Shoppingcart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "NAME")
    private String name;
    @Size(max = 20)
    @Column(name = "RATE")
    private String rate;
    @Column(name = "YEARS")
    private Integer years;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "QUANTITY")
    private Integer quantity;

    public Shoppingcart() {
    }

    public Shoppingcart(String name) {
        this.name = name;
    }

    public String getSName() {
        return name;
    }

    public void setSName(String name) {
        this.name = name;
    }

    public String getSRate() {
        return rate;
    }

    public void setSRate(String rate) {
        this.rate = rate;
    }

    public Integer getSYears() {
        return years;
    }

    public void setSYears(Integer years) {
        this.years = years;
    }

    public Double getSPrice() {
        return price;
    }

    public void setSPrice(Double price) {
        this.price = price;
    }

    public Integer getSQuantity() {
        return quantity;
    }

    public void setSQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shoppingcart)) {
            return false;
        }
        Shoppingcart other = (Shoppingcart) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Shoppingcart[ name=" + name + " ]";
    }
    
}
