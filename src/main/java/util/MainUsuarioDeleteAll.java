package util;

import dao.UsuarioDAO;
import dao.impl.UsuarioDAOImpl;
import util.DawException;
import dao.PersistenciaDawException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainUsuarioDeleteAll {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            UsuarioDAO dao = new UsuarioDAOImpl(emf);
            dao.deleteAll();
            System.out.println("Todos os Usuários foram deletados.");
        } catch (PersistenciaDawException e) {
            throw new DawException("Erro ao deletar todos os Usuários", e);
        }
    }
}