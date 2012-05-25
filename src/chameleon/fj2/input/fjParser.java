// $ANTLR 3.3 Nov 30, 2010 12:45:30 /Users/marko/git/fj/src/chameleon/fj2/input/fj.g 2012-05-25 19:48:42

package chameleon.fj2.input;

import java.util.*;

import chameleon.fj2.model.*;
import chameleon.core.namespacedeclaration.*;
import chameleon.core.document.*;
import chameleon.support.input.ChameleonParser;

import chameleon.core.reference.*;

import org.antlr.runtime.BitSet;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class fjParser extends ChameleonParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "HexDigit", "IntegerTypeSuffix", "HexLiteral", "DecimalLiteral", "OctalLiteral", "Exponent", "FloatTypeSuffix", "FloatingPointLiteral", "EscapeSequence", "CharacterLiteral", "StringLiteral", "UnicodeEscape", "OctalEscape", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'class'", "'{'", "'}'", "'('", "','", "')'", "'='", "';'", "'.'", "'new'"
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
    public String getGrammarFileName() { return "/Users/marko/git/fj/src/chameleon/fj2/input/fj.g"; }


    public static class compilationUnit_return extends ParserRuleReturnScope {
        public Document element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compilationUnit"
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:29:1: compilationUnit returns [Document element] : (kl= klazz )* ;
    public final fjParser.compilationUnit_return compilationUnit() throws RecognitionException {
        fjParser.compilationUnit_return retval = new fjParser.compilationUnit_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        fjParser.klazz_return kl = null;



         
          retval.element = getDocument();
          NamespaceDeclaration npp = new NamespaceDeclaration(language().defaultNamespace());
          retval.element.add(npp);

        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:35:3: ( (kl= klazz )* )
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:35:5: (kl= klazz )*
            {
            root_0 = (Object)adaptor.nil();

            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:35:5: (kl= klazz )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==23) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:35:6: kl= klazz
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

    public static class klazz_return extends ParserRuleReturnScope {
        public Klazz element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "klazz"
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:38:1: klazz returns [Klazz element] : 'class' n= Identifier '{' cs= constructor (m= member )* '}' ;
    public final fjParser.klazz_return klazz() throws RecognitionException {
        fjParser.klazz_return retval = new fjParser.klazz_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token string_literal1=null;
        Token char_literal2=null;
        Token char_literal3=null;
        fjParser.constructor_return cs = null;

        fjParser.member_return m = null;


        Object n_tree=null;
        Object string_literal1_tree=null;
        Object char_literal2_tree=null;
        Object char_literal3_tree=null;

        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:40:3: ( 'class' n= Identifier '{' cs= constructor (m= member )* '}' )
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:40:5: 'class' n= Identifier '{' cs= constructor (m= member )* '}'
            {
            root_0 = (Object)adaptor.nil();

            string_literal1=(Token)match(input,23,FOLLOW_23_in_klazz87); 
            string_literal1_tree = (Object)adaptor.create(string_literal1);
            adaptor.addChild(root_0, string_literal1_tree);

            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_klazz91); 
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);

            char_literal2=(Token)match(input,24,FOLLOW_24_in_klazz93); 
            char_literal2_tree = (Object)adaptor.create(char_literal2);
            adaptor.addChild(root_0, char_literal2_tree);

            retval.element = new Klazz((n!=null?n.getText():null));
            pushFollow(FOLLOW_constructor_in_klazz106);
            cs=constructor();

            state._fsp--;

            adaptor.addChild(root_0, cs.getTree());
            retval.element.addDeclaration(cs.element);
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:42:8: (m= member )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Identifier) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:42:9: m= member
            	    {
            	    pushFollow(FOLLOW_member_in_klazz120);
            	    m=member();

            	    state._fsp--;

            	    adaptor.addChild(root_0, m.getTree());
            	    retval.element.addDeclaration(m.element);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            char_literal3=(Token)match(input,25,FOLLOW_25_in_klazz132); 
            char_literal3_tree = (Object)adaptor.create(char_literal3);
            adaptor.addChild(root_0, char_literal3_tree);


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
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:47:1: constructor returns [Constructor element] : n= Identifier p= parameterList '{' (a= assignment )* '}' ;
    public final fjParser.constructor_return constructor() throws RecognitionException {
        fjParser.constructor_return retval = new fjParser.constructor_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token char_literal4=null;
        Token char_literal5=null;
        fjParser.parameterList_return p = null;

        fjParser.assignment_return a = null;


        Object n_tree=null;
        Object char_literal4_tree=null;
        Object char_literal5_tree=null;

        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:49:3: (n= Identifier p= parameterList '{' (a= assignment )* '}' )
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:49:5: n= Identifier p= parameterList '{' (a= assignment )* '}'
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_constructor156); 
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);

            retval.element = new Constructor((n!=null?n.getText():null));
            pushFollow(FOLLOW_parameterList_in_constructor166);
            p=parameterList();

            state._fsp--;

            adaptor.addChild(root_0, p.getTree());
            for(Parameter par: (p!=null?p.element:null)) {retval.element.addDeclaration(par);}
            char_literal4=(Token)match(input,24,FOLLOW_24_in_constructor174); 
            char_literal4_tree = (Object)adaptor.create(char_literal4);
            adaptor.addChild(root_0, char_literal4_tree);

            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:52:6: (a= assignment )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Identifier) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:52:7: a= assignment
            	    {
            	    pushFollow(FOLLOW_assignment_in_constructor184);
            	    a=assignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, a.getTree());
            	    retval.element.add((a!=null?a.element:null));

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            char_literal5=(Token)match(input,25,FOLLOW_25_in_constructor194); 
            char_literal5_tree = (Object)adaptor.create(char_literal5);
            adaptor.addChild(root_0, char_literal5_tree);


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
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:56:3: parameterList returns [List<Parameter> element] : '(' (e= parameter ( ',' ee= parameter )* )? ')' ;
    public final fjParser.parameterList_return parameterList() throws RecognitionException {
        fjParser.parameterList_return retval = new fjParser.parameterList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal6=null;
        Token char_literal7=null;
        Token char_literal8=null;
        fjParser.parameter_return e = null;

        fjParser.parameter_return ee = null;


        Object char_literal6_tree=null;
        Object char_literal7_tree=null;
        Object char_literal8_tree=null;

        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:57:3: ( '(' (e= parameter ( ',' ee= parameter )* )? ')' )
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:57:5: '(' (e= parameter ( ',' ee= parameter )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal6=(Token)match(input,26,FOLLOW_26_in_parameterList215); 
            char_literal6_tree = (Object)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);

            retval.element = new ArrayList<Parameter>();
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:58:6: (e= parameter ( ',' ee= parameter )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Identifier) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:58:7: e= parameter ( ',' ee= parameter )*
                    {
                    pushFollow(FOLLOW_parameter_in_parameterList227);
                    e=parameter();

                    state._fsp--;

                    adaptor.addChild(root_0, e.getTree());
                    retval.element.add((e!=null?e.element:null));
                    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:59:6: ( ',' ee= parameter )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==27) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:59:7: ',' ee= parameter
                    	    {
                    	    char_literal7=(Token)match(input,27,FOLLOW_27_in_parameterList237); 
                    	    char_literal7_tree = (Object)adaptor.create(char_literal7);
                    	    adaptor.addChild(root_0, char_literal7_tree);

                    	    pushFollow(FOLLOW_parameter_in_parameterList241);
                    	    ee=parameter();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, ee.getTree());
                    	    retval.element.add((ee!=null?ee.element:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal8=(Token)match(input,28,FOLLOW_28_in_parameterList254); 
            char_literal8_tree = (Object)adaptor.create(char_literal8);
            adaptor.addChild(root_0, char_literal8_tree);


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
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:63:1: parameter returns [Parameter element] : t= Identifier n= Identifier ;
    public final fjParser.parameter_return parameter() throws RecognitionException {
        fjParser.parameter_return retval = new fjParser.parameter_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token t=null;
        Token n=null;

        Object t_tree=null;
        Object n_tree=null;

        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:64:3: (t= Identifier n= Identifier )
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:64:5: t= Identifier n= Identifier
            {
            root_0 = (Object)adaptor.nil();

            t=(Token)match(input,Identifier,FOLLOW_Identifier_in_parameter273); 
            t_tree = (Object)adaptor.create(t);
            adaptor.addChild(root_0, t_tree);

            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_parameter277); 
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);

            retval.element = new Parameter((n!=null?n.getText():null));retval.element.setTypeReference(new SimpleReference<Klazz>((t!=null?t.getText():null),Klazz.class));

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
    // $ANTLR end "parameter"

    public static class assignment_return extends ParserRuleReturnScope {
        public Assignment element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:68:1: assignment returns [Assignment element] : id= Identifier '=' e= expression ';' ;
    public final fjParser.assignment_return assignment() throws RecognitionException {
        fjParser.assignment_return retval = new fjParser.assignment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;
        Token char_literal9=null;
        Token char_literal10=null;
        fjParser.expression_return e = null;


        Object id_tree=null;
        Object char_literal9_tree=null;
        Object char_literal10_tree=null;

        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:69:3: (id= Identifier '=' e= expression ';' )
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:69:5: id= Identifier '=' e= expression ';'
            {
            root_0 = (Object)adaptor.nil();

            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_assignment301); 
            id_tree = (Object)adaptor.create(id);
            adaptor.addChild(root_0, id_tree);

            char_literal9=(Token)match(input,29,FOLLOW_29_in_assignment303); 
            char_literal9_tree = (Object)adaptor.create(char_literal9);
            adaptor.addChild(root_0, char_literal9_tree);

            pushFollow(FOLLOW_expression_in_assignment307);
            e=expression();

            state._fsp--;

            adaptor.addChild(root_0, e.getTree());
            char_literal10=(Token)match(input,30,FOLLOW_30_in_assignment309); 
            char_literal10_tree = (Object)adaptor.create(char_literal10);
            adaptor.addChild(root_0, char_literal10_tree);

            retval.element = new Assignment();
                 retval.element.setValue((e!=null?e.element:null));
                 retval.element.setName((id!=null?id.getText():null));
                

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
    // $ANTLR end "assignment"

    public static class member_return extends ParserRuleReturnScope {
        public Member element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "member"
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:76:1: member returns [Member element] : (m= method | f= field );
    public final fjParser.member_return member() throws RecognitionException {
        fjParser.member_return retval = new fjParser.member_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        fjParser.method_return m = null;

        fjParser.field_return f = null;



        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:78:3: (m= method | f= field )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Identifier) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==Identifier) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==30) ) {
                        alt6=2;
                    }
                    else if ( (LA6_2==26) ) {
                        alt6=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:78:5: m= method
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_method_in_member341);
                    m=method();

                    state._fsp--;

                    adaptor.addChild(root_0, m.getTree());
                    retval.element =m.element;

                    }
                    break;
                case 2 :
                    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:79:5: f= field
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_field_in_member351);
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
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:82:1: method returns [Method element] : r= Identifier n= Identifier p= parameterList '{' e= expression '}' ;
    public final fjParser.method_return method() throws RecognitionException {
        fjParser.method_return retval = new fjParser.method_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token r=null;
        Token n=null;
        Token char_literal11=null;
        Token char_literal12=null;
        fjParser.parameterList_return p = null;

        fjParser.expression_return e = null;


        Object r_tree=null;
        Object n_tree=null;
        Object char_literal11_tree=null;
        Object char_literal12_tree=null;

        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:83:3: (r= Identifier n= Identifier p= parameterList '{' e= expression '}' )
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:83:5: r= Identifier n= Identifier p= parameterList '{' e= expression '}'
            {
            root_0 = (Object)adaptor.nil();

            r=(Token)match(input,Identifier,FOLLOW_Identifier_in_method376); 
            r_tree = (Object)adaptor.create(r);
            adaptor.addChild(root_0, r_tree);

            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_method380); 
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);

            retval.element = new Method((n!=null?n.getText():null)); retval.element.setReturnTypeReference(new SimpleReference<Klazz>((r!=null?r.getText():null),Klazz.class));
            pushFollow(FOLLOW_parameterList_in_method397);
            p=parameterList();

            state._fsp--;

            adaptor.addChild(root_0, p.getTree());
            for(Parameter par: (p!=null?p.element:null)) {retval.element.addDeclaration(par);}
            char_literal11=(Token)match(input,24,FOLLOW_24_in_method405); 
            char_literal11_tree = (Object)adaptor.create(char_literal11);
            adaptor.addChild(root_0, char_literal11_tree);

            pushFollow(FOLLOW_expression_in_method415);
            e=expression();

            state._fsp--;

            adaptor.addChild(root_0, e.getTree());
            retval.element.setExpression((e!=null?e.element:null));
            char_literal12=(Token)match(input,25,FOLLOW_25_in_method423); 
            char_literal12_tree = (Object)adaptor.create(char_literal12);
            adaptor.addChild(root_0, char_literal12_tree);


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
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:92:1: field returns [Field element] : t= Identifier n= Identifier ';' ;
    public final fjParser.field_return field() throws RecognitionException {
        fjParser.field_return retval = new fjParser.field_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token t=null;
        Token n=null;
        Token char_literal13=null;

        Object t_tree=null;
        Object n_tree=null;
        Object char_literal13_tree=null;

        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:93:3: (t= Identifier n= Identifier ';' )
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:93:5: t= Identifier n= Identifier ';'
            {
            root_0 = (Object)adaptor.nil();

            t=(Token)match(input,Identifier,FOLLOW_Identifier_in_field447); 
            t_tree = (Object)adaptor.create(t);
            adaptor.addChild(root_0, t_tree);

            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_field451); 
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);

            char_literal13=(Token)match(input,30,FOLLOW_30_in_field453); 
            char_literal13_tree = (Object)adaptor.create(char_literal13);
            adaptor.addChild(root_0, char_literal13_tree);

            retval.element = new Field((n!=null?n.getText():null)); retval.element.setTypeReference(new SimpleReference<Klazz>((t!=null?t.getText():null),Klazz.class));

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
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:97:1: expression returns [Expression element] : s= simple ( '.' ss= suffix[$element] )* ;
    public final fjParser.expression_return expression() throws RecognitionException {
        fjParser.expression_return retval = new fjParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal14=null;
        fjParser.simple_return s = null;

        fjParser.suffix_return ss = null;


        Object char_literal14_tree=null;

        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:98:3: (s= simple ( '.' ss= suffix[$element] )* )
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:98:5: s= simple ( '.' ss= suffix[$element] )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_simple_in_expression478);
            s=simple();

            state._fsp--;

            adaptor.addChild(root_0, s.getTree());
            retval.element = (s!=null?s.element:null);
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:99:7: ( '.' ss= suffix[$element] )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==31) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:99:8: '.' ss= suffix[$element]
            	    {
            	    char_literal14=(Token)match(input,31,FOLLOW_31_in_expression490); 
            	    char_literal14_tree = (Object)adaptor.create(char_literal14);
            	    adaptor.addChild(root_0, char_literal14_tree);

            	    pushFollow(FOLLOW_suffix_in_expression494);
            	    ss=suffix(retval.element);

            	    state._fsp--;

            	    adaptor.addChild(root_0, ss.getTree());
            	    retval.element = (ss!=null?ss.element:null);

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "expression"

    public static class simple_return extends ParserRuleReturnScope {
        public Expression element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simple"
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:102:1: simple returns [Expression element] : (ci= constructorInvocation | mi= simpleInvocation | va= simpleVariableAccess );
    public final fjParser.simple_return simple() throws RecognitionException {
        fjParser.simple_return retval = new fjParser.simple_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        fjParser.constructorInvocation_return ci = null;

        fjParser.simpleInvocation_return mi = null;

        fjParser.simpleVariableAccess_return va = null;



        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:104:3: (ci= constructorInvocation | mi= simpleInvocation | va= simpleVariableAccess )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==32) ) {
                alt8=1;
            }
            else if ( (LA8_0==Identifier) ) {
                int LA8_2 = input.LA(2);

                if ( (LA8_2==26) ) {
                    alt8=2;
                }
                else if ( (LA8_2==25||(LA8_2>=27 && LA8_2<=28)||(LA8_2>=30 && LA8_2<=31)) ) {
                    alt8=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:104:5: ci= constructorInvocation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constructorInvocation_in_simple526);
                    ci=constructorInvocation();

                    state._fsp--;

                    adaptor.addChild(root_0, ci.getTree());
                    retval.element =(ci!=null?ci.element:null);

                    }
                    break;
                case 2 :
                    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:105:5: mi= simpleInvocation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_simpleInvocation_in_simple536);
                    mi=simpleInvocation();

                    state._fsp--;

                    adaptor.addChild(root_0, mi.getTree());
                    retval.element =(mi!=null?mi.element:null);

                    }
                    break;
                case 3 :
                    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:106:5: va= simpleVariableAccess
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_simpleVariableAccess_in_simple546);
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
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:109:1: suffix[Expression expr] returns [Expression element] : (mi= simpleInvocation | va= simpleVariableAccess );
    public final fjParser.suffix_return suffix(Expression expr) throws RecognitionException {
        fjParser.suffix_return retval = new fjParser.suffix_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        fjParser.simpleInvocation_return mi = null;

        fjParser.simpleVariableAccess_return va = null;



        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:111:2: (mi= simpleInvocation | va= simpleVariableAccess )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Identifier) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==26) ) {
                    alt9=1;
                }
                else if ( (LA9_1==25||(LA9_1>=27 && LA9_1<=28)||(LA9_1>=30 && LA9_1<=31)) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

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
                    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:111:4: mi= simpleInvocation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_simpleInvocation_in_suffix575);
                    mi=simpleInvocation();

                    state._fsp--;

                    adaptor.addChild(root_0, mi.getTree());
                    retval.element =(mi!=null?mi.element:null); ((MethodInvocation)retval.element).setTarget(expr);

                    }
                    break;
                case 2 :
                    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:112:6: va= simpleVariableAccess
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_simpleVariableAccess_in_suffix586);
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
    // $ANTLR end "suffix"

    public static class constructorInvocation_return extends ParserRuleReturnScope {
        public ConstructorInvocation element;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constructorInvocation"
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:115:1: constructorInvocation returns [ConstructorInvocation element] : 'new' n= Identifier args= arguments ;
    public final fjParser.constructorInvocation_return constructorInvocation() throws RecognitionException {
        fjParser.constructorInvocation_return retval = new fjParser.constructorInvocation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        Token string_literal15=null;
        fjParser.arguments_return args = null;


        Object n_tree=null;
        Object string_literal15_tree=null;

        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:116:3: ( 'new' n= Identifier args= arguments )
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:116:5: 'new' n= Identifier args= arguments
            {
            root_0 = (Object)adaptor.nil();

            string_literal15=(Token)match(input,32,FOLLOW_32_in_constructorInvocation607); 
            string_literal15_tree = (Object)adaptor.create(string_literal15);
            adaptor.addChild(root_0, string_literal15_tree);

            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_constructorInvocation611); 
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);

            pushFollow(FOLLOW_arguments_in_constructorInvocation615);
            args=arguments();

            state._fsp--;

            adaptor.addChild(root_0, args.getTree());
            retval.element = new ConstructorInvocation((n!=null?n.getText():null));
                  for(Expression e: (args!=null?args.element:null)) {retval.element.add(e);}
                 

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
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:122:1: simpleInvocation returns [MethodInvocation element] : n= Identifier args= arguments ;
    public final fjParser.simpleInvocation_return simpleInvocation() throws RecognitionException {
        fjParser.simpleInvocation_return retval = new fjParser.simpleInvocation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;
        fjParser.arguments_return args = null;


        Object n_tree=null;

        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:123:3: (n= Identifier args= arguments )
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:123:5: n= Identifier args= arguments
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_simpleInvocation642); 
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);

            pushFollow(FOLLOW_arguments_in_simpleInvocation646);
            args=arguments();

            state._fsp--;

            adaptor.addChild(root_0, args.getTree());
            retval.element = new MethodInvocation((n!=null?n.getText():null));
                  for(Expression e: (args!=null?args.element:null)) 
                    {retval.element.add(e);}
                 

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
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:130:1: simpleVariableAccess returns [VariableAccess element] : n= Identifier ;
    public final fjParser.simpleVariableAccess_return simpleVariableAccess() throws RecognitionException {
        fjParser.simpleVariableAccess_return retval = new fjParser.simpleVariableAccess_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token n=null;

        Object n_tree=null;

        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:131:3: (n= Identifier )
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:131:5: n= Identifier
            {
            root_0 = (Object)adaptor.nil();

            n=(Token)match(input,Identifier,FOLLOW_Identifier_in_simpleVariableAccess678); 
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
    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:133:1: arguments returns [List<Expression> element] : '(' (e= expression ( ',' ee= expression )* )? ')' ;
    public final fjParser.arguments_return arguments() throws RecognitionException {
        fjParser.arguments_return retval = new fjParser.arguments_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal16=null;
        Token char_literal17=null;
        Token char_literal18=null;
        fjParser.expression_return e = null;

        fjParser.expression_return ee = null;


        Object char_literal16_tree=null;
        Object char_literal17_tree=null;
        Object char_literal18_tree=null;

        try {
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:134:3: ( '(' (e= expression ( ',' ee= expression )* )? ')' )
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:134:5: '(' (e= expression ( ',' ee= expression )* )? ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal16=(Token)match(input,26,FOLLOW_26_in_arguments701); 
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);

            retval.element = new ArrayList<Expression>();
            // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:135:6: (e= expression ( ',' ee= expression )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Identifier||LA11_0==32) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:135:7: e= expression ( ',' ee= expression )*
                    {
                    pushFollow(FOLLOW_expression_in_arguments713);
                    e=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, e.getTree());
                    retval.element.add((e!=null?e.element:null));
                    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:136:6: ( ',' ee= expression )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==27) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /Users/marko/git/fj/src/chameleon/fj2/input/fj.g:136:8: ',' ee= expression
                    	    {
                    	    char_literal17=(Token)match(input,27,FOLLOW_27_in_arguments724); 
                    	    char_literal17_tree = (Object)adaptor.create(char_literal17);
                    	    adaptor.addChild(root_0, char_literal17_tree);

                    	    pushFollow(FOLLOW_expression_in_arguments728);
                    	    ee=expression();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, ee.getTree());
                    	    retval.element.add((ee!=null?ee.element:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal18=(Token)match(input,28,FOLLOW_28_in_arguments742); 
            char_literal18_tree = (Object)adaptor.create(char_literal18);
            adaptor.addChild(root_0, char_literal18_tree);


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
    public static final BitSet FOLLOW_23_in_klazz87 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_klazz91 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_klazz93 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_constructor_in_klazz106 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_member_in_klazz120 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_25_in_klazz132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_constructor156 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_parameterList_in_constructor166 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_constructor174 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_assignment_in_constructor184 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_25_in_constructor194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_parameterList215 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_parameter_in_parameterList227 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_parameterList237 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parameter_in_parameterList241 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_parameterList254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_parameter273 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_parameter277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_assignment301 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_assignment303 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_expression_in_assignment307 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_assignment309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_member341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_in_member351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_method376 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_method380 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_parameterList_in_method397 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_method405 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_expression_in_method415 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_method423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_field447 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_field451 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_field453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_in_expression478 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_expression490 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_suffix_in_expression494 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_constructorInvocation_in_simple526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleInvocation_in_simple536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleVariableAccess_in_simple546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleInvocation_in_suffix575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleVariableAccess_in_suffix586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_constructorInvocation607 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_constructorInvocation611 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_arguments_in_constructorInvocation615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_simpleInvocation642 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_arguments_in_simpleInvocation646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_simpleVariableAccess678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_arguments701 = new BitSet(new long[]{0x0000000110000010L});
    public static final BitSet FOLLOW_expression_in_arguments713 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_27_in_arguments724 = new BitSet(new long[]{0x0000000100000010L});
    public static final BitSet FOLLOW_expression_in_arguments728 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_arguments742 = new BitSet(new long[]{0x0000000000000002L});

}