package util;

import dao.UsuarioDAO;
import dao.impl.UsuarioDAOImpl;
import entities.Usuario;
import util.DawException;
import dao.PersistenciaDawException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainUsuarioSave {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UsuarioDAO dao = new UsuarioDAOImpl(emf);
            Usuario u = new Usuario();
            u.setNome("Usuario Teste");
            u.setEmail("user" + System.nanoTime() + "@email.com");
            dao.save(u);
            System.out.println("Usuario salvo com ID: " + u.getId());
        } catch (PersistenciaDawException e) {
            throw new DawException("Erro ao salvar Usuario", e);
        }
    }
}