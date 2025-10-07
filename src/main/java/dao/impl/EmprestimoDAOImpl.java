package dao.impl;

import dao.impl.AbstractDAOImpl;
import dao.EmprestimoDAO;
import entities.Emprestimo;
import jakarta.persistence.EntityManagerFactory;

public class EmprestimoDAOImpl extends AbstractDAOImpl<Emprestimo, Long> implements EmprestimoDAO {

    public EmprestimoDAOImpl(EntityManagerFactory emf) {
        super(Emprestimo.class, emf);
    }
}