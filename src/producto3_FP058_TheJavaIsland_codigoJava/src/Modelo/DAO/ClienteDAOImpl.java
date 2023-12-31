package Modelo.DAO;
import Modelo.Cliente;
import java.util.*;

import Modelo.ClienteEstandar;
import Modelo.ClientePremium;
import Modelo.Hibernate;
import org.hibernate.*;

public class ClienteDAOImpl implements ClienteDAO {

    private SessionFactory sessionFactory;

    public ClienteDAOImpl () {
        this.sessionFactory = Hibernate.getSessionFactory();
    }

    @Override
    public void insert(Modelo.Cliente cliente) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(cliente);
            transaction.commit();
        }
    }

    @Override
    public ArrayList<Cliente> readAll() {
        try (Session session = sessionFactory.openSession()) {
            ArrayList<Cliente> cl = new ArrayList<Cliente>();
           ArrayList<ClienteEstandar> ce = (ArrayList<ClienteEstandar>) session.createQuery("FROM ClienteEstandar", ClienteEstandar.class).list();
           ArrayList<ClientePremium> cp = (ArrayList<ClientePremium>) session.createQuery("FROM ClientePremium", ClientePremium.class).list();
           cl.addAll(ce);
           cl.addAll(cp);
           return cl;
        }
    }

    public Cliente findById(String id) {
        try (Session session = sessionFactory.openSession()) {
            Cliente art = session.get(Cliente.class, id);
            return art;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Cliente cliente) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(cliente);
            transaction.commit();
        }
    }

}