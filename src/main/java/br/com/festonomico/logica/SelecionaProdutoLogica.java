package br.com.festonomico.logica;

import br.com.festonomico.dao.ProdutoDao;
import br.com.festonomico.dao.impl.ProdutoDaoImpl;
import br.com.festonomico.modelo.Produto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SelecionaProdutoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {
		
		ProdutoDao dao = new ProdutoDaoImpl();
		
		int id = Integer.parseInt(request.getParameter("id"));
		List<Produto> produto = dao.getProduto(id);
		
		request.setAttribute("produto", produto);

		return "editaProduto.jsp";
	}

}
