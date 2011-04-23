<%@ attribute name="id" required="true"%>
<%@ attribute name="label" required="true"%>
<script type="text/javascript">
$(function() {
		$("#${id}").datepicker({dateFormat: 'dd/mm/yy HH:mm'});
});
</script>
<label for="${id}" class="rotulo">${label}</label><input type="text" id="${id}" class="texto" name="${id}"/>
