// This is a generated file. Not intended for manual editing.
package com.vampire.haskell.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellDataDeclarationDeriving extends PsiElement {

  @NotNull
  List<HaskellPragma> getPragmaList();

  @NotNull
  List<HaskellTtype> getTtypeList();

}
