<%@ attribute name="msgAviso" required="false" rtexprvalue="true" %>
<%@ attribute name="msgErro" required="false" rtexprvalue="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:choose>
<c:when test="${not empty msgErro}">
	<div class="box_erro">
		<label class="erro_rotulo">Erro: ${msgErro}</label>
	</div>
</c:when>
<c:otherwise>
	<c:if test="${not empty msgAviso}">
		<div class="box_aviso">
		<label class="aviso_rotulo">Aviso: ${msgAviso}</label>
	</div>
	</c:if>
</c:otherwise>	
</c:choose>