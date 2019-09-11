
package com.company.trainersApp.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author elTok
 */
@Entity
@Table(name = "trainers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainers.findAll", query = "SELECT t FROM Trainers t")
    , @NamedQuery(name = "Trainers.findById", query = "SELECT t FROM Trainers t WHERE t.id = :id")
    , @NamedQuery(name = "Trainers.findByName", query = "SELECT t FROM Trainers t WHERE t.name = :name")
    , @NamedQuery(name = "Trainers.findByLastName", query = "SELECT t FROM Trainers t WHERE t.lastname = :lastname")
    , @NamedQuery(name = "Trainers.findBySubject", query = "SELECT t FROM Trainers t WHERE t.subject = :subject")})
public class Trainers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
   
    @Column(name = "name")
    private String name;
   @Size(max = 45)
  
    @Column(name = "lastname")
    private String lastname;
   @Size(max = 45)
   
    @Column(name = "subject")
    private String subject;

    public Trainers() {
    }

    public Trainers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainers)) {
            return false;
        }
        Trainers other = (Trainers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.trainersApp.model.Trainers[ id=" + id + " ]";
    }
    
}
