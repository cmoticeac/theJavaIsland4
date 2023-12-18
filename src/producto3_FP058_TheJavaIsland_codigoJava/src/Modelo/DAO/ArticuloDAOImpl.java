package Modelo.DAO;
import Modelo.*;
import java.sql.*;
import java.util.ArrayList;

import Modelo.Hibernate;
import org.hibernate.*;

public class ArticuloDAOImpl implements ArticuloDAO {

    private SessionFactory sessionFactory;

    public ArticuloDAOImpl(){
        this.sessionFactory = Hibernate.getSessionFactory();
    }

    @Override
    public void insert(Articulo articulo) {
     try (Session session = sessionFactory.openSession()){
         Transaction transaction = session.beginTransaction();
         session.save(articulo);
         transaction.commit();
     }
    }

    @Override
    public ArrayList<Articulo> readAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Articulo.class, codigo);
        }
    }

    @Override
    public Articulo findById(int id) {

    }

    @Override
    // Método para actualizar un artículo en la base de datos
    public void update(Articulo articulo) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(articulo);
            transaction.commit();
        }
    }

}