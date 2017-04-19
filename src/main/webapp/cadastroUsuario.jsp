<jsp:include page="template/header.jspf"></jsp:include>
'		<jsp:include page="./template/barra_superior.jspf"></jsp:include>
		
		<section class="container col-md-9 col col-sm-8 col-xs-8">
			<div class= "row" style="padding-top: 10%">
				<div class="col-md-12 col">
					
					<div class="row">
						<div class="col-md-12 col">
							<header>
								<h2>Cadastrar Usuário</h2>
								<span>Nessa sessão, preencha seuss dados pessoais.</span>
							</header>
						</div>
					</div>	
					<div class="form-horizontal col-md-8 col">
						<form  action="#" method="post">
							<div class="form-group">
								<label for="campoNome" class="control-label">Nome:</label> 
								<input id="campoNome" class="form-control" type="text" name="nome"/>
							</div>
							<div class="form-group">
								<label for="campoEmail" class="control-label">Email:</label> 
								<input id="campoEmail" class="form-control" type="email" name="email"/>
							</div>
							<div class="form-group">
								<label for="campoSenha" class="control-label">Senha:</label> 
								<input id="campoSenha" class="form-control" type="text" name="senha" maxlength="6"/>
							</div>
							<div class="form-group">
								<label for="campoConfSenha" class="control-label">Confirmar Senha:</label> 
								<input id="campoConfSenha" class="form-control" type="text"  name="confirmaSenha" maxlength="6"/>
							</div>
							
							<div class="btn-group" role="group">
								<button type="submit" class="btn btn-primary">Cadastrar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
<jsp:include page="template/footer.jspf"></jsp:include>