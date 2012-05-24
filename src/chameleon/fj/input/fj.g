grammar fj;

options {
  backtrack=true; 
  memoize=true;
  output=AST;
  superClass=ChameleonParser;
}
@parser::header {
package mview.parser;

import chameleon.fj.model.*;
import chameleon.core.namespacedeclaration.*;
import chameleon.core.document.*;
import chameleon.support.input.ChameleonParser;

}

@lexer::header {
package chameleon.fj.input;
}

// starting point for parsing
compilationUnit returns [Document element] 
@init{ 
  $element = getDocument();
  NamespaceDeclaration npp = new NamespaceDeclaration(language().defaultNamespace());
  $element.add(npp);
}
  : (kl=klazz {npp.add($kl.element);})*
  ;

klazz returns [Klazz element]
  : 'class' n=ID '{' 
        cs=constructor {$element.add(cs.element);}
        (m=member {$element.add(m.element);})* 
     '}'
  ;
  
constructor returns [Constructor element]
  : n=ID {$element = new Constructor($n.text);}
    p=parameterList {for(Parameter par: $p.element) {$element.add(par);}}
    '{'
      (a=assignment {$element.add($a.element);})*
    '}'
    
member returns [Member element]
  : m=method {$element=m.element;}
  | f=field {$element=f.element;}
  ;
    
method returns [Method element]
  : n=ID {$element = new Method($n.text);}
    p=parameterList {for(Parameter par: $p.element) {$element.add(par);}}
    '{'
      e=expression {$element.add($e.element);}
    '}'

field returns [Field element]
  : t=ID n=ID ';' {$element = new Field($n.text);}