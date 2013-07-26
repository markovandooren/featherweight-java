package be.kuleuven.cs.distrinet.chameleon.fj2.model;

import java.util.Iterator;
import java.util.List;

import be.kuleuven.cs.distrinet.chameleon.core.declaration.CommonDeclarationContainingDeclaration;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Declaration;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.Signature;
import be.kuleuven.cs.distrinet.chameleon.core.declaration.SimpleNameSignature;
import be.kuleuven.cs.distrinet.chameleon.core.element.Element;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.DeclarationSelector;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.LookupException;
import be.kuleuven.cs.distrinet.chameleon.core.lookup.SelectionResult;
import be.kuleuven.cs.distrinet.chameleon.core.reference.CrossReference;
import be.kuleuven.cs.distrinet.chameleon.core.reference.SimpleReference;
import be.kuleuven.cs.distrinet.chameleon.core.validation.BasicProblem;
import be.kuleuven.cs.distrinet.chameleon.core.validation.Verification;
import be.kuleuven.cs.distrinet.chameleon.util.Util;
import be.kuleuven.cs.distrinet.chameleon.util.association.Single;

public class Klazz extends CommonDeclarationContainingDeclaration {

	public Klazz() {
	}
	
	public Klazz(String name) {
		setSignature(new SimpleNameSignature(name));
	}
	
	private Single<CrossReference<Klazz>> _super = new Single<CrossReference<Klazz>>(this);
	
	public CrossReference<Klazz> superReference() {
		return _super.getOtherEnd();
	}
	
	public void setSuperReference(CrossReference<Klazz> ref) {
		set(_super,ref);
	}
	
	public void setSuperKlazz(String fqn) {
		setSuperReference(new SimpleReference<Klazz>(fqn, Klazz.class));
	}
	
	public Klazz superKlazz() throws LookupException {
		CrossReference<Klazz> superReference = superReference();
		return superReference == null ? null : superReference.getElement();
	}
	
	@Override
	protected Klazz cloneSelf() {
		return new Klazz();
	}
	
	@Override
	public <D extends Declaration> List<? extends SelectionResult> declarations(DeclarationSelector<D> selector) throws LookupException {
		// 1. Search locally
		List<? extends SelectionResult> result = super.declarations(selector);
		// 2.If nothing was found, search in the super class.
		//   Remember that FJ has no syntactic overloading, so unlike in real Java
		//   the super class does not have to be searched to look for a better match.
		if(result.isEmpty()) {
			Klazz superKlazz = superKlazz();
			if(superKlazz != null) {
			  result = superKlazz.declarations(selector);
			}
		}
		return result;
	}
	
	@Override
	public List<Element> childrenNotInScopeOfDeclarations() {
		return Util.createNonNullList(superReference());
	}
	
	@Override
	public List<? extends Declaration> declarations() throws LookupException {
		List<Declaration> result = (List<Declaration>) super.declarations();
		List<Declaration> local = (List<Declaration>) super.declarations();
		Klazz superKlass = superKlazz();
		if(superKlass != null) {
			List<? extends Declaration> supers = superKlazz().declarations();
			for(Declaration superDeclaration: supers) {
				boolean add = true;
				Signature signature = superDeclaration.signature();
				Iterator<Declaration> iter = local.iterator();
				while(add && iter.hasNext()) {
					if(iter.next().signature().sameAs(signature)) {
						add = false;
					}
				}
				if(add == true) {
					result.add(superDeclaration);
				}
			}
		}
		return result;
	}
	
	@Override
	public Verification verifySelf() {
		Verification result = super.verifySelf();
		try {
		List<? extends Declaration> declarations = localDeclarations();
		for(Declaration decl: declarations) {
			Signature signature = decl.signature();
			Iterator<? extends Declaration> iter = declarations.iterator();
			while(iter.hasNext()) {
				Declaration next = iter.next();
				if(next != decl && next.signature().sameAs(signature)) {
					result = result.and(new BasicProblem(decl, "Duplicate definition with signature "+signature));
					result = result.and(new BasicProblem(next, "Duplicate definition with signature "+signature));
				}
			}
		}
		} catch(LookupException exc) {
			// Another element should report this error.
		}
		return result;
	}
}
