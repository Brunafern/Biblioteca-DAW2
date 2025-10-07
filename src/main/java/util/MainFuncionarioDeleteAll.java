package util;

import dao.FuncionarioDAO;
import dao.impl.FuncionarioDAOImpl;
import util.DawException;
import dao.PersistenciaDawException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainFuncionarioDeleteAll {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            FuncionarioDAO dao = new FuncionarioDAOImpl(emf);
            dao.deleteAll();
            System.out.println("Todos os Funcionários foram deletados.");
        } catch (PersistenciaDawException e) {
            throw new DawException("Erro ao deletar todos os Funcionários", e);
        }
    }
}