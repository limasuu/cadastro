<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8"/>
		<title>Cadastro</title>
	
	</head>
	<body>
		
		<h1>Cadastro</h1>
		
		<form action="ServletTela1Cadastro">
			<label for="campo-nome" class="descricao-campo">Nome</label>
			<input type="text" name="campo-nome" class="campo"/>
		
			<br/><br/>
			
			<label for="campo-genero" class="descricao-campo">Masculino</label>
			<input type="radio" name="campo-genero" value="true"/>
			
			<label for=campo-genero class="descricao-campo">Feminino</label>
			<input type="radio" name="campo-genero" value="false"/>
			
						
			<label for="campo-nascimento-dia" class="descricao-campo">Data de nascimento</label>
			<input type="text" name="campo-nascimento-dia" class="campo"/>
			<input type="text" name="campo-nascimento-mes" class="campo"/>
			<input type="text" name="campo-nascimento-ano" class="campo"/>
			
			<br/><br/>
			
			<label for="campo-endereco" class="descricao-campo">Endereço</label>
			<textarea rows="3" cols="40" name="campo-endereco" class="campo"></textarea>			
			
			<br/><br/>
		
			<label for="campo-telefone" class="descricao-campo">Telefone</label>
			<input type="text" name="campo-telefone" class="campo"/>
			
						
			<label for="campo-email" class="descricao-campo">E-mail</label>
			<input type="text" name="campo-email" class="campo"/>
			
			<br/><br/>

			<label for="campo-matricula" class="descricao-campo">Matrícula</label>
			<input type="text" name="campo-matricula" class="campo"/>
			
			
			<select name="campo-tipo-pessoa">
				<option value="aluno" selected="selected">Aluno</option>
				<option value="professor">Professor</option>
				<option value="funcionario">Funcionário</option>
			</select>
			
			<br/><br/>
			
			<button type="submit">Próxima página</button>
		</form>
	</body>
</html>