<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Genero</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
        <h1>Genero</h1>
            <a href="/genero/insert" class="btn btn-primary">Novo Genero</a>
            <table class="table">
                <tr>
                    <th>Id</th>
                    <th>Titulo</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach var="item" items="${genero}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.titulo}</td>
                        <td>
                            <a href="/genero/update?id=${item.id}" class="btn btn-warning">Editar</a>
                            <a href="/genero/delete?id=${item.id}" class="btn btn-danger">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
