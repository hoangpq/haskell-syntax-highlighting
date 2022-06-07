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

public class HaskellQConImpl extends ASTWrapperPsiElement implements HaskellQCon {

  public HaskellQConImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HaskellVisitor visitor) {
    visitor.visitQCon(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HaskellVisitor) accept((HaskellVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public HaskellConid getConid() {
    return findNotNullChildByClass(HaskellConid.class);
  }

  @Override
  @Nullable
  public HaskellQConQualifier1 getQConQualifier1() {
    return findChildByClass(HaskellQConQualifier1.class);
  }

  @Override
  @Nullable
  public HaskellQConQualifier2 getQConQualifier2() {
    return findChildByClass(HaskellQConQualifier2.class);
  }

  @Override
  @Nullable
  public HaskellQConQualifier3 getQConQualifier3() {
    return findChildByClass(HaskellQConQualifier3.class);
  }

  @Override
  @Nullable
  public HaskellQConQualifier4 getQConQualifier4() {
    return findChildByClass(HaskellQConQualifier4.class);
  }

}
