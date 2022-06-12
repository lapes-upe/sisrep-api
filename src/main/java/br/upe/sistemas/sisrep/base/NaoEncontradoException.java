package br.upe.sistemas.sisrep.base;

public class NaoEncontradoException extends ValidacaoException {

  public NaoEncontradoException(String mensagem) {
    super(mensagem);
  }

  public NaoEncontradoException(String mensagem, Throwable causa) {
    super(mensagem, causa);
  }

}
