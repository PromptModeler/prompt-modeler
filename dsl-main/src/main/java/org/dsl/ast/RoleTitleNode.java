package org.dsl.ast;

import org.dsl.util.RoleTitleType;
import org.dsl.visitor.Render;
import org.jspecify.annotations.NonNull;

public final class RoleTitleNode implements Node {

  private final RoleTitleType roleTitle;

  public RoleTitleNode(@NonNull final RoleTitleType roleTitle) {
    this.roleTitle = roleTitle;
  }

  public RoleTitleType getRoleTitle() {
    return roleTitle;
  }

  @Override
  public <R> R accept(@NonNull final Render<R> render) {
    render.visit(this);
    return render.getResult();
  }
}
