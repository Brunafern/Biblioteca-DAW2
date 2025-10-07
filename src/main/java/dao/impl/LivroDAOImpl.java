package dao.impl;

import dao.impl.AbstractDAOImpl;
import dao.LivroDAO;
import entities.Livro;
import jakarta.persistence.EntityManagerFactory;

public class LivroDAOImpl extends AbstractDAOImpl<Livro, Long> implements LivroDAO {

    public LivroDAOImpl(EntityManagerFactory emf) {
        super(Livro.class, emf);
    }
}