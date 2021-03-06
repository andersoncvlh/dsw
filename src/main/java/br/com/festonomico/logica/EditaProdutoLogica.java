package br.com.festonomico.logica;

import br.com.festonomico.dao.ProdutoDao;
import br.com.festonomico.dao.impl.ProdutoDaoImpl;
import br.com.festonomico.modelo.Produto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditaProdutoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {
		Produto produto = new Produto();
		produto.setId(Integer.parseInt(request.getParameter("id")));
		produto.setNome(request.getParameter("nome"));
		produto.setPreco(Double.parseDouble(request.getParameter("valor")));
		produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		
		ProdutoDao dao = new ProdutoDaoImpl();
		dao.alteraProduto(produto);
		
		return "festonomica?logica=ListaProdutoLogica";
	}


}
