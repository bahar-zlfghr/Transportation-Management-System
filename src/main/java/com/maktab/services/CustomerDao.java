package com.maktab.services;

import com.maktab.models.Address;
import com.maktab.models.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDao {
    protected static SessionFactory sessionFactory = HibernateUtil.sessionFactory;

    public List<Customer> fetch() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            java.util.List customers = session.createQuery(
                    "from User"
            ).list();
            transaction.commit();
            System.out.println("COMPLETED...");
            return customers;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    public void saveCustomer(Customer customer) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            System.out.println("COMPLETED...");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void saveAddress(Address address) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
            System.out.println("COMPLETED...");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
