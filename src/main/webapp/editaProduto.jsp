<jsp:include page="template/header.jspf"></jsp:include>
<jsp:include page="./template/barra_superior.jspf"></jsp:include>

<section class="container col-md-9 col col-sm-8 col-xs-8">
    <div class="row" style="padding-top: 10%">
        <div class="col-md-12 col">

            <div class="form-horizontal col-md-8 col">
                <form id="formAdicionaProduto" action="adicionaProduto" method="post">

                    <div id="cabecalhoForm" class="form-group">
                        <div class="page-header">
                            <h3><span class="label label-default">Edite os dados do Produto</span></h3>
                        </div>
                    </div>

                    <c:forEach var="produto" items="${produto }">
                    <input type="hidden" name="id" value="${produto.id }"/>

                    <div class="form-group">
                        <label for="campoNome" class="col-sm-2 control-label">Nome</label>

                        <div class="col-sm-10">
                            <input id="campoNome" placeholder="Nome" value="${produto.nome}" class="form-control"
                                   type="text" name="nome"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="campoPreco" class="col-sm-2 control-label">Preço</label>

                        <div class="col-sm-10">
                            <input id="campoPreco" placeholder="Preço" value="${produto.preco}" class="form-control"
                                   type="text" name="preco"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="campoQtd" class="col-sm-2 control-label">Quantidade</label>

                        <div class="col-sm-10">
                            <input id="campoQtd" placeholder="Quantidade de produtos" value="${produto.quantidade}"
                                   class="form-control" type="text" name="quantidade"/>
                        </div>
                    </div>

                    <div id="divButton" class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                        </div>
                    </div>

                    <div class="btn-group-justified" role="group">

                    </div>

                </form>
                </c:forEach>
            </div>
        </div>
    </div>
    </div>
</section>
<jsp:include page="template/footer.jspf"></jsp:include>