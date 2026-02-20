package org.dsl.action;

import org.dsl.operator.LogicalOperator;

public sealed interface ActionEnd extends LogicalOperator<ActionStart> permits ActionBuilder {

  void endAction();

}
