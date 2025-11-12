package entities;

import jakarta.persistence.*;

import java.util.Objects;


@Entity

public class ItemEmprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Corresponds to id_item_emprestimo in the diagram


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emprestimo_id", nullable = false)
    private Emprestimo emprestimo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    private String status;


    public ItemEmprestimo(Long id, Emprestimo emprestimo, Livro livro, String status) {
        this.id = id;
        this.emprestimo = emprestimo;
        this.livro = livro;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEmprestimo that = (ItemEmprestimo) o;
        return Objects.equals(id, that.id) && Objects.equals(emprestimo, that.emprestimo) && Objects.equals(livro, that.livro) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emprestimo, livro, status);
    }

    @Override
    public String toString() {
        return "ItemEmprestimo{" +
                "id=" + id +
                ", emprestimo=" + emprestimo +
                ", livro=" + livro +
                ", status='" + status + '\'' +
                '}';
    }
}

