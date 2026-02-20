package org.dsl.strategy;

import org.dsl.operator.OperatorType;
import org.dsl.util.RoleTitleType;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public interface RenderingStrategy<R> {

  void roleTitle(@NonNull final RoleTitleType roleTitle);

  void roleIdentity(@NonNull final String roleIdentity);

  void action(@NonNull final String modality, @NonNull final String action, @Nullable final OperatorType operator);

  void context(@NonNull final String context, @Nullable final OperatorType operator);

  void step(@NonNull final String step, @Nullable final OperatorType operator);

  void outputFormat(@NonNull final String outputFormat);

  R result();

}
