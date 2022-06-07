package com.vampire.haskell.language.psi;

import com.intellij.psi.tree.IElementType;
import com.vampire.haskell.language.HaskellLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class HaskellTokenType extends IElementType {

    public HaskellTokenType(@NotNull @NonNls String debugName) {
        super(debugName, HaskellLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "HaskellTokenType." + super.toString();
    }

}