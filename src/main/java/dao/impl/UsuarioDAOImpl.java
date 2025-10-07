package dao.impl;

import dao.impl.AbstractDAOImpl;
import dao.UsuarioDAO;
import entities.Usuario;
import jakarta.persistence.EntityManagerFactory;

public class UsuarioDAOImpl extends AbstractDAOImpl<Usuario, Long> implements UsuarioDAO {

    public UsuarioDAOImpl(EntityManagerFactory emf) {
        super(Usuario.class, emf);
    }
}