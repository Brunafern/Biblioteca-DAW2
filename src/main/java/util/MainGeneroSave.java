package util;

import dao.GeneroDAO;
import dao.impl.GeneroDAOImpl;
import entities.Genero;
import util.DawException;
import dao.PersistenciaDawException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainGeneroSave {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            GeneroDAO dao = new GeneroDAOImpl(emf);
            Genero g = new Genero();

            // Adicionando um timestamp para facilitar testes repetidos com nomes diferentes
            g.setNome("Aventura " + System.currentTimeMillis());

            dao.save(g);
            System.out.println("Gênero salvo com ID: " + g.getId());
        } catch (PersistenciaDawException e) {
            throw new DawException("Erro ao salvar Gênero", e);
        }
    }
}