package com.maktab.services;

import com.maktab.models.Address;
import com.maktab.models.ParcelPost;
import com.maktab.models.PostOrder;
import com.maktab.models.Recipient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PostOrderDao {
    protected static SessionFactory sessionFactory = HibernateUtil.sessionFactory;

    public List<PostOrder> fetch() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            java.util.List orders = session.createQuery(
                    "from PostOrder"
            ).list();
            transaction.commit();
            System.out.println("COMPLETED...");
            return orders;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    public void saveOrder(PostOrder order) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(order);
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

    public void saveRecipient(Recipient recipient) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(recipient);
            transaction.commit();
            System.out.println("COMPLETED...");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void saveParcelPost(ParcelPost parcelPost) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(parcelPost);
            transaction.commit();
            System.out.println("COMPLETED...");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
