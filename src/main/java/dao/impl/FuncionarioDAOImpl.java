package dao.impl;

import dao.impl.AbstractDAOImpl;
import dao.FuncionarioDAO;
import entities.Funcionario;
import jakarta.persistence.EntityManagerFactory;

public class FuncionarioDAOImpl extends AbstractDAOImpl<Funcionario, Long> implements FuncionarioDAO {

    public FuncionarioDAOImpl(EntityManagerFactory emf) {
        super(Funcionario.class, emf);
    }
}