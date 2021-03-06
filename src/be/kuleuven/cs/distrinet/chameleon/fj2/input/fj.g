grammar fj;

options {
  output=AST;
  superClass=ChameleonParser;
}

@parser::header {
package be.kuleuven.cs.distrinet.chameleon.fj2.input;

import java.util.*;

import be.kuleuven.cs.distrinet.chameleon.fj2.model.*;
import be.kuleuven.cs.distrinet.chameleon.core.namespacedeclaration.*;
import be.kuleuven.cs.distrinet.chameleon.core.document.*;
import be.kuleuven.cs.distrinet.chameleon.support.input.ChameleonParser;

import be.kuleuven.cs.distrinet.chameleon.core.reference.*;

import org.antlr.runtime.BitSet;

}

@lexer::header {
package be.kuleuven.cs.distrinet.chameleon.fj2.input;
}

// starting point for parsing
compilationUnit returns [Document element] 
@init{ 
  $element = getDocument();
  NamespaceDeclaration npp = new NamespaceDeclaration("");
  $element.add(npp);
}
  : (kl=klazz {npp.add($kl.element);})*
  ;

typeRef returns [CrossReference<Klazz> element]
@after{setLocation($element,retval.start,retval.stop);}
  : i=Identifier {$element=new SimpleReference<Klazz>($i.text,Klazz.class);}	
  ;

klazz returns [Klazz element]
@after{setLocation($element,retval.start,retval.stop);}
  : ckw='class' n=Identifier 
            {$element = new Klazz($n.text); 
             setKeyword($element,$ckw);
             setName($element,$n);
            } 
       (ekw='extends' s=typeRef {$element.setSuperReference($s.element); setKeyword($s.element,$ekw);})?  
     '{'
       cs=constructor {$element.addDeclaration(cs.element);}
       (m=member {$element.addDeclaration(m.element);})* 
     '}'
  ;


constructor returns [Constructor element]
@after{setLocation($element,retval.start,retval.stop);}
  : n=Identifier {$element = new Constructor($n.text);setName($element,$n);}
    p=parameterList {for(Parameter par: $p.element) {$element.addDeclaration(par);}}
    '{'
     (a=assignment {$element.add($a.element);})*
    '}'
  ;
  
  parameterList returns [List<Parameter> element]
  : '(' {$element = new ArrayList<Parameter>();}
     (e=parameter {$element.add($e.element);}
     (',' ee=parameter {$element.add($ee.element);})*)?
     ')'
  ;

parameter returns [Parameter element]
@after{setLocation($element,retval.start,retval.stop);}
  : t=typeRef n=Identifier 
     {$element = new Parameter($n.text);
      $element.setTypeReference($t.element);
      setName($element,$n);}
  ;

  
assignment returns [Assignment element]
@after{setLocation($element,retval.start,retval.stop);}
  : id=Identifier '=' e=expression ';' 
    {$element = new Assignment();
     $element.setValue($e.element);
     // We don't use setName because we want to mark the location of the reference to the variable
     SimpleReference<Variable> varRef = new SimpleReference<Variable>($id.text,Variable.class);
     setLocation(varRef,$id,$id);
     $element.setVariableReference(varRef);
    }
  ;
  
member returns [Member element]
@after{setLocation($element,retval.start,retval.stop);}
  : m=method {$element=m.element;}
  | f=field {$element=f.element;}
  ;
    
method returns [Method element]
  : r=typeRef n=Identifier
      {$element = new Method($n.text); 
       $element.setReturnTypeReference($r.element);
       setName($element,$n);
       }
    p=parameterList {for(Parameter par: $p.element) {$element.addDeclaration(par);}}
    '{'
      e=expression {$element.setExpression($e.element);}
    '}'
  ;
  
  
field returns [Field element]
  : t=typeRef n=Identifier ';'
    {$element = new Field($n.text); 
     $element.setTypeReference($t.element);
     setName($element,$n);
     }
  ;

expression returns [Expression element]
@after{setLocation($element,retval.start,retval.stop);}
  :	s=simple {$element = $s.element;} 
      ('.' ss=suffix[$element] {$element = $ss.element;})*
  ;  
  
simple returns [Expression element]
@after{setLocation($element,retval.start,retval.stop);}
  : ci=constructorInvocation {$element=$ci.element;}
  | mi=simpleInvocation {$element=$mi.element;}
  | va=simpleVariableAccess {$element=$va.element;}
  ;
  
suffix [Expression expr] returns [Expression element]
 :	mi=simpleInvocation {$element=$mi.element; ((MethodInvocation)$element).setTarget($expr);}
   | va=simpleVariableAccess {$element=$va.element; ((VariableAccess)$element).setTarget($expr);}
  ;
  
constructorInvocation returns [ConstructorInvocation element]
  : nkw='new' n=Identifier args=arguments 
     {$element = new ConstructorInvocation($n.text);
      for(Expression e: $args.element) {$element.add(e);}
      setKeyword($element,$nkw);
      setCrossReference($element,$nkw,$n);
     }
  ;

simpleInvocation returns [MethodInvocation element]
  : n=Identifier args=arguments 
     {$element = new MethodInvocation($n.text);
      for(Expression e: $args.element) 
        {$element.add(e);}
       setCrossReference($element,$n,$n);
     }
  ;
     
simpleVariableAccess returns [VariableAccess element]
  : n=Identifier {$element = new VariableAccess($n.text);}     
  ;
arguments returns [List<Expression> element]
  : '(' {$element = new ArrayList<Expression>();}
     (e=expression {$element.add($e.element);}
     ( ',' ee=expression {$element.add($ee.element);} )*)?
     ')'
  ;


// LEXER

HexLiteral : '0' ('x'|'X') HexDigit+ IntegerTypeSuffix? ;

DecimalLiteral : ('0' | '1'..'9' '0'..'9'*) IntegerTypeSuffix? ;

OctalLiteral : '0' ('0'..'7')+ IntegerTypeSuffix? ;

fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
IntegerTypeSuffix : ('l'|'L') ;

FloatingPointLiteral
    :   ('0'..'9')+ '.' ('0'..'9')* Exponent? FloatTypeSuffix?
    |   '.' ('0'..'9')+ Exponent? FloatTypeSuffix?
    |   ('0'..'9')+ Exponent FloatTypeSuffix?
    |   ('0'..'9')+ FloatTypeSuffix
    ;

fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
FloatTypeSuffix : ('f'|'F'|'d'|'D') ;

CharacterLiteral
    :   '\'' ( EscapeSequence | ~('\''|'\\') ) '\''
    ;

StringLiteral
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UnicodeEscape
    |   OctalEscape
    ;

fragment
OctalEscape
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;
    
Identifier 
    :   Letter(Letter|JavaIDDigit)*
    ;
    
/**I found this char range in JavaCC's grammar, but Letter and Digit overlap.
   Still works, but...
 */
fragment
Letter
    :  '\u0024' |
       '\u0041'..'\u005a' |
       '\u005f' |
       '\u0061'..'\u007a' |
       '\u00c0'..'\u00d6' |
       '\u00d8'..'\u00f6' |
       '\u00f8'..'\u00ff' |
       '\u0100'..'\u1fff' |
       '\u3040'..'\u318f' |
       '\u3300'..'\u337f' |
       '\u3400'..'\u3d2d' |
       '\u4e00'..'\u9fff' |
       '\uf900'..'\ufaff' |
       '*'
    ;

fragment
JavaIDDigit
    :  '\u0030'..'\u0039' |
       '\u0660'..'\u0669' |
       '\u06f0'..'\u06f9' |
       '\u0966'..'\u096f' |
       '\u09e6'..'\u09ef' |
       '\u0a66'..'\u0a6f' |
       '\u0ae6'..'\u0aef' |
       '\u0b66'..'\u0b6f' |
       '\u0be7'..'\u0bef' |
       '\u0c66'..'\u0c6f' |
       '\u0ce6'..'\u0cef' |
       '\u0d66'..'\u0d6f' |
       '\u0e50'..'\u0e59' |
       '\u0ed0'..'\u0ed9' |
       '\u1040'..'\u1049'
   ;

WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;

COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;

     