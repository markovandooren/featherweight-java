package be.kuleuven.cs.distrinet.chameleon.fj2.eclipse;

import java.util.List;

import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.eclipse.connector.EclipseEditorExtension;
import be.kuleuven.cs.distrinet.chameleon.fj2.model.MemberWithParameters;
import be.kuleuven.cs.distrinet.chameleon.fj2.model.Parameter;


public class FJEditorExtension extends EclipseEditorExtension {

	public FJEditorExtension(String languageName) {
		super(languageName);
	}
	
	@Override
	public String getLabel(Element element) {
		try {
			String result;
			if (element instanceof MemberWithParameters) {
				MemberWithParameters method = (MemberWithParameters)element;
				result = method.name();
				List<Parameter> params = method.parameters();
				result = toLabel(result, params);
			} else result = super.getLabel(element);
			return result;
		} catch(Exception exc) {
			return "";
		}
	}

	private String toLabel(String result, List<Parameter> params) {
		result += "(";
		if (params.size()>0) {
			for (int i = 0;i<params.size();i++) {
				Parameter p = params.get(i);
					result += p.typeReference();
				if (i<params.size()-1) {
					result += ",";
				}
			}
		}
		result += ")";
	  return result;
	}

}
