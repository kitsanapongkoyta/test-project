/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;
import javax.persistence.EntityManager;

/**
 *
 * @author kitsa
 */
public class DvdcatalogTable {
    public static Vector<Dvdcatalog> findAllDvdcatalog(EntityManager em) {
        Vector<Dvdcatalog> empList = null;
        try {
            empList = (Vector<Dvdcatalog>) em.createNamedQuery("Dvdcatalog.findAll").getResultList();
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return empList;
    }
    
    public static Dvdcatalog findDvdcatalogByName(EntityManager em, String Name) {
        Dvdcatalog emp = null;
        try {
            emp = em.find(Dvdcatalog.class, Name);
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return emp;
    }
    
    //public static int updateEmployee(EntityManager em, 
    //        UserTransaction utx, Employee emp) {
    public static int updateDvdcatalog(EntityManager em, Dvdcatalog emp) {
        try {
            em.getTransaction().begin();
            Dvdcatalog target = em.find(Dvdcatalog.class, emp.getName());
            if (target == null) {
                return 0;
            }
            target.setRate(emp.getRate());
            target.setYears(emp.getYears());
            target.setPrice(emp.getPrice());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
            
        }
        return 1;
        
    }
    
    public static int removeDvdcatalog(EntityManager em, String Name) {
        try {
            em.getTransaction().begin();
            Dvdcatalog target = em.find(Dvdcatalog.class, Name);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
            
        }
        return 1;
    }
    
    public static int insertDvdcatalog(EntityManager em, Dvdcatalog emp) {
        try {
            em.getTransaction().begin();
            Dvdcatalog target = em.find(Dvdcatalog.class, emp.getName());
            if (target != null) {
                return 0;
            }
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
            
        }
        return 1;
    } 
}
