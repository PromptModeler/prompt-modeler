package org.dsl.action;

import org.jspecify.annotations.NonNull;

public sealed interface ActionStart permits ActionBuilder {

  ActionEnd action(@NonNull final String modality, @NonNull final String action);

}
