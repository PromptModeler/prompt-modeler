package org.dsl.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.dsl.ast.ActionNode;
import org.dsl.operator.OperatorType;
import org.jspecify.annotations.NonNull;

public final class ActionBuilder implements ActionStart, ActionEnd {

  private final List<ActionNode> actionNodeList = new ArrayList<>();

  @Override
  public void endAction() {

  }

  @Override
  public ActionEnd action(@NonNull final String modality, @NonNull final String action) {
    actionNodeList.add(new ActionNode(modality, action, null));
    return this;
  }

  @Override
  public ActionStart and() {
    attachOperatorToPrevious(OperatorType.AND);
    return this;
  }

  @Override
  public ActionStart or() {
    attachOperatorToPrevious(OperatorType.OR);
    return this;
  }

  public List<ActionNode> build() {
    return Collections.unmodifiableList(actionNodeList);
  }

  private void attachOperatorToPrevious(@NonNull final OperatorType operatorType) {
    if(actionNodeList.isEmpty()) {
      throw new IllegalArgumentException("Cannot apply operator without a preceding action");
    }

    final int lastIndex = actionNodeList.size() - 1;
    final ActionNode previous = actionNodeList.get(lastIndex);

    actionNodeList.set(lastIndex, new ActionNode(previous.getModality(), previous.getAction(), previous.getOperator()));
  }
}
