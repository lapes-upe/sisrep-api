package br.upe.sistemas.sisrep.controleacesso.api.config;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutenticacaoFiltro extends UsernamePasswordAuthenticationFilter {

  private final AuthenticationManager authenticationManager;
  private final Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

  public AutenticacaoFiltro(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  /**
   * Chamado logo antes do usuário ser validado pelo framework. E redirecionamos para o
   * autentication manager.
   */
  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response) throws AuthenticationException {

    String username = request.getParameter("username");
    String password = request.getParameter("password");

    log.info("Usuario: {}", username);
    log.info("Senha: {}", password);

    UsernamePasswordAuthenticationToken authToken =
        new UsernamePasswordAuthenticationToken(username, password);

    return this.authenticationManager.authenticate(authToken);
  }

  /**
   * Chamado logo após o momento em que o usuário é autenticado com sucesso. Aqui criamos o token
   * jwt do usuário.
   */
  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain, Authentication authResult) throws IOException, ServletException {

    User usuario = (User) authResult.getPrincipal();

    String accessToken = JWT.create().withSubject(usuario.getUsername())
        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
        .withIssuer(request.getRequestURL().toString()).withClaim("roles", usuario.getAuthorities()
            .stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
        .sign(algorithm);

    String refreshToken = JWT.create().withSubject(usuario.getUsername())
        .withExpiresAt(new Date(System.currentTimeMillis() + 20 * 60 * 1000))
        .withIssuer(request.getRequestURL().toString()).sign(algorithm);

    Map<String, String> tokens = new HashMap<String, String>();

    tokens.put("access_token", accessToken);
    tokens.put("refresh_token", refreshToken);

    response.setContentType("application/json");

    new ObjectMapper().writeValue(response.getOutputStream(), tokens);

  }
}
