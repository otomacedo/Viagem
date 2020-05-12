package br.gov.presidencia.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.presidencia.model.Funcionario;
import br.gov.presidencia.model.dao.FuncionarioDAO;

@FacesConverter (value="funcionarioConverter")
public class FuncionarioConverter implements Converter {

	FuncionarioDAO dao = new FuncionarioDAO();
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null)
			return null;
		if(value instanceof Funcionario) {
			Funcionario funcionario = (Funcionario) value;
			if(funcionario.getIdFuncionario() != null) {
				 component.getAttributes().put(value.toString(), value);
				 return  funcionario.getIdFuncionario().toString();
			}
		}
		
		return null;
	}
	
	@Override
	public Object getAsObject(FacesContext context , UIComponent component, String value) {
		if (value == null)
			return null;
		else
			return (Funcionario) dao.consultar(Integer.valueOf(value));
	}

	
	}


