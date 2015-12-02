package br.com.festonomico.logica;

import br.com.festonomico.dao.ProdutoDao;
import br.com.festonomico.dao.impl.ProdutoDaoImpl;
import br.com.festonomico.modelo.Produto;
import br.com.festonomico.modelo.TipoFesta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AdicionaProdutoLogica implements Logica{

	TipoFesta[] tipoFestaArray = TipoFesta.values();
	List<String> listaTipoFesta = new ArrayList<String>();
	
	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {
		
		request.setAttribute("tipoFesta", listaTipoFesta);
		
		//recebe os parametros da pagina jsp
		String nome = request.getParameter("nome");
		String quantidade = request.getParameter("quantidade");
		String preco = request.getParameter("valor");
		//instancia Produto e seta os valores com os parametros recebidos da pagina jsp
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setQuantidade(Integer.parseInt(quantidade));
		produto.setPreco(Double.parseDouble(preco));
		//instancia ProdutoDAO e salva no BD os dados
		ProdutoDao dao = new ProdutoDaoImpl();
		dao.insereProduto(produto);

		return "produtoAdicionado.jsp";
	}
	

}
