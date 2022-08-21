package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_avaliacoes")
public class AvaliacaoFisica {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL)  //ManyToOne: Há várias avaliações para cada aluno. Cascade: O que acontecer na AvaliacaoFisica irá repercurtir no Aluno.
  @JoinColumn(name = "aluno_id") //Informa onde vai estar a chave estrangeira.
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column(name = "peso_atual") //Faz com que, na tabela, o nome da coluna seja peso_atual ao inves de apenas ser peso.
  private double peso;

  @Column(name = "altura_atual")
  private double altura;

}
