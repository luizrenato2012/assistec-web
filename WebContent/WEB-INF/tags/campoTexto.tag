<%@ attribute name="idInput" required="true"%>
<%@ attribute name="nameInput" required="true"%>
<%@ attribute name="label" required="true"%>
<%@ attribute name="onKeyPress" required="false"%>
<%@ attribute name="value" required="false"%>
<label for="${idInput}" class="rotulo">${label}</label><input type="text" class="texto" id="${idInput}" name="${nameInput}" 
	onKeyPress="${onKeyPress}" value="${value}"/>