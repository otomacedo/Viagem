package br.gov.presidencia.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.presidencia.model.Atividade;
import br.gov.presidencia.model.dao.AtividadeDAO;

@FacesConverter(value="atividadeConverter")
public class AtividadeConverter implements Converter {


	AtividadeDAO dao = new AtividadeDAO();
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null)
			return null;
			if(value instanceof Atividade) {
				Atividade atividade = (Atividade) value;
				if(atividade.getIdAtividade() != null) {
					 component.getAttributes().put(value.toString(), value);
					 return  atividade.getIdAtividade().toString();
				}
			}
			 
			return null;
		}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value){
		if (value == null)
			return null; 
		else
			return (Atividade) dao.consultar(Long.valueOf(value));
	}

}
