// This is a generated file. Not intended for manual editing.
package com.vampire.haskell.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellConstr1 extends PsiElement {

  @NotNull
  List<HaskellFielddecl> getFielddeclList();

  @NotNull
  List<HaskellPragma> getPragmaList();

  @Nullable
  HaskellQName getQName();

}
