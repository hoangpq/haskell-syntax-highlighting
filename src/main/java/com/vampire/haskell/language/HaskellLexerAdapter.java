package com.vampire.haskell.language;

import com.intellij.lexer.FlexAdapter;

public class HaskellLexerAdapter extends FlexAdapter {

    public HaskellLexerAdapter() {
        super(new _HaskellLexer(null));
    }

}