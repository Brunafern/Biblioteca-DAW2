package dao.impl;

import dao.impl.AbstractDAOImpl;
import dao.GeneroDAO;
import entities.Genero;
import jakarta.persistence.EntityManagerFactory;

public class GeneroDAOImpl extends AbstractDAOImpl<Genero, Long> implements GeneroDAO {

    public GeneroDAOImpl(EntityManagerFactory emf) {
        super(Genero.class, emf);
    }
}