package org.dsl.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.dsl.ast.ActionNode;
import org.dsl.operator.OperatorType;
import org.jspecify.annotations.NonNull;

public final class ActionBuilder implements ActionStart, ActionEnd {

  private final List<ActionNode> actionNodeList = new ArrayList<>();

  private OperatorType operator;

  @Override
  public void endAction() {

  }

  @Override
  public ActionEnd action(@NonNull final String modality, @NonNull final String action) {
    actionNodeList.add(new ActionNode(modality, action, operator));
    return this;
  }

  @Override
  public ActionStart and() {
    return this;
  }

  @Override
  public ActionStart or() {
    return this;
  }

  public List<ActionNode> build() {
    return Collections.unmodifiableList(actionNodeList);
  }
}
