package org.dsl.strategy;

import org.dsl.operator.OperatorType;
import org.dsl.util.RoleTitleType;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public final class StringRender implements RenderingStrategy<String> {

  private static final String LINE_BREAK = "\n";
  private static final String DELIMITER = ":";
  private static final String SPACE = " ";

  private final StringBuilder buffer = new StringBuilder();

  @Override
  public void roleTitle(@NonNull RoleTitleType roleTitle) {
    buffer.append(roleTitle).append(DELIMITER).append(SPACE);
  }

  @Override
  public void roleIdentity(@NonNull final String roleIdentity) {
    buffer.append(roleIdentity).append(LINE_BREAK);
  }

  @Override
  public void action(@NonNull final String modality, @NonNull final String action, @Nullable final OperatorType operator) {
    buffer.append(modality).append(SPACE).append(action);

    if(operator != null) {
      buffer.append(SPACE).append(operator.name());
    }
    buffer.append(LINE_BREAK);
  }

  @Override
  public void context(@NonNull final String context, @Nullable final OperatorType operator) {
    buffer.append(context).append(SPACE);

    if(operator != null) {
      buffer.append(SPACE).append(operator.name());
    }
    buffer.append(LINE_BREAK);
  }

  @Override
  public void step(@NonNull final String step, @Nullable final OperatorType operator) {
    buffer.append(step).append(SPACE);

    if(operator != null) {
      buffer.append(SPACE).append(operator.name());
    }
    buffer.append(LINE_BREAK);
  }

  @Override
  public void outputFormat(@NonNull final String outputFormat) {
    buffer.append(outputFormat).append(SPACE);
  }

  @Override
  public String result() {
    return buffer.toString();
  }
}
