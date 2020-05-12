package br.gov.presidencia.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.presidencia.model.Departamento;
import br.gov.presidencia.model.dao.DepartamentoDAO;

@FacesConverter(value="departamentoConverter")
public class DepartamentoConverter implements Converter{
	
	DepartamentoDAO dao = new DepartamentoDAO();
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null)
		return null;
		if(value instanceof Departamento) {
			Departamento departamento = (Departamento) value;
			if(departamento.getIdDepartamento() != null) {
				 component.getAttributes().put(value.toString(), value);
				 return  departamento.getIdDepartamento().toString();
			}
		}
		 
		return null;
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value){
		if (value == null)
			return null;
		else
		return (Departamento) dao.consultar(Long.valueOf(value));
	}

	

	

}
