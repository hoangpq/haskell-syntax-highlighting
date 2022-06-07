// This is a generated file. Not intended for manual editing.
package com.vampire.haskell.language.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.vampire.haskell.language.psi.HaskellTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.vampire.haskell.language.psi.*;

public class HaskellPragmaImpl extends ASTWrapperPsiElement implements HaskellPragma {

  public HaskellPragmaImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HaskellVisitor visitor) {
    visitor.visitPragma(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HaskellVisitor) accept((HaskellVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<HaskellGeneralPragmaContent> getGeneralPragmaContentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellGeneralPragmaContent.class);
  }

}
