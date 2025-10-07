package util;

import dao.EmprestimoDAO;
import dao.impl.EmprestimoDAOImpl;
import entities.Emprestimo;
import util.DawException;
import dao.PersistenciaDawException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDateTime;

public class MainEmprestimoSave {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            EmprestimoDAO dao = new EmprestimoDAOImpl(emf);
            Emprestimo e = new Emprestimo();

            e.setDataRetirada(LocalDateTime.now());
            e.setDataDevolucao(null);
            e.setStatus("Ativo");

            dao.save(e);
            System.out.println("Empréstimo salvo com ID: " + e.getId());
        } catch (PersistenciaDawException e) {
            throw new DawException("Erro ao salvar Empréstimo", e);
        }
    }
}