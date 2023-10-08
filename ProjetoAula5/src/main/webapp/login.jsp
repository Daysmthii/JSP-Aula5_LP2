<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Formulário de Login</title>
    <style> 
    body{text-align:center;
     font-family: Times New Roman, Times, serif; 
     background-color: #836FFF;
     padding-top: 7%;} 
    h1{font-family:'Times New Roman, Times, serif';
    text-decoration: underline;}
    </style>
</head>
<body>
    <h1>Formulário de Login</h1>
    <form action="/ProjetoAula5/LoginServlet" method="post">
        <label for="login">Nome de Login:</label>
        <input type="text" id="login" name="login" required><br><br>

        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required><br><br>

        <input type="submit" value="Entrar">
    </form>
</body>
</html>