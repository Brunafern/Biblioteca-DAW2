package dao.impl;

import dao.impl.AbstractDAOImpl;
import dao.MultaDAO;
import entities.Multa;
import jakarta.persistence.EntityManagerFactory;

public class MultaDAOImpl extends AbstractDAOImpl<Multa, Long> implements MultaDAO {

    public MultaDAOImpl(EntityManagerFactory emf) {
        super(Multa.class, emf);
    }
}