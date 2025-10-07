package util;

import dao.FuncionarioDAO;
import dao.impl.FuncionarioDAOImpl;
import entities.Funcionario;
import util.DawException;
import dao.PersistenciaDawException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainFuncionarioSave {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            FuncionarioDAO dao = new FuncionarioDAOImpl(emf);
            Funcionario f = new Funcionario();

            // A matrícula deve ser única, então usamos uma estratégia para gerar um valor diferente
            f.setMatricula("F" + System.nanoTime());
            f.setCargo("Bibliotecário(a)");

            dao.save(f);
            System.out.println("Funcionario salvo com ID: " + f.getId());
        } catch (PersistenciaDawException e) {
            throw new DawException("Erro ao salvar Funcionario", e);
        }
    }
}