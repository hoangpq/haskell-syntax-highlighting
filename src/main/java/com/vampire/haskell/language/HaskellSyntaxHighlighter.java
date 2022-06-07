package com.vampire.haskell.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.vampire.haskell.language.psi.HaskellTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static com.vampire.haskell.language.HaskellParserDefinition.*;

public class HaskellSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey ILLEGAL = createTextAttributesKey("HS_ILLEGAL", DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("HS_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BLOCKCOMMENT = createTextAttributesKey("HS_NCOMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey DOCCOMMENT = createTextAttributesKey("HS_HADDOCK", DefaultLanguageHighlighterColors.DOC_COMMENT);
    public static final TextAttributesKey BLOCKDOCCOMMENT = createTextAttributesKey("HS_NHADDOCK", DefaultLanguageHighlighterColors.DOC_COMMENT);
    public static final TextAttributesKey STRING = createTextAttributesKey("HS_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("HS_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("HS_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey FUNCTIONNAME = createTextAttributesKey("HS_FUNCTION_NAME", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey PARENTHESES = createTextAttributesKey("HS_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey BRACE = createTextAttributesKey("HSL_BRACE", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey BRACKET = createTextAttributesKey("HS_BRACKET", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey VARIABLE = createTextAttributesKey("HS_VARIABLE", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey PRAGMACONTENT = createTextAttributesKey("HS_PRAGMA_CONTENT", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey CONSTRUCTOR = createTextAttributesKey("HS_CONSTRUCTOR", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey OPERATOR = createTextAttributesKey("HS_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey RESERVEDSYMBOL = createTextAttributesKey("HS_SYMBOL", DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL);
    public static final TextAttributesKey PRAGMA = createTextAttributesKey("HS_PRAGMA", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey QUASIQUOTE = createTextAttributesKey("HS_QUASI_QUOTES", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey DEFAULT = createTextAttributesKey("HS_DEFAULT", DefaultLanguageHighlighterColors.LOCAL_VARIABLE);

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new HaskellLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return pack(ILLEGAL);
        }

        if (PRAGMASTARTENDIDS.contains(tokenType)) {
            return pack(PRAGMA);
        }

        if (tokenType.equals(HaskellTypes.HS_COMMENT)) {
            return pack(COMMENT);
        }

        if (tokenType.equals(HaskellTypes.HS_HADDOCK) || tokenType.equals(HaskellTypes.HS_NHADDOCK)) {
            return pack(DOCCOMMENT);
        }

        if (tokenType.equals(HaskellTypes.HS_NCOMMENT)) {
            return pack(BLOCKCOMMENT);
        }

        if (tokenType.equals(HaskellTypes.HS_STRING_LITERAL) || tokenType.equals(HaskellTypes.HS_CHARACTER_LITERAL)) {
            return pack(STRING);
        }

        if (NUMBERLITERALS.contains(tokenType)) {
            return pack(NUMBER);
        }

        if (tokenType.equals(HaskellTypes.HS_LEFT_PAREN) || tokenType.equals(HaskellTypes.HS_RIGHT_PAREN)) {
            return pack(PARENTHESES);
        }

        if (tokenType.equals(HaskellTypes.HS_LEFT_BRACE) || tokenType.equals(HaskellTypes.HS_RIGHT_BRACE)) {
            return pack(BRACE);
        }

        if (tokenType.equals(HaskellTypes.HS_LEFT_BRACKET) || tokenType.equals(HaskellTypes.HS_RIGHT_BRACKET)) {
            return pack(BRACKET);
        }

        if (ALLRESERVEDIDS.contains(tokenType)) {
            return pack(KEYWORD);
        }

        if (SYMBOLSRESOP.contains(tokenType)) {
            return pack(RESERVEDSYMBOL);
        }

        if (OPERATORS.contains(tokenType)) {
            return pack(OPERATOR);
        }

        if (tokenType.equals(HaskellTypes.HS_VAR_ID)) {
            return pack(VARIABLE);
        }

        if (tokenType.equals(HaskellTypes.HS_CON_ID)) {
            return pack(CONSTRUCTOR);
        }

        if (tokenType.equals(HaskellTypes.HS_MODID)) {
            return pack(CONSTRUCTOR);
        }

        if (tokenType.equals(HaskellTypes.HS_QUASIQUOTE)) {
            return pack(QUASIQUOTE);
        }

        if (WHITE_SPACES.contains(tokenType) || tokenType == HaskellTypes.HS_NEWLINE) {
            return pack(null);
        }

        return pack(DEFAULT);
    }

}