package org.dsl.output;

import org.dsl.Expression;
import org.dsl.operator.LogicalOperator;

public interface OutputFormatEnd extends LogicalOperator<OutputFormatStart> {

  Expression build();

}
