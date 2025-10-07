package util;

import dao.MultaDAO;
import dao.impl.MultaDAOImpl;
import util.DawException;
import dao.PersistenciaDawException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainMultaDeleteAll {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            MultaDAO dao = new MultaDAOImpl(emf);
            dao.deleteAll();
            System.out.println("Todas as Multas foram deletadas.");
        } catch (PersistenciaDawException e) {
            throw new DawException("Erro ao deletar todas as Multas", e);
        }
    }
}