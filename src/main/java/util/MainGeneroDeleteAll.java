package util;

import dao.GeneroDAO;
import dao.impl.GeneroDAOImpl;
import util.DawException;
import dao.PersistenciaDawException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainGeneroDeleteAll {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            GeneroDAO dao = new GeneroDAOImpl(emf);
            dao.deleteAll();
            System.out.println("Todos os Gêneros foram deletados.");
        } catch (PersistenciaDawException e) {
            throw new DawException("Erro ao deletar todos os Gêneros", e);
        }
    }
}