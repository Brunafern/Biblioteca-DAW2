package util;

import dao.LivroDAO;
import dao.impl.LivroDAOImpl;
import entities.Livro;
import util.DawException;
import dao.PersistenciaDawException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainLivroSave {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            LivroDAO dao = new LivroDAOImpl(emf);
            Livro l = new Livro();

            l.setTitulo("O Senhor dos Anéis: A Sociedade do Anel");
            l.setEditora("HarperCollins");
            l.setAnoPublicacao(1954);
            l.setNumeroPaginas(423);
            l.setEdicao("1ª");
            l.setStatus("Disponível");

            dao.save(l);
            System.out.println("Livro salvo com ID: " + l.getId());
        } catch (PersistenciaDawException e) {
            throw new DawException("Erro ao salvar Livro", e);
        }
    }
}