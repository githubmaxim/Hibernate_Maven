/*package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

    public static void insertObject(Employee emp) {

        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            session.save(emp);
            Transaction trans = session.getTransaction();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Employee emp = new Employee();

        emp.setFirstName("ptr");
        emp.setLastName("Nayan");

        insertObject(emp);
    }
}*/
package org.example;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            Employee employee1 = new Employee();
            employee1.setFirstName("Max");
            employee1.setLastName("Ok");

            session.save(employee1);

            session.getTransaction().commit();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        List<Employee> list = null;

        try(Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            Query query = session.createQuery("FROM Employee");
            list = (List<Employee>) query.list();

            session.getTransaction().commit();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        if (list != null && !list.isEmpty()) {
            for (Employee employee: list) {
                System.out.println(employee);
            }
        }

        HibernateUtil.shutDown();
    }
}
