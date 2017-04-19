
			<jsp:include page="./template/barra_superior.jspf"></jsp:include>
			
			<div class="container col-md-12 col col-sm-12 col-xs-12">
				<div class= "row" style="padding-top: 10%">
					<div class="col-md-12 col">
						<div class="form-horizontal col-md-8 col">
					    	<form action="festonomica">
					    	
					    		<div id="cabecalhoForm" class="form-group">
									<div class="page-header">
										<h3><span class="label label-default">Simule aqui sua festa!</span></h3>
									</div>	
								</div>
					    	
					    		<div class="form-group">
								<label for="campoFesta" class="col-sm-2 control-label">Tipo de Festa</label>
									<div class="col-sm-10">
										<select id="campoFesta" name="campoFesta" >
											<option value="Selecione" selected="selected" disabled="disabled" >Selecione</option>
											<option value="INFANTIL">Infantil</option>
											<option value="ADULTA">Adulta</option>
										</select>
									</div>
								</div>
								
								<div class="form-group">
								<label for="campoQtd" class="col-sm-2 control-label">Quantidade de pessoas</label>
									<div class="col-sm-10">
										<input id="quantidade" placeholder="quantidade de pessoas" class="form-control" type="number" name="quantidade"/>
									</div>
								</div>
					    		<input type="hidden" name="logica" value="ListaProdutoLogica">
					    		<div id="divButton" class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button class="btn-default" type="submit">Simular Festa</button>
									</div>
								</div>
								
					    		
					    	</form>
					    </div>
					</div>
				</div>
			</div>
