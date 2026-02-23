package org.dsl.output.format.schema;

import org.dsl.output.format.SchemaType;
import org.jspecify.annotations.NonNull;

public enum JSONSchemaType implements SchemaType {
  JSON_BANK(
      """
        {
            "foo": ["bar", "baz"],
            "highly": {
               "nested": {
                  "objects": true
               }
            }
          }
      """
  );

  private final String schema;

  JSONSchemaType(@NonNull final String schema) {
    this.schema = schema;
  }

  @Override
  public String resolve() {
    return schema;
  }
}
