package util;

import dao.LeitorDAO;
import dao.impl.LeitorDAOImpl;
import util.DawException;
import dao.PersistenciaDawException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainLeitorDeleteAll {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            LeitorDAO dao = new LeitorDAOImpl(emf);
            dao.deleteAll();
            System.out.println("Todos os Leitores foram deletados.");
        } catch (PersistenciaDawException e) {
            throw new DawException("Erro ao deletar todos os Leitores", e);
        }
    }
}