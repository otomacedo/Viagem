package br.gov.presidencia.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.gov.presidencia.model.Setor;
import br.gov.presidencia.model.dao.SetorDAO;


/**
 * 
 * @author otoma
 */
@FacesConverter(value="setorConverter")
public class SetorConverter implements Converter{

	SetorDAO dao = new SetorDAO();
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null)
			return null;
			if(value instanceof Setor) {
				Setor setor = (Setor) value;
				if(setor.getIdSetor() != null) {
					 component.getAttributes().put(value.toString(), value);
					 return  setor.getIdSetor().toString();
				}
			}
			 
			return null;
		}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value){
		if (value == null)
			return null;
		else
		return (Setor)  dao.consultar(Long.valueOf(value));
	}


}
