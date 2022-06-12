package br.upe.sistemas.sisrep.base;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ValidacaoException extends RuntimeException {

  private String mensagem;
  private List<DetalheErro> detalhes;

  public ValidacaoException(String mensagem) {
    super(mensagem);
  }

  public ValidacaoException(String mensagem, Throwable causa) {
    super(mensagem, causa);
    this.mensagem = mensagem;
  }

  @Builder
  public ValidacaoException(String mensagem, List<DetalheErro> detalhes, Throwable causa) {
    super(mensagem, causa);
    this.mensagem = mensagem;
    this.detalhes = detalhes;
  }
}
