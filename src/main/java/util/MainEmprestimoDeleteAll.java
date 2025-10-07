package util;

import dao.EmprestimoDAO;
import dao.impl.EmprestimoDAOImpl;
import util.DawException;
import dao.PersistenciaDawException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainEmprestimoDeleteAll {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            EmprestimoDAO dao = new EmprestimoDAOImpl(emf);
            dao.deleteAll();
            System.out.println("Todos os Empréstimos foram deletados.");
        } catch (PersistenciaDawException e) {
            throw new DawException("Erro ao deletar todos os Empréstimos", e);
        }
    }
}