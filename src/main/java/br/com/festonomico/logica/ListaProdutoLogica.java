package br.com.festonomico.logica;

import br.com.festonomico.dao.ProdutoDao;
import br.com.festonomico.dao.impl.ProdutoDaoImpl;
import br.com.festonomico.modelo.Produto;
import br.com.festonomico.modelo.TipoFesta;
import br.com.festonomico.modeloTO.ProdutoTO;
import br.com.festonomico.util.ProdutoUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ListaProdutoLogica implements Logica{

	String idSessao = null;
	
	ProdutoDao dao;
	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession s =  request.getSession();
		idSessao = s.getId();
		dao = new ProdutoDaoImpl();
		dao.callProcedure(idSessao);
		String tipoFesta = request.getParameter("campoFesta");
		String qtdParamRequest = request.getParameter("quantidade");
		
		int quantidadePessoas = 0;
		try {
			quantidadePessoas = Integer.parseInt(qtdParamRequest);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		List<Produto> produtos = calculoFesta(tipoFesta, quantidadePessoas);
		String total = total(produtos);
		List<ProdutoTO> listaExibir = ProdutoUtil.toProduto(produtos);
		request.setAttribute("produtos", listaExibir);
		request.setAttribute("total", total);
		return "listaProdutos.jsp";
	}
	
	private List<Produto> calculoFesta(String tipoFesta, int quantidadePessoas) {
		List<Produto> listaRetorno;
		listaRetorno = choisseParty(tipoFesta, quantidadePessoas);
		return listaRetorno;
	}
	
	private List<Produto> choisseParty(String tipoFesta, int quantidadePessoas) {
		List<Produto> retorno = new ArrayList<>();
		if(tipoFesta!=null && !tipoFesta.equals("")
				&& tipoFesta.equalsIgnoreCase(TipoFesta.ADULTA.getDescricao())) {
			retorno = calcularAdulta(tipoFesta, quantidadePessoas);
		}else if(tipoFesta!=null && !tipoFesta.equals("")
				&& tipoFesta.equalsIgnoreCase(TipoFesta.INFANTIL.getDescricao())) {
			retorno = calcularInfantil(tipoFesta, quantidadePessoas);
		}
		return retorno;
	}
	
	private List<Produto> calcularAdulta(String tipoFesta, int quantidadePessoas) {
		List<Produto> produtosPadrao = dao.getLista(idSessao);
		List<Produto> produtosFiltrados = new ArrayList<>();
		for (Produto produto : produtosPadrao) {
			if(produto.getTipoFesta().equals(TipoFesta.ADULTA)
					|| produto.getTipoFesta().equals(TipoFesta.TODOS)) {
				
				produtosFiltrados.add(produto);
			}
		}


		List<Produto> retorno = new ArrayList<>();
		adicionaProdutosFiltrados(quantidadePessoas, produtosFiltrados, retorno);

		return retorno;
	}

	private void adicionaProdutosFiltrados(int quantidadePessoas, List<Produto> produtosFiltrados, List<Produto> retorno) {
		for (Produto produto : produtosFiltrados) {
			//	calcular qtd de produtos por pessoa
			double produtosPorPessoas = produto.getQuantidade() * quantidadePessoas;
			produto.setQuantidade(produtosPorPessoas);
			double precoPorQtd = produto.getPreco() * produto.getQuantidade();
			produto.setPreco(precoPorQtd);
			retorno.add(produto);
		}
	}

	private List<Produto> calcularInfantil(String tipoFesta, int quantidadePessoas) {
		List<Produto> produtosPadrao = dao.getLista(idSessao);
		List<Produto> produtosFiltrados = new ArrayList<>();
		for (Produto produto : produtosPadrao) {
			if(produto.getTipoFesta().equals(TipoFesta.INFANTIL)
					|| produto.getTipoFesta().equals(TipoFesta.TODOS)) {
				produtosFiltrados.add(produto);
			}
		}


		List<Produto> retorno = new ArrayList<>();
		adicionaProdutosFiltrados(quantidadePessoas, produtosFiltrados, retorno);

		return retorno;
	}
	
	public String total(List<Produto> produtos) {
		double total = 0;
		for (Produto produto : produtos) {
			total = total + produto.getPreco();
		}
		return ProdutoUtil.restringirCasaDecimal(total);
	}
}
