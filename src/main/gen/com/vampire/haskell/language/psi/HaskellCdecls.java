// This is a generated file. Not intended for manual editing.
package com.vampire.haskell.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellCdecls extends PsiElement {

  @NotNull
  List<HaskellCdecl> getCdeclList();

  @NotNull
  List<HaskellPragma> getPragmaList();

}
