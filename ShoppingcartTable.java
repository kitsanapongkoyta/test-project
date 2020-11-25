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
public class ShoppingcartTable {
    public static Vector<Shoppingcart> findAllShoppingcart(EntityManager em) {
        Vector<Shoppingcart> empList = null;
        try {
            empList = (Vector<Shoppingcart>) em.createNamedQuery("Shoppingcart.findAll").getResultList();
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return empList;
    }
    
    public static Shoppingcart findShoppingcartByName(EntityManager em, String Name) {
        Shoppingcart emp = null;
        try {
            emp = em.find(Shoppingcart.class, Name);
            //em.close();
            
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
        return emp;
    }
    
    //public static int updateEmployee(EntityManager em, 
    //        UserTransaction utx, Employee emp) {
    public static int updateShoppingcart(EntityManager em, Shoppingcart emp) {
        try {
            em.getTransaction().begin();
            Shoppingcart target = em.find(Shoppingcart.class, emp.getSName());
            if (target == null) {
                return 0;
            }
            target.setSRate(emp.getSRate());
            target.setSYears(emp.getSYears());
            target.setSPrice(emp.getSPrice());
            target.setSQuantity(emp.getSQuantity());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
            
        }
        return 1;
        
    }
    
    public static int removeShoppingcart(EntityManager em, String Name) {
        try {
            em.getTransaction().begin();
            Shoppingcart target = em.find(Shoppingcart.class, Name);
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
    
    public static int insertShoppingcart(EntityManager em, Shoppingcart emp) {
        try {
            em.getTransaction().begin();
            Shoppingcart target = em.find(Shoppingcart.class, emp.getSName());
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
