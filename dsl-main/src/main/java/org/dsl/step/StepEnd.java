package org.dsl.step;

import org.dsl.operator.LogicalOperator;

public sealed interface StepEnd extends LogicalOperator<StepStart> permits StepBuilder {

  void endStep();

}
