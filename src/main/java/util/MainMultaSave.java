package util;

import dao.MultaDAO;
import dao.impl.MultaDAOImpl;
import entities.Multa;
import util.DawException;
import dao.PersistenciaDawException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.math.BigDecimal;

public class MainMultaSave {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            MultaDAO dao = new MultaDAOImpl(emf);
            Multa m = new Multa();

            // Usar BigDecimal para valores monetários é a melhor prática
            m.setValor(new BigDecimal("7.50"));
            m.setDescricao("Atraso na devolução do livro ID 1");
            m.setStatus("Pendente");

            dao.save(m);
            System.out.println("Multa salva com ID: " + m.getId());
        } catch (PersistenciaDawException e) {
            throw new DawException("Erro ao salvar Multa", e);
        }
    }
}