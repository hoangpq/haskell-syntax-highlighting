// This is a generated file. Not intended for manual editing.
package com.vampire.haskell.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellTypeInstanceDeclaration extends PsiElement {

  @NotNull
  HaskellExpression getExpression();

  @NotNull
  List<HaskellPragma> getPragmaList();

}