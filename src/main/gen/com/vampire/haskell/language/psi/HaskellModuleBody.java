// This is a generated file. Not intended for manual editing.
package com.vampire.haskell.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HaskellModuleBody extends PsiElement {

  @Nullable
  HaskellImportDeclarations getImportDeclarations();

  @Nullable
  HaskellModuleDeclaration getModuleDeclaration();

  @NotNull
  List<HaskellPragma> getPragmaList();

  @NotNull
  List<HaskellTopDeclaration> getTopDeclarationList();

}
