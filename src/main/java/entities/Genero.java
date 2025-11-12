package entities;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(mappedBy = "generos")
    private Set<Livro> livros;

    public Genero() {}
    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public int hashCode() { return Objects.hash(id); }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Genero other = (Genero) obj;
        return Objects.equals(id, other.id);
    }
    @Override
    public String toString() { return "Genero [id=" + id + ", nome=" + nome + "]"; }
}