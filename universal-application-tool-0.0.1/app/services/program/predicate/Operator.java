package services.program.predicate;

import com.google.common.collect.ImmutableSet;
import services.question.types.ScalarType;

/** Represents a JsonPath operator (https://github.com/json-path/JsonPath#filter-operators). */
public enum Operator {
  ANY_OF(
      "anyof",
      "contains any of",
      ImmutableSet.of(ScalarType.LIST_OF_STRINGS),
      OperatorValue.STRING),
  EQUAL_TO(
      "==",
      "is equal to",
      ImmutableSet.of(ScalarType.LONG, ScalarType.STRING),
      OperatorValue.DEPENDS_ON_SCALAR),
  GREATER_THAN(">", "is greater than", ImmutableSet.of(ScalarType.LONG), OperatorValue.NUMBER),
  GREATER_THAN_OR_EQUAL_TO(
      ">=", "is greater than or equal to", ImmutableSet.of(ScalarType.LONG), OperatorValue.NUMBER),
  IN("in", "is one of", ImmutableSet.of(ScalarType.STRING), OperatorValue.STRING),
  IS_AFTER(">=", "is later than", ImmutableSet.of(ScalarType.DATE), OperatorValue.DATE),
  IS_BEFORE("<=", "is earlier than", ImmutableSet.of(ScalarType.DATE), OperatorValue.DATE),
  LESS_THAN("<", "is less than", ImmutableSet.of(ScalarType.LONG), OperatorValue.NUMBER),
  LESS_THAN_OR_EQUAL_TO(
      "<=", "is less than or equal to", ImmutableSet.of(ScalarType.LONG), OperatorValue.NUMBER),
  NONE_OF(
      "noneof", "is none of", ImmutableSet.of(ScalarType.LIST_OF_STRINGS), OperatorValue.STRING),
  NOT_EQUAL_TO(
      "!=",
      "is not equal to",
      ImmutableSet.of(ScalarType.LONG, ScalarType.STRING),
      OperatorValue.DEPENDS_ON_SCALAR),
  NOT_IN("nin", "is not one of", ImmutableSet.of(ScalarType.STRING), OperatorValue.STRING),
  SUBSET_OF(
      "subsetof",
      "is a subset of",
      ImmutableSet.of(ScalarType.LIST_OF_STRINGS),
      OperatorValue.STRING);

  private final String jsonPathOperator;
  private final String displayString;
  private final ImmutableSet<ScalarType> operableTypes;
  private final OperatorValue valueType;

  Operator(
      String jsonPathOperator,
      String displayString,
      ImmutableSet<ScalarType> operableTypes,
      OperatorValue valueType) {
    this.jsonPathOperator = jsonPathOperator;
    this.displayString = displayString;
    this.operableTypes = operableTypes;
    this.valueType = valueType;
  }

  public String toJsonPathOperator() {
    return this.jsonPathOperator;
  }

  public String toDisplayString() {
    return this.displayString;
  }

  /**
   * What type must the value on the left of the operator be? For example, "anyof" can only operate
   * on a list, since it compares "does X list contain any of the values in Y list?"
   */
  public ImmutableSet<ScalarType> getOperableTypes() {
    return this.operableTypes;
  }
}
