/*
 * ==== This is part of the CMPT 355 reference solution for GP1 (lexical analyzer). ====
 * You are free to use this in all or in part in your solution for subsequent group projects, but please leave comments
 * saying what pieces you use to make Kathy's life easier.
 */
grammar Java;

// The characters that are valid in Java identifiers are a very long list, so keep them in a separate file
import JavaIdentifierCharacters;

test
    : (KEYWORD | IDENTIFIER | INT_LITERAL | LONG_LITERAL | DOUBLE_LITERAL | FLOAT_LITERAL | STRING_LITERAL
        | SEPARATOR | OPERATOR | BOOLEAN_LITERAL | NULL_LITERAL)*
    ;

/* ---- Lexer rules ---- */
KEYWORD
    // keywords
    : 'abstract' | 'assert'       | 'break'      | 'case'   | 'catch'      | 'class'     | 'const'    | 'continue'
    | 'default'  | 'do'           | 'else'       | 'enum'   | 'extends'    | 'final'     | 'finally'  | 'for'
    | 'goto'     | 'if'           | 'implements' | 'import' | 'instanceof' | 'interface' | 'native'   | 'new'
    | 'package'  | 'private'      | 'protected'  | 'public' | 'return'     | 'static'    | 'strictfp' | 'super'
    | 'switch'   | 'synchronized' | 'this'       | 'throw'  | 'throws'     | 'transient' | 'try'      | 'void'
    | 'volatile' | 'while'        | '_'
    // primitive types
    | 'byte'     | 'short'        | 'int'        | 'long'   | 'float'      | 'double'    | 'char'     | 'boolean'
    ;

BOOLEAN_LITERAL
    : 'true' | 'false'
    ;

NULL_LITERAL
    : 'null'
    ;

// The IDENTIFIER_PART/_START fragments are defined in JavaIdentifierCharacters.g4 due to length
IDENTIFIER
    : IDENTIFIER_START IDENTIFIER_PART*
    ;

// Numbers
/* Note that all of the numeric rules are complicated by the fact that Java allows underscores to be used arbitrarily
 * inside any numeric literal (except that there can't be an underscore before the first digit or after the last).
 * So we get lots of complicated rules like
 *     [0-9] ([0-9_]* [0-9])?
 * ...which boils down to "digits 0-9 and underscores, beginning and ending with a digit." The ? is necessary so that
 * a single digit is still accepted.
 */
fragment INTEGER
    // zero
    : '0'
    // decimal
    | [1-9] ([0-9_]* [1-9])?
    // hexadecimal
    | '0' [Xx] [0-9a-fA-F] ([0-9a-fA-F_]* [0-9a-fA-F])?
    // octal
    | '0' [0-7_]* [0-7]
    // binary
    | '0' [Bb] [01] ([01_]* [01])?
    ;

// All floating-point literals have an optional exponent on the end
fragment EXPONENT
    : [Ee] [+-]? [0-9] ([0-9_]* [0-9])?
    ;

fragment REAL
    // real number with at least one digit before the .
    : [0-9] ([0-9_]* [0-9])? '.' ([0-9] ([0-9_]* [0-9])?)? EXPONENT?
    // real number with at least one digit after the .
    | ([0-9] ([0-9_]* [0-9])?)? '.' [0-9] ([0-9_]* [0-9])? EXPONENT?
    // real number that has at least an exponent
    | ([0-9] ([0-9_]* [0-9])?)? EXPONENT
    ;

INT_LITERAL
    : INTEGER
    ;

LONG_LITERAL
    : INTEGER [Ll]
    ;

DOUBLE_LITERAL
    : REAL
    ;

FLOAT_LITERAL
    : (REAL | INTEGER) [Ff]
    ;

// Characters and strings
/* Note that this is *not* handling Unicode escape sequences correctly: they are supposed to be applied before the rest
 * of the lexer, so that e.g. '\u000a' should not be allowed because U+000A is the newline character (\n) which is not
 * allowed inside a character literal. Here, however, we treat them on the same level as all other escape sequences.
 */
fragment ESCAPE_SEQUENCE
    : '\\b' | '\\t' | '\\n' | '\\f' | '\\r' | '\\\'' | '\\"' | '\\\\'
    | '\\' [0-7]
    | '\\' [0-7] [0-7]
    | '\\' [0-3] [0-7] [0-7]
    | '\\u' [0-9a-fA-F] [0-9a-fA-F] [0-9a-fA-F] [0-9a-fA-F]
    ;

CHAR_LITERAL
    : '\'' ~['\\\r\t\n] '\''
    | '\'' ESCAPE_SEQUENCE '\''
    ;

STRING_LITERAL
    : '"' (~["\\\r\n] | ESCAPE_SEQUENCE)* '"'
    ;

// Comments and whitespace (skipped)
fragment LINE_COMMENT
    : '//' (~[\n])* '\n'
    ;

// A part of a block comment. Anything that is not a star, or is a star followed by something other than a /.
fragment BLOCK_COMMENT_PART
    : ~[*] | '*' ~[/]
    ;

fragment BLOCK_COMMENT
    : '/*' BLOCK_COMMENT_PART* '*/'
    ;

fragment DOCUMENTATION_COMMENT
    : '/**' BLOCK_COMMENT_PART* '*/'
    ;

COMMENT
    : (LINE_COMMENT | BLOCK_COMMENT | DOCUMENTATION_COMMENT) -> skip
    ;

SEPARATOR
    : '(' | ')'
    | '{' | '}'
    | '[' | ']'
    | ';' | ',' | '.'
    | '@'
    | '...'
    ;

OPERATOR
    : '='  | '+=' | '-=' | '*=' | '/=' | '%=' | '&=' | '|=' | '^=' | '<<=' | '>>=' | '>>>='
           | '+'  | '-'  | '*'  | '/'  | '%'  | '&'  | '|'  | '^'  | '<<'  | '>>'  | '>>>'
    | '==' | '!=' | '<'  | '>'  | '<=' | '>='
    | '&&' | '||'
    | '!'  | '~'  | '++' | '--'
    | '?'  | ':'
    | '->'
    ;

WHITESPACE
    : [ \t\n\r]+ -> skip
    ;
