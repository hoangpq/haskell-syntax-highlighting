// This is a generated file. Not intended for manual editing.
package com.vampire.haskell.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellCidecls extends PsiElement {

  @NotNull
  List<HaskellCidecl> getCideclList();

  @NotNull
  List<HaskellPragma> getPragmaList();

}
