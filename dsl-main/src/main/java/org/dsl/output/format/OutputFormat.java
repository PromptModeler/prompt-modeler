package org.dsl.output.format;

import org.dsl.output.format.schema.JSONSchemaType;
import org.dsl.output.format.schema.XMLSchemaType;
import org.jspecify.annotations.NonNull;

public final class OutputFormat<T extends SchemaType> {

  private final OutputFormatType type;
  private final T schema;

  public OutputFormat(@NonNull final OutputFormatType type, @NonNull final T schema) {
    this.type = type;
    this.schema = schema;
  }

  public static OutputFormat<JSONSchemaType> json(@NonNull final JSONSchemaType schema) {
    return new OutputFormat<>(OutputFormatType.JSON, schema);
  }

  public static OutputFormat<XMLSchemaType> xml(@NonNull final XMLSchemaType schema) {
    return new OutputFormat<>(OutputFormatType.XML, schema);
  }

  public String resolveSchema() {
    return schema.resolve();
  }

  public OutputFormatType getType() {
    return type;
  }

  public T getSchema() {
    return schema;
  }
}
