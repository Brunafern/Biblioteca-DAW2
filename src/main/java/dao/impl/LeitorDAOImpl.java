package dao.impl;

import dao.impl.AbstractDAOImpl;
import dao.LeitorDAO;
import entities.Leitor;
import jakarta.persistence.EntityManagerFactory;

public class LeitorDAOImpl extends AbstractDAOImpl<Leitor, Long> implements LeitorDAO {

    public LeitorDAOImpl(EntityManagerFactory emf) {
        super(Leitor.class, emf);
    }
}