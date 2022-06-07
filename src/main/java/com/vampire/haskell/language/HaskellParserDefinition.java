package com.vampire.haskell.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.vampire.haskell.language.parser.HaskellParser;
import com.vampire.haskell.language.psi.HaskellFile;
import com.vampire.haskell.language.psi.HaskellTypes;
import org.jetbrains.annotations.NotNull;

public class HaskellParserDefinition implements ParserDefinition {

    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(
        HaskellTypes.HS_COMMENT, HaskellTypes.HS_NCOMMENT, HaskellTypes.HS_HADDOCK, HaskellTypes.HS_NHADDOCK
    );
    public static final TokenSet PRAGMASTARTENDIDS = TokenSet.create(
        HaskellTypes.HS_PRAGMA_START, HaskellTypes.HS_PRAGMA_END
    );
    public static final TokenSet RESERVEDIDS = TokenSet.create(
        HaskellTypes.HS_CASE, HaskellTypes.HS_CLASS, HaskellTypes.HS_DATA,
        HaskellTypes.HS_DEFAULT, HaskellTypes.HS_DERIVING, HaskellTypes.HS_DO,
        HaskellTypes.HS_ELSE, HaskellTypes.HS_IF, HaskellTypes.HS_IMPORT,
        HaskellTypes.HS_IN, HaskellTypes.HS_INFIX, HaskellTypes.HS_INFIXL,
        HaskellTypes.HS_INFIXR, HaskellTypes.HS_INSTANCE, HaskellTypes.HS_LET,
        HaskellTypes.HS_MODULE, HaskellTypes.HS_NEWTYPE, HaskellTypes.HS_OF,
        HaskellTypes.HS_THEN, HaskellTypes.HS_TYPE, HaskellTypes.HS_WHERE, HaskellTypes.HS_UNDERSCORE
    );
    public static final TokenSet SPECIALRESERVEDIDS = TokenSet.create(
        HaskellTypes.HS_TYPE_FAMILY, HaskellTypes.HS_FOREIGN_IMPORT, HaskellTypes.HS_FOREIGN_EXPORT,
        HaskellTypes.HS_TYPE_INSTANCE
    );
    public static final TokenSet ALLRESERVEDIDS = TokenSet.orSet(RESERVEDIDS, SPECIALRESERVEDIDS);
    public static final TokenSet RESERVEDOPERATORS = TokenSet.create(
        HaskellTypes.HS_COLON_COLON, HaskellTypes.HS_EQUAL, HaskellTypes.HS_BACKSLASH,
        HaskellTypes.HS_VERTICAL_BAR, HaskellTypes.HS_LEFT_ARROW,
        HaskellTypes.HS_RIGHT_ARROW, HaskellTypes.HS_AT, HaskellTypes.HS_TILDE,
        HaskellTypes.HS_DOUBLE_RIGHT_ARROW, HaskellTypes.HS_DOT_DOT
    );
    public static final TokenSet OPERATORS = TokenSet.orSet(
        RESERVEDOPERATORS,
        TokenSet.create(
            HaskellTypes.HS_VARSYM_ID,
            HaskellTypes.HS_CONSYM_ID
        ),
        TokenSet.create(HaskellTypes.HS_DOT)
    );
    public static final TokenSet NUMBERLITERALS = TokenSet.create(
        HaskellTypes.HS_DECIMAL,
        HaskellTypes.HS_FLOAT,
        HaskellTypes.HS_HEXADECIMAL,
        HaskellTypes.HS_OCTAL
    );
    public static final TokenSet SYMBOLSRESOP = TokenSet.create(
        HaskellTypes.HS_EQUAL,
        HaskellTypes.HS_AT,
        HaskellTypes.HS_BACKSLASH,
        HaskellTypes.HS_VERTICAL_BAR,
        HaskellTypes.HS_TILDE
    );
    public static final TokenSet STRINGLITERALS = TokenSet.create(
        HaskellTypes.HS_CHARACTER_LITERAL,
        HaskellTypes.HS_STRING_LITERAL
    );
    public static final TokenSet LITERALS = TokenSet.orSet(
        STRINGLITERALS,
        NUMBERLITERALS,
        TokenSet.create(HaskellTypes.HS_QUASIQUOTE)
    );
    public static final TokenSet IDS = TokenSet.create(
        HaskellTypes.HS_VAR_ID,
        HaskellTypes.HS_CON_ID,
        HaskellTypes.HS_VARSYM_ID,
        HaskellTypes.HS_CONSYM_ID
    );

    public static final IFileElementType FILE = new IFileElementType(HaskellLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new HaskellLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new HaskellParser();
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new HaskellFile(viewProvider);
    }

    @Override
    public @NotNull SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return HaskellTypes.Factory.createElement(node);
    }

}
