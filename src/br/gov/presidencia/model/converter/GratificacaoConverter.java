package br.gov.presidencia.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.presidencia.model.Gratificacao;
import br.gov.presidencia.model.dao.GratificacaoDAO;

@FacesConverter(value="gratificacaoConverter")
public class GratificacaoConverter implements Converter {

	GratificacaoDAO dao = new GratificacaoDAO();
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null)
			return null;
			if(value instanceof Gratificacao) {
				Gratificacao gratificacao = (Gratificacao) value;
				if(gratificacao.getIdGratificacao() != null) {
					 component.getAttributes().put(value.toString(), value);
					 return  gratificacao.getIdGratificacao().toString();
				}
			}
			 
			return null;
		}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value){
		if (value == null)
			return null;
		else
		return (Gratificacao) dao.consultar(Long.valueOf(value));
	}

}
