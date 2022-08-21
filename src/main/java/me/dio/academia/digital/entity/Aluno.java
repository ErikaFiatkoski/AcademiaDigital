package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data //anotação do Lombok que nos dá os getters e Setters
@NoArgsConstructor //Deixando de maneira implicita, o NoArgsConstructor e o AllArgsConstructor criam dois métodos constructor, um ser argumento e outro com todos os argumentos. Também é anotação do Lombok.
@AllArgsConstructor
@Entity //Anotação que cria a tabela no banco de dados. Faz com que, obrigatoriamente, tenha que colocar um @Id.
@Table(name = "tb_alunos") //Muda o nome da tabela. Se não fosse colocado, a tabela ficaria com o nome "Aluno".
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //ignora eventuais erros que podem ocorrer.
public class Aluno {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  private String nome;

  @Column(unique = true) //Impede que o cpf não pode ser repetido.
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)  //Relacionamento entre tabelas. Um único aluno possui várias avaliações físicas
  @JsonIgnore //ignora eventuais erros que podem ocorrer.
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
