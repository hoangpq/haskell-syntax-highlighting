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

public class HaskellShebangLineImpl extends ASTWrapperPsiElement implements HaskellShebangLine {

  public HaskellShebangLineImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HaskellVisitor visitor) {
    visitor.visitShebangLine(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HaskellVisitor) accept((HaskellVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<HaskellDotDot> getDotDotList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellDotDot.class);
  }

  @Override
  @NotNull
  public List<HaskellPragma> getPragmaList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellPragma.class);
  }

  @Override
  @NotNull
  public List<HaskellQName> getQNameList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellQName.class);
  }

  @Override
  @NotNull
  public List<HaskellQuasiQuote> getQuasiQuoteList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellQuasiQuote.class);
  }

  @Override
  @NotNull
  public List<HaskellTextLiteral> getTextLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HaskellTextLiteral.class);
  }

}