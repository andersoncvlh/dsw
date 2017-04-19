<jsp:include page="template/header.jspf"></jsp:include>
<jsp:include page="./template/barra_superior.jspf"></jsp:include>

<table>
    <tr>
        <th>Nome do Produto</th>
        <th>Valor</th>
        <th>Quantidade</th>
    </tr>
    <c:forEach var="produtos" items="${produtos}">
    <tr>
        <td>${produtos.nome}</td>
        <td>${produtos.preco}</td>
        <td>${produtos.quantidade}</td>
        <td><a href="festonomica?logica=SelecionaProdutoLogica&id=${produtos.id }">Alterar</a></td>
        <td><a href="festonomica?logica=RemoveProdutoLogica&id=${produtos.id }">Remover</a></td>
    </tr>
    </c:forEach>
    <tr>
        <th>Total</th>
        <th>${total }</th>
        <a href="#" onclick="window.print()">
            <span class="glyphicon glyphicon-print"> Imprimir</span>
        </a>
    </tr>
    <a href="adicionaProduto.jsp">
        <button>Adicionar Novo Produto</button>
    </a>
<jsp:include page="template/footer.jspf"></jsp:include>