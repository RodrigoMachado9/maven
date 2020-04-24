<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Cadastrar</title>
</head>
<script>
    function formatar(mascara, documento){
        var i = documento.values.length;
        var saida = mascara.substring(0, 1);
        var texto = mascara.substring(i);

        if (texto.substring(0,1) != saida){
            documento.value += texto.substring(0,1);
        }
    }
</script>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
<form action="salvacadastro.jsp" method="post"> </form>
<label>Nome:</label>
<input type="text" name="nome">
<label>Email:</label>
<input type="text" name="email">
<label>Senha:</label>
<input type="password" name="senha">

</body>

</html>