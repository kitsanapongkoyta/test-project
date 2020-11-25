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
@Table(name = "DVDCATALOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dvdcatalog.findAll", query = "SELECT d FROM Dvdcatalog d"),
    @NamedQuery(name = "Dvdcatalog.findByName", query = "SELECT d FROM Dvdcatalog d WHERE d.name = :name"),
    @NamedQuery(name = "Dvdcatalog.findByRate", query = "SELECT d FROM Dvdcatalog d WHERE d.rate = :rate"),
    @NamedQuery(name = "Dvdcatalog.findByYears", query = "SELECT d FROM Dvdcatalog d WHERE d.years = :years"),
    @NamedQuery(name = "Dvdcatalog.findByPrice", query = "SELECT d FROM Dvdcatalog d WHERE d.price = :price")})
public class Dvdcatalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 10)
    @Column(name = "RATE")
    private String rate;
    @Column(name = "YEARS")
    private Integer years;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;

    public Dvdcatalog() {
    }

    public Dvdcatalog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
        if (!(object instanceof Dvdcatalog)) {
            return false;
        }
        Dvdcatalog other = (Dvdcatalog) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dvdcatalog[ name=" + name + " ]";
    }
    
}
