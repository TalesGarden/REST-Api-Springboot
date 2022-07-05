package one.digitalInnovation.gof.model;

import javax.persistence.*;

@Entity
public class AlunoEscola {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @ManyToOne
   private Cliente cliente;


   @ManyToOne
   private Escola escola;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Cliente getCliente() {
      return cliente;
   }

   public void setCliente(Cliente cliente) {
      this.cliente = cliente;
   }

   public Escola getEscola() {
      return escola;
   }

   public void setEscola(Escola escola) {
      this.escola = escola;
   }
}
