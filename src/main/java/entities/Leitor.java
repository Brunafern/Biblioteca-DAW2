package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Leitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cpf;
    private LocalDate dataNascimento;


    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;


    @OneToMany(mappedBy = "leitor")
    private List<Emprestimo> emprestimos;

    public Leitor() {}
    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    @Override
    public int hashCode() { return Objects.hash(id); }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Leitor other = (Leitor) obj;
        return Objects.equals(id, other.id);
    }
    @Override
    public String toString() { return "Leitor [id=" + id + ", cpf=" + cpf + "]"; }
}