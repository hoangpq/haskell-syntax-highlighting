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

public class HaskellQVarConImpl extends ASTWrapperPsiElement implements HaskellQVarCon {

  public HaskellQVarConImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HaskellVisitor visitor) {
    visitor.visitQVarCon(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HaskellVisitor) accept((HaskellVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HaskellConsym getConsym() {
    return findChildByClass(HaskellConsym.class);
  }

  @Override
  @Nullable
  public HaskellQCon getQCon() {
    return findChildByClass(HaskellQCon.class);
  }

  @Override
  @Nullable
  public HaskellQualifier getQualifier() {
    return findChildByClass(HaskellQualifier.class);
  }

  @Override
  @Nullable
  public HaskellVarid getVarid() {
    return findChildByClass(HaskellVarid.class);
  }

  @Override
  @Nullable
  public HaskellVarsym getVarsym() {
    return findChildByClass(HaskellVarsym.class);
  }

}
