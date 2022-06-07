package com.vampire.haskell.language;

import com.intellij.lang.Language;

public class HaskellLanguage extends Language {

    public static final HaskellLanguage INSTANCE = new HaskellLanguage();

    private HaskellLanguage() {
        super("HaskellLanguage");
    }

}
