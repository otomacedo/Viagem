package br.gov.presidencia.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.presidencia.model.Graduacao;
import br.gov.presidencia.model.dao.GraduacaoDAO;

@FacesConverter(value="graduacaoConverter")
public class GraduacaoConverter implements Converter {

	GraduacaoDAO dao = new GraduacaoDAO();
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null)
			return null;
			if(value instanceof Graduacao) {
				Graduacao graduacao = (Graduacao) value;
				if(graduacao.getIdGraduacao() != null) {
					 component.getAttributes().put(value.toString(), value);
					 return  graduacao.getIdGraduacao().toString();
				}
			}
			 
			return null;
		}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value){
		if (value == null)
			return null;
		else
		return (Graduacao) dao.consultar(Long.valueOf(value));
	}
}
