<%@ attribute name="titulo" required="true" rtexprvalue="true"%>
<%@ attribute name="mensagem" required="true" rtexprvalue="true"%>
<%@ attribute name="id" required="true" rtexprvalue="true"%>
<div id="${id}" class="dialog" title="${titulo}">
	<h4>${mensagem}</h4> 
</div>

