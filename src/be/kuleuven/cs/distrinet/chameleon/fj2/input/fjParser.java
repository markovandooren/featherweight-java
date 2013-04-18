// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g 2013-03-25 12:41:57

package be.kuleuven.cs.distrinet.chameleon.fj2.input;

import java.util.*;

import be.kuleuven.cs.distrinet.chameleon.fj2.model.*;
import be.kuleuven.cs.distrinet.chameleon.core.namespacedeclaration.*;
import be.kuleuven.cs.distrinet.chameleon.core.document.*;
import be.kuleuven.cs.distrinet.chameleon.support.input.ChameleonParser;

import be.kuleuven.cs.distrinet.chameleon.core.reference.*;

import org.antlr.runtime.BitSet;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class fjParser extends ChameleonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "HexDigit", "IntegerTypeSuffix", "HexLiteral", "DecimalLiteral", "OctalLiteral", "Exponent", "FloatTypeSuffix", "FloatingPointLiteral", "EscapeSequence", "CharacterLiteral", "StringLiteral", "UnicodeEscape", "OctalEscape", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'class'", "'extends'", "'{'", "'}'", "'('", "','", "')'", "'='", "';'", "'.'", "'new'"
    };
    public static final int EOF=-1;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int Identifier=4;
    public static final int HexDigit=5;
    public static final int IntegerTypeSuffix=6;
    public static final int HexLiteral=7;
    public static final int DecimalLiteral=8;
    public static final int OctalLiteral=9;
    public static final int Exponent=10;
    public static final int FloatTypeSuffix=11;
    public static final int FloatingPointLiteral=12;
    public static final int EscapeSequence=13;
    public static final int CharacterLiteral=14;
    public static final int StringLiteral=15;
    public static final int UnicodeEscape=16;
    public static final int OctalEscape=17;
    public static final int Letter=18;
    public static final int JavaIDDigit=19;
    public static final int WS=20;
    public static final int COMMENT=21;
    public static final int LINE_COMMENT=22;

    // delegates
    // delegators


        public fjParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public fjParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return fjParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g"; }


    public static class compilationUnit_return extends ParserRuleReturnScope {
        public Document element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compilationUnit"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:29:1: compilationUnit returns [Document element] : (kl= klazz )* ;
    public final fjParser.compilationUnit_return compilationUnit() throws RecognitionException {
        fjParser.compilationUnit_return retval = new fjParser.compilationUnit_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        fjParser.klazz_return kl = null;



         
          retval.element = getDocument();
          NamespaceDeclaration npp = new NamespaceDeclaration("");
          retval.element.add(npp);

        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:35:3: ( (kl= klazz )* )
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:35:5: (kl= klazz )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:35:5: (kl= klazz )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==23) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:35:6: kl= klazz
            	    {
            	    pushFollow(FOLLOW_klazz_in_compilationUnit62);
            	    kl=klazz();

            	    state._fsp--;

            	    adaptor.addChild(root_0, kl.getTree());
            	    npp.add((kl!=null?kl.element:null));

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "compilationUnit"

    public static class typeRef_return extends ParserRuleReturnScope {
        public CrossReference<Klazz> element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeRef"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:38:1: typeRef returns [CrossReference<Klazz> element] : i= Identifier ;
    public final fjParser.typeRef_return typeRef() throws RecognitionException {
        fjParser.typeRef_return retval = new fjParser.typeRef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;

        Object i_tree=null;

        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:40:3: (i= Identifier )
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:40:5: i= Identifier
            {
            root_0 = (Object)adaptor.nil();

            i=(Token)match(input,Identifier,FOLLOW_Identifier_in_typeRef89); 
            i_tree = (Object)adaptor.create(i);
            adaptor.addChild(root_0, i_tree);

            retval.element =new SimpleReference<Klazz>((i!=null?i.getText():null),Klazz.class);

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

            setLocation(retval.element,retval.start,retval.stop);
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "typeRef"

    public static class klazz_return extends ParserRuleReturnScope {
        public Klazz element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "klazz"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:43:1: klazz returns [Klazz element] : ckw= 'class' n= Identifier (ekw= 'extends' s= typeRef )? '{' cs= constructor (m= member )* '}' ;
    public final fjParser.klazz_return klazz() throws RecognitionException {
        fjParser.klazz_return retval = new fjParser.klazz_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ckw=null;
        Token n=null;
        Token ekw=null;
        Token char_literal1=null;
        Token char_literal2=null;
        fjParser.typeRef_return s = null;

        fjParser.constructor_return cs = null;

        fjParser.member_return m = null;


        Object ckw_tree=null;
        Object n_tree=null;
        Object ekw_tree=null;
        Object char_literal1_tree=null;
        Object char_literal2_tree=null;

        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:45:3: (ckw= 'class' n= Identifier (ekw= 'extends' s= typeRef )? '{' cs= constructor (m= member )* '}' )
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:45:5: ckw= 'class' n= Identifier (ekw= 'extends' s= typeRef )? '{' cs= constructor (m= member )* '}'
            {
            root_0 = (Object)adaptor.nil();

            ckw=(Token)match(input,23,FOLLOW_23_in_klazz115); 
            ckw_tree = (Object)adaptor.create(ckw);
            adaptor.addChild(root_0, ckw_tree);

            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_klazz119); 
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);

            retval.element = new Klazz((n!=null?n.getText():null)); 
                         setKeyword(retval.element,ckw);
                         setName(retval.element,n);
                        
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:50:8: (ekw= 'extends' s= typeRef )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==24) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:50:9: ekw= 'extends' s= typeRef
                    {
                    ekw=(Token)match(input,24,FOLLOW_24_in_klazz147); 
                    ekw_tree = (Object)adaptor.create(ekw);
                    adaptor.addChild(root_0, ekw_tree);

                    pushFollow(FOLLOW_typeRef_in_klazz151);
                    s=typeRef();

                    state._fsp--;

                    adaptor.addChild(root_0, s.getTree());
                    retval.element.setSuperReference((s!=null?s.element:null)); setKeyword((s!=null?s.element:null),ekw);

                    }
                    break;

            }

            char_literal1=(Token)match(input,25,FOLLOW_25_in_klazz164); 
            char_literal1_tree = (Object)adaptor.create(char_literal1);
            adaptor.addChild(root_0, char_literal1_tree);

            pushFollow(FOLLOW_constructor_in_klazz175);
            cs=constructor();

            state._fsp--;

            adaptor.addChild(root_0, cs.getTree());
            retval.element.addDeclaration(cs.element);
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:53:8: (m= member )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Identifier) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:53:9: m= member
            	    {
            	    pushFollow(FOLLOW_member_in_klazz189);
            	    m=member();

            	    state._fsp--;

            	    adaptor.addChild(root_0, m.getTree());
            	    retval.element.addDeclaration(m.element);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            char_literal2=(Token)match(input,26,FOLLOW_26_in_klazz201); 
            char_literal2_tree = (Object)adaptor.create(char_literal2);
            adaptor.addChild(root_0, char_literal2_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

            setLocation(retval.element,retval.start,retval.stop);
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "klazz"

    public static class constructor_return extends ParserRuleReturnScope {
        public Constructor element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constructor"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:58:1: constructor returns [Constructor element] : n= Identifier p= parameterList '{' (a= assignment )* '}' ;
    public final fjParser.constructor_return constructor() throws RecognitionException {
        fjParser.constructor_return retval = new fjParser.constructor_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token char_literal3=null;
        Token char_literal4=null;
        fjParser.parameterList_return p = null;

        fjParser.assignment_return a = null;


        Object n_tree=null;
        Object char_literal3_tree=null;
        Object char_literal4_tree=null;

        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:60:3: (n= Identifier p= parameterList '{' (a= assignment )* '}' )
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:60:5: n= Identifier p= parameterList '{' (a= assignment )* '}'
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_constructor225); 
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);

            retval.element = new Constructor((n!=null?n.getText():null));setName(retval.element,n);
            pushFollow(FOLLOW_parameterList_in_constructor235);
            p=parameterList();

            state._fsp--;

            adaptor.addChild(root_0, p.getTree());
            for(Parameter par: (p!=null?p.element:null)) {retval.element.addDeclaration(par);}
            char_literal3=(Token)match(input,25,FOLLOW_25_in_constructor243); 
            char_literal3_tree = (Object)adaptor.create(char_literal3);
            adaptor.addChild(root_0, char_literal3_tree);

            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:63:6: (a= assignment )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Identifier) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:63:7: a= assignment
            	    {
            	    pushFollow(FOLLOW_assignment_in_constructor253);
            	    a=assignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, a.getTree());
            	    retval.element.add((a!=null?a.element:null));

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            char_literal4=(Token)match(input,26,FOLLOW_26_in_constructor263); 
            char_literal4_tree = (Object)adaptor.create(char_literal4);
            adaptor.addChild(root_0, char_literal4_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

            setLocation(retval.element,retval.start,retval.stop);
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constructor"

    public static class parameterList_return extends ParserRuleReturnScope {
        public List<Parameter> element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parameterList"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:67:3: parameterList returns [List<Parameter> element] : '(' (e= parameter ( ',' ee= parameter )* )? ')' ;
    public final fjParser.parameterList_return parameterList() throws RecognitionException {
        fjParser.parameterList_return retval = new fjParser.parameterList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal5=null;
        Token char_literal6=null;
        Token char_literal7=null;
        fjParser.parameter_return e = null;

        fjParser.parameter_return ee = null;


        Object char_literal5_tree=null;
        Object char_literal6_tree=null;
        Object char_literal7_tree=null;

        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:68:3: ( '(' (e= parameter ( ',' ee= parameter )* )? ')' )
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:68:5: '(' (e= parameter ( ',' ee= parameter )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal5=(Token)match(input,27,FOLLOW_27_in_parameterList284); 
            char_literal5_tree = (Object)adaptor.create(char_literal5);
            adaptor.addChild(root_0, char_literal5_tree);

            retval.element = new ArrayList<Parameter>();
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:69:6: (e= parameter ( ',' ee= parameter )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Identifier) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:69:7: e= parameter ( ',' ee= parameter )*
                    {
                    pushFollow(FOLLOW_parameter_in_parameterList296);
                    e=parameter();

                    state._fsp--;

                    adaptor.addChild(root_0, e.getTree());
                    retval.element.add((e!=null?e.element:null));
                    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:70:6: ( ',' ee= parameter )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==28) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:70:7: ',' ee= parameter
                    	    {
                    	    char_literal6=(Token)match(input,28,FOLLOW_28_in_parameterList306); 
                    	    char_literal6_tree = (Object)adaptor.create(char_literal6);
                    	    adaptor.addChild(root_0, char_literal6_tree);

                    	    pushFollow(FOLLOW_parameter_in_parameterList310);
                    	    ee=parameter();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, ee.getTree());
                    	    retval.element.add((ee!=null?ee.element:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal7=(Token)match(input,29,FOLLOW_29_in_parameterList323); 
            char_literal7_tree = (Object)adaptor.create(char_literal7);
            adaptor.addChild(root_0, char_literal7_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "parameterList"

    public static class parameter_return extends ParserRuleReturnScope {
        public Parameter element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parameter"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:74:1: parameter returns [Parameter element] : t= typeRef n= Identifier ;
    public final fjParser.parameter_return parameter() throws RecognitionException {
        fjParser.parameter_return retval = new fjParser.parameter_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        fjParser.typeRef_return t = null;


        Object n_tree=null;

        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:76:3: (t= typeRef n= Identifier )
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:76:5: t= typeRef n= Identifier
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRef_in_parameter346);
            t=typeRef();

            state._fsp--;

            adaptor.addChild(root_0, t.getTree());
            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_parameter350); 
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);

            retval.element = new Parameter((n!=null?n.getText():null));
                  retval.element.setTypeReference((t!=null?t.element:null));
                  setName(retval.element,n);

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

            setLocation(retval.element,retval.start,retval.stop);
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "parameter"

    public static class assignment_return extends ParserRuleReturnScope {
        public Assignment element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:83:1: assignment returns [Assignment element] : id= Identifier '=' e= expression ';' ;
    public final fjParser.assignment_return assignment() throws RecognitionException {
        fjParser.assignment_return retval = new fjParser.assignment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;
        Token char_literal8=null;
        Token char_literal9=null;
        fjParser.expression_return e = null;


        Object id_tree=null;
        Object char_literal8_tree=null;
        Object char_literal9_tree=null;

        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:85:3: (id= Identifier '=' e= expression ';' )
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:85:5: id= Identifier '=' e= expression ';'
            {
            root_0 = (Object)adaptor.nil();

            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_assignment384); 
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);

            char_literal8=(Token)match(input,30,FOLLOW_30_in_assignment386); 
            char_literal8_tree = (Object)adaptor.create(char_literal8);
            adaptor.addChild(root_0, char_literal8_tree);

            pushFollow(FOLLOW_expression_in_assignment390);
            e=expression();

            state._fsp--;

            adaptor.addChild(root_0, e.getTree());
            char_literal9=(Token)match(input,31,FOLLOW_31_in_assignment392); 
            char_literal9_tree = (Object)adaptor.create(char_literal9);
            adaptor.addChild(root_0, char_literal9_tree);

            retval.element = new Assignment();
                 retval.element.setValue((e!=null?e.element:null));
                 SimpleReference<Variable> varRef = new SimpleReference<Variable>((id!=null?id.getText():null),Variable.class);
                 setLocation(varRef,id,id);
                 retval.element.setVariableReference(varRef);
                

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

            setLocation(retval.element,retval.start,retval.stop);
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignment"

    public static class member_return extends ParserRuleReturnScope {
        public Member element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "member"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:94:1: member returns [Member element] : (m= method | f= field );
    public final fjParser.member_return member() throws RecognitionException {
        fjParser.member_return retval = new fjParser.member_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        fjParser.method_return m = null;

        fjParser.field_return f = null;



        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:96:3: (m= method | f= field )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Identifier) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==Identifier) ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==31) ) {
                        alt7=2;
                    }
                    else if ( (LA7_2==27) ) {
                        alt7=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:96:5: m= method
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_method_in_member424);
                    m=method();

                    state._fsp--;

                    adaptor.addChild(root_0, m.getTree());
                    retval.element =m.element;

                    }
                    break;
                case 2 :
                    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:97:5: f= field
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_field_in_member434);
                    f=field();

                    state._fsp--;

                    adaptor.addChild(root_0, f.getTree());
                    retval.element =f.element;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

            setLocation(retval.element,retval.start,retval.stop);
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "member"

    public static class method_return extends ParserRuleReturnScope {
        public Method element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "method"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:100:1: method returns [Method element] : r= typeRef n= Identifier p= parameterList '{' e= expression '}' ;
    public final fjParser.method_return method() throws RecognitionException {
        fjParser.method_return retval = new fjParser.method_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token char_literal10=null;
        Token char_literal11=null;
        fjParser.typeRef_return r = null;

        fjParser.parameterList_return p = null;

        fjParser.expression_return e = null;


        Object n_tree=null;
        Object char_literal10_tree=null;
        Object char_literal11_tree=null;

        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:101:3: (r= typeRef n= Identifier p= parameterList '{' e= expression '}' )
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:101:5: r= typeRef n= Identifier p= parameterList '{' e= expression '}'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRef_in_method459);
            r=typeRef();

            state._fsp--;

            adaptor.addChild(root_0, r.getTree());
            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_method463); 
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);

            retval.element = new Method((n!=null?n.getText():null)); 
                   retval.element.setReturnTypeReference((r!=null?r.element:null));
                   setName(retval.element,n);
                   
            pushFollow(FOLLOW_parameterList_in_method479);
            p=parameterList();

            state._fsp--;

            adaptor.addChild(root_0, p.getTree());
            for(Parameter par: (p!=null?p.element:null)) {retval.element.addDeclaration(par);}
            char_literal10=(Token)match(input,25,FOLLOW_25_in_method487); 
            char_literal10_tree = (Object)adaptor.create(char_literal10);
            adaptor.addChild(root_0, char_literal10_tree);

            pushFollow(FOLLOW_expression_in_method497);
            e=expression();

            state._fsp--;

            adaptor.addChild(root_0, e.getTree());
            retval.element.setExpression((e!=null?e.element:null));
            char_literal11=(Token)match(input,26,FOLLOW_26_in_method505); 
            char_literal11_tree = (Object)adaptor.create(char_literal11);
            adaptor.addChild(root_0, char_literal11_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "method"

    public static class field_return extends ParserRuleReturnScope {
        public Field element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "field"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:113:1: field returns [Field element] : t= typeRef n= Identifier ';' ;
    public final fjParser.field_return field() throws RecognitionException {
        fjParser.field_return retval = new fjParser.field_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token char_literal12=null;
        fjParser.typeRef_return t = null;


        Object n_tree=null;
        Object char_literal12_tree=null;

        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:114:3: (t= typeRef n= Identifier ';' )
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:114:5: t= typeRef n= Identifier ';'
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_typeRef_in_field529);
            t=typeRef();

            state._fsp--;

            adaptor.addChild(root_0, t.getTree());
            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_field533); 
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);

            char_literal12=(Token)match(input,31,FOLLOW_31_in_field535); 
            char_literal12_tree = (Object)adaptor.create(char_literal12);
            adaptor.addChild(root_0, char_literal12_tree);

            retval.element = new Field((n!=null?n.getText():null)); 
                 retval.element.setTypeReference((t!=null?t.element:null));
                 setName(retval.element,n);
                 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "field"

    public static class expression_return extends ParserRuleReturnScope {
        public Expression element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:121:1: expression returns [Expression element] : s= simple ( '.' ss= suffix[$element] )* ;
    public final fjParser.expression_return expression() throws RecognitionException {
        fjParser.expression_return retval = new fjParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal13=null;
        fjParser.simple_return s = null;

        fjParser.suffix_return ss = null;


        Object char_literal13_tree=null;

        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:123:3: (s= simple ( '.' ss= suffix[$element] )* )
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:123:5: s= simple ( '.' ss= suffix[$element] )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_simple_in_expression564);
            s=simple();

            state._fsp--;

            adaptor.addChild(root_0, s.getTree());
            retval.element = (s!=null?s.element:null);
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:124:7: ( '.' ss= suffix[$element] )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==32) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:124:8: '.' ss= suffix[$element]
            	    {
            	    char_literal13=(Token)match(input,32,FOLLOW_32_in_expression576); 
            	    char_literal13_tree = (Object)adaptor.create(char_literal13);
            	    adaptor.addChild(root_0, char_literal13_tree);

            	    pushFollow(FOLLOW_suffix_in_expression580);
            	    ss=suffix(retval.element);

            	    state._fsp--;

            	    adaptor.addChild(root_0, ss.getTree());
            	    retval.element = (ss!=null?ss.element:null);

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

            setLocation(retval.element,retval.start,retval.stop);
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class simple_return extends ParserRuleReturnScope {
        public Expression element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simple"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:127:1: simple returns [Expression element] : (ci= constructorInvocation | mi= simpleInvocation | va= simpleVariableAccess );
    public final fjParser.simple_return simple() throws RecognitionException {
        fjParser.simple_return retval = new fjParser.simple_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        fjParser.constructorInvocation_return ci = null;

        fjParser.simpleInvocation_return mi = null;

        fjParser.simpleVariableAccess_return va = null;



        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:129:3: (ci= constructorInvocation | mi= simpleInvocation | va= simpleVariableAccess )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==33) ) {
                alt9=1;
            }
            else if ( (LA9_0==Identifier) ) {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==27) ) {
                    alt9=2;
                }
                else if ( (LA9_2==26||(LA9_2>=28 && LA9_2<=29)||(LA9_2>=31 && LA9_2<=32)) ) {
                    alt9=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:129:5: ci= constructorInvocation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constructorInvocation_in_simple612);
                    ci=constructorInvocation();

                    state._fsp--;

                    adaptor.addChild(root_0, ci.getTree());
                    retval.element =(ci!=null?ci.element:null);

                    }
                    break;
                case 2 :
                    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:130:5: mi= simpleInvocation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_simpleInvocation_in_simple622);
                    mi=simpleInvocation();

                    state._fsp--;

                    adaptor.addChild(root_0, mi.getTree());
                    retval.element =(mi!=null?mi.element:null);

                    }
                    break;
                case 3 :
                    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:131:5: va= simpleVariableAccess
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_simpleVariableAccess_in_simple632);
                    va=simpleVariableAccess();

                    state._fsp--;

                    adaptor.addChild(root_0, va.getTree());
                    retval.element =(va!=null?va.element:null);

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

            setLocation(retval.element,retval.start,retval.stop);
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "simple"

    public static class suffix_return extends ParserRuleReturnScope {
        public Expression element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "suffix"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:134:1: suffix[Expression expr] returns [Expression element] : (mi= simpleInvocation | va= simpleVariableAccess );
    public final fjParser.suffix_return suffix(Expression expr) throws RecognitionException {
        fjParser.suffix_return retval = new fjParser.suffix_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        fjParser.simpleInvocation_return mi = null;

        fjParser.simpleVariableAccess_return va = null;



        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:135:2: (mi= simpleInvocation | va= simpleVariableAccess )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Identifier) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==27) ) {
                    alt10=1;
                }
                else if ( (LA10_1==26||(LA10_1>=28 && LA10_1<=29)||(LA10_1>=31 && LA10_1<=32)) ) {
                    alt10=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:135:4: mi= simpleInvocation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_simpleInvocation_in_suffix656);
                    mi=simpleInvocation();

                    state._fsp--;

                    adaptor.addChild(root_0, mi.getTree());
                    retval.element =(mi!=null?mi.element:null); ((MethodInvocation)retval.element).setTarget(expr);

                    }
                    break;
                case 2 :
                    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:136:6: va= simpleVariableAccess
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_simpleVariableAccess_in_suffix667);
                    va=simpleVariableAccess();

                    state._fsp--;

                    adaptor.addChild(root_0, va.getTree());
                    retval.element =(va!=null?va.element:null); ((VariableAccess)retval.element).setTarget(expr);

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "suffix"

    public static class constructorInvocation_return extends ParserRuleReturnScope {
        public ConstructorInvocation element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constructorInvocation"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:139:1: constructorInvocation returns [ConstructorInvocation element] : nkw= 'new' n= Identifier args= arguments ;
    public final fjParser.constructorInvocation_return constructorInvocation() throws RecognitionException {
        fjParser.constructorInvocation_return retval = new fjParser.constructorInvocation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token nkw=null;
        Token n=null;
        fjParser.arguments_return args = null;


        Object nkw_tree=null;
        Object n_tree=null;

        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:140:3: (nkw= 'new' n= Identifier args= arguments )
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:140:5: nkw= 'new' n= Identifier args= arguments
            {
            root_0 = (Object)adaptor.nil();

            nkw=(Token)match(input,33,FOLLOW_33_in_constructorInvocation690); 
            nkw_tree = (Object)adaptor.create(nkw);
            adaptor.addChild(root_0, nkw_tree);

            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_constructorInvocation694); 
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);

            pushFollow(FOLLOW_arguments_in_constructorInvocation698);
            args=arguments();

            state._fsp--;

            adaptor.addChild(root_0, args.getTree());
            retval.element = new ConstructorInvocation((n!=null?n.getText():null));
                  for(Expression e: (args!=null?args.element:null)) {retval.element.add(e);}
                  setKeyword(retval.element,nkw);
                  setCrossReference(retval.element,nkw,n);
                 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constructorInvocation"

    public static class simpleInvocation_return extends ParserRuleReturnScope {
        public MethodInvocation element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simpleInvocation"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:148:1: simpleInvocation returns [MethodInvocation element] : n= Identifier args= arguments ;
    public final fjParser.simpleInvocation_return simpleInvocation() throws RecognitionException {
        fjParser.simpleInvocation_return retval = new fjParser.simpleInvocation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        fjParser.arguments_return args = null;


        Object n_tree=null;

        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:149:3: (n= Identifier args= arguments )
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:149:5: n= Identifier args= arguments
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_simpleInvocation725); 
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);

            pushFollow(FOLLOW_arguments_in_simpleInvocation729);
            args=arguments();

            state._fsp--;

            adaptor.addChild(root_0, args.getTree());
            retval.element = new MethodInvocation((n!=null?n.getText():null));
                  for(Expression e: (args!=null?args.element:null)) 
                    {retval.element.add(e);}
                   setCrossReference(retval.element,n,n);
                 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "simpleInvocation"

    public static class simpleVariableAccess_return extends ParserRuleReturnScope {
        public VariableAccess element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simpleVariableAccess"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:157:1: simpleVariableAccess returns [VariableAccess element] : n= Identifier ;
    public final fjParser.simpleVariableAccess_return simpleVariableAccess() throws RecognitionException {
        fjParser.simpleVariableAccess_return retval = new fjParser.simpleVariableAccess_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:158:3: (n= Identifier )
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:158:5: n= Identifier
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_simpleVariableAccess761); 
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);

            retval.element = new VariableAccess((n!=null?n.getText():null));

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "simpleVariableAccess"

    public static class arguments_return extends ParserRuleReturnScope {
        public List<Expression> element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arguments"
    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:160:1: arguments returns [List<Expression> element] : '(' (e= expression ( ',' ee= expression )* )? ')' ;
    public final fjParser.arguments_return arguments() throws RecognitionException {
        fjParser.arguments_return retval = new fjParser.arguments_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal14=null;
        Token char_literal15=null;
        Token char_literal16=null;
        fjParser.expression_return e = null;

        fjParser.expression_return ee = null;


        Object char_literal14_tree=null;
        Object char_literal15_tree=null;
        Object char_literal16_tree=null;

        try {
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:161:3: ( '(' (e= expression ( ',' ee= expression )* )? ')' )
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:161:5: '(' (e= expression ( ',' ee= expression )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal14=(Token)match(input,27,FOLLOW_27_in_arguments784); 
            char_literal14_tree = (Object)adaptor.create(char_literal14);
            adaptor.addChild(root_0, char_literal14_tree);

            retval.element = new ArrayList<Expression>();
            // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:162:6: (e= expression ( ',' ee= expression )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Identifier||LA12_0==33) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:162:7: e= expression ( ',' ee= expression )*
                    {
                    pushFollow(FOLLOW_expression_in_arguments796);
                    e=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, e.getTree());
                    retval.element.add((e!=null?e.element:null));
                    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:163:6: ( ',' ee= expression )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==28) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /Users/marko/git/fj/src/be/kuleuven/cs/distrinet/chameleon/fj2/input/fj.g:163:8: ',' ee= expression
                    	    {
                    	    char_literal15=(Token)match(input,28,FOLLOW_28_in_arguments807); 
                    	    char_literal15_tree = (Object)adaptor.create(char_literal15);
                    	    adaptor.addChild(root_0, char_literal15_tree);

                    	    pushFollow(FOLLOW_expression_in_arguments811);
                    	    ee=expression();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, ee.getTree());
                    	    retval.element.add((ee!=null?ee.element:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal16=(Token)match(input,29,FOLLOW_29_in_arguments825); 
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arguments"

    // Delegated rules


 

    public static final BitSet FOLLOW_klazz_in_compilationUnit62 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_Identifier_in_typeRef89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_klazz115 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_klazz119 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_klazz147 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_typeRef_in_klazz151 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_klazz164 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_constructor_in_klazz175 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_member_in_klazz189 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_26_in_klazz201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_constructor225 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_parameterList_in_constructor235 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_constructor243 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_assignment_in_constructor253 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_26_in_constructor263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_parameterList284 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_parameter_in_parameterList296 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_parameterList306 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parameter_in_parameterList310 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_parameterList323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRef_in_parameter346 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_parameter350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_assignment384 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_assignment386 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_expression_in_assignment390 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_assignment392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_member424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_in_member434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRef_in_method459 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_method463 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_parameterList_in_method479 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_method487 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_expression_in_method497 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_method505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeRef_in_field529 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_field533 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_field535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_in_expression564 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_expression576 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_suffix_in_expression580 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_constructorInvocation_in_simple612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleInvocation_in_simple622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleVariableAccess_in_simple632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleInvocation_in_suffix656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleVariableAccess_in_suffix667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_constructorInvocation690 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_constructorInvocation694 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_arguments_in_constructorInvocation698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_simpleInvocation725 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_arguments_in_simpleInvocation729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_simpleVariableAccess761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_arguments784 = new BitSet(new long[]{0x0000000220000010L});
    public static final BitSet FOLLOW_expression_in_arguments796 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_arguments807 = new BitSet(new long[]{0x0000000200000010L});
    public static final BitSet FOLLOW_expression_in_arguments811 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29_in_arguments825 = new BitSet(new long[]{0x0000000000000002L});

}
