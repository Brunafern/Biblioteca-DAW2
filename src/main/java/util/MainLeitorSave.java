package util;

import dao.LeitorDAO;
import dao.impl.LeitorDAOImpl;
import entities.Leitor;
import util.DawException;
import dao.PersistenciaDawException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public class MainLeitorSave {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            LeitorDAO dao = new LeitorDAOImpl(emf);
            Leitor l = new Leitor();
            l.setCpf("" + System.nanoTime());
            l.setDataNascimento(LocalDate.of(1990, 5, 15));
            dao.save(l);
            System.out.println("Leitor salvo com ID: " + l.getId());
        } catch (PersistenciaDawException e) {
            throw new DawException("Erro ao salvar Leitor", e);
        }
    }
}