package util;

import dao.LivroDAO;
import dao.impl.LivroDAOImpl;
import util.DawException;
import dao.PersistenciaDawException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainLivroDeleteAll {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            LivroDAO dao = new LivroDAOImpl(emf);
            dao.deleteAll();
            System.out.println("Todos os Livros foram deletados.");
        } catch (PersistenciaDawException e) {
            throw new DawException("Erro ao deletar todos os Livros", e);
        }
    }
}