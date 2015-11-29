package br.com.festonomico.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * essa interface vai unicamente ter como metodo o executa
 * que � o respons�vel pelo request e response
 * as outras classes com Logica no nome, v�o implementar dela
 */
public interface Logica {
	String executa(HttpServletRequest request, HttpServletResponse response);
}
