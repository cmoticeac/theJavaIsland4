package Modelo.DAO;
import Modelo.Cliente;
import Modelo.ClienteEstandar;
import Modelo.ClientePremium;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
    public ArrayList<Cliente>readAll(){
        try (Session session = sessionFactory.openSession()) {
            return (ArrayList<Cliente>) session.createQuery("FROM EntidadTabla", Cliente.class).list();
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