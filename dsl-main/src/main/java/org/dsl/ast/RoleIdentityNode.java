package org.dsl.ast;

import org.dsl.visitor.Render;
import org.jspecify.annotations.NonNull;

public final class RoleIdentityNode implements Node {

  private final String roleIdentity;

  public RoleIdentityNode(@NonNull final String roleIdentity) {
    this.roleIdentity = roleIdentity;
  }

  public String getRoleIdentity() {
    return roleIdentity;
  }

  @Override
  public <R> R accept(@NonNull final Render<R> render) {
    render.visit(this);
    return render.getResult();
  }
}
