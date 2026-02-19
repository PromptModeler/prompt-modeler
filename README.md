# Prompt Modeling DSL

## Lexical Grammar

```bnf
  %lex
  %%
  
  \s+                         /* Skip WhiteSpace */
  \d+                         return 'NUMBER'
  
  "add"						            return 'ADD'
  "start"                     return 'START'
  
  "roletitle"                 return 'ROLETITLE'
  "roleidentity"              return 'ROLEIDENTITY'
  
  "beginaction"               return 'BEGINACTION'
  "action"                    return 'ACTION'
  "endaction"                 return 'ENDACTION'
  
  "begincontext"              return 'BEGINCONTEXT'
  "context"					          return 'CONTEXT'
  "rag"                       return 'RAG'
  "endcontext"                return 'ENDCONTEXT'
  
  "beginstep"                 return 'BEGINSTEP'
  "fewshot"                   return 'FEWSHOT'
  "chainofthought"            return 'CHAINOFTHOUGHT'
  "endstep"                   return 'ENDSTEP'
  
  "build"                     return 'BUILD'
  "and"                       return 'AND'
  "or"                        return 'OR'
  "->"                        return 'LAMBDA'
  
  "outputformat"              return 'OUTPUTFORMAT'
  \(                          return 'LPAREN'
  \)                          return 'RPAREN'
  [A-Za-z_][A-Za-z0-9_]*      return 'IDENT'
  [.]                         return 'DOT_OPERATOR'
  
  /lex
```

## Module Include
```bnf
  %{
    function PrintFunction(...args) {
      return args;
    }
  %}
```

## Syntactic Grammar

```bnf
  %%
  
  Expression
    : StartExpression
    ;
  
  StartExpression
    : StartTerminal DOT_OPERATOR RoleTitleExpression {
      PrintFunction($1, $2, $3);
    }
  ;
  
  RoleTitleExpression
    : RoleTitleTerminal DOT_OPERATOR RoleIdentityExpression {
      PrintFunction($1, $2, $3);
    }
  ;
  
  RoleIdentityExpression
    : RoleIdentityTerminal DOT_OPERATOR BeginActionExpression {
      PrintFunction($1, $2, $3);
    }
  ;
  
  
  
  
  // Action Expressions
  // ---------------------------------------------------
  
  BeginActionExpression
    : BeginActionTerminal LPAREN ActionLambdaExpression RPAREN DOT_OPERATOR BeginContextExpression
    ;
  ActionLambdaExpression
    : LPAREN IDENT RPAREN ActionLambdaStatement
    ;
  ActionLambdaStatement
    : LAMBDA IDENT DOT_OPERATOR ActionStatementExpression
    ;
  ActionStatementExpression
    : ActionTerminal DOT_OPERATOR LogicalOperator DOT_OPERATOR ActionStatementExpression
    | ActionTerminal DOT_OPERATOR EndActionTerminal
    ;
  // ----------------------------------------------------
  
  
  
  
  // Context Expressions
  // ----------------------------------------------------
  
  BeginContextExpression
    : BeginContextTerminal LPAREN ContextLambdaExpression RPAREN DOT_OPERATOR BeginStepExpression
    ;
  ContextLambdaExpression
    : LPAREN IDENT RPAREN ContextLambdaStatement
    ;
  ContextLambdaStatement
    : LAMBDA IDENT DOT_OPERATOR ContextStatementExpression
    ;
  ContextStatementExpression
    : ContextTerminal DOT_OPERATOR LogicalOperator DOT_OPERATOR ContextStatementExpression
    | ContextTerminal DOT_OPERATOR RagTerminal DOT_OPERATOR EndContextTerminal
    | RagTerminal DOT_OPERATOR EndContextTerminal
    ;
  // -----------------------------------------------------
  
  
  
  
  // Step Expressions
  // -----------------------------------------------------
  
  BeginStepExpression
    : BeginStepTerminal LPAREN StepLambdaExpression RPAREN DOT_OPERATOR OutputFormatExpression
    ;
  StepLambdaExpression
    : LPAREN IDENT RPAREN StepLambdaStatement
    ;
  StepLambdaStatement
    : LAMBDA IDENT DOT_OPERATOR StepStatementExpression
    ;
  StepStatementExpression
    : FewShotTerminal DOT_OPERATOR LogicalOperator DOT_OPERATOR StepStatementExpression
    | FewShotTerminal DOT_OPERATOR EndStepTerminal
    | FewShotTerminal DOT_OPERATOR LogicalOperator DOT_OPERATOR ChainOfThoughtTerminal DOT_OPERATOR StepStatementExpression
    | ChainOfThoughtTerminal DOT_OPERATOR LogicalOperator DOT_OPERATOR StepStatementExpression
    | ChainOfThoughtTerminal DOT_OPERATOR EndStepTerminal
    ;
  
  
  
  
  // Output Format Expression
  // ------------------------------------------------------
  
  OutputFormatExpression
    : OutputFormatTerminal DOT_OPERATOR LogicalOperator DOT_OPERATOR OutputFormatExpression
    | OutputFormatTerminal DOT_OPERATOR BuildTerminal
    ;
  
  
  // Terminals
  // ----------------------------------
  
  FewShotTerminal
    : FEWSHOT
    ;
  
  OutputFormatTerminal
    : OUTPUTFORMAT
    ;
  
  LogicalOperator
    : AND
    | OR
    ;
  
  AddTerminal
    : ADD
    ;
  
  ActionTerminal
    : ACTION
    ;
  
  StartTerminal
    : START
    ;
  
  RoleIdentityTerminal
    : ROLEIDENTITY
    ;
  
  IdentTerminal
    : IDENT
    ;
  
  ContextTerminal
    : CONTEXT
    ;
  
  BuildTerminal
    : BUILD
    ;
  
  RoleTitleTerminal
    : ROLETITLE
    ;
  
  BeginActionTerminal
    : BEGINACTION
    ;
  
  EndActionTerminal
    : ENDACTION
    ;
  
  BeginContextTerminal
    : BEGINCONTEXT
    ;
  
  EndContextTerminal
    : ENDCONTEXT
    ;
  
  RagTerminal
    : RAG
    ;
  
  BeginStepTerminal
    : BEGINSTEP
    ;
  
  OutputFormatTerminal
    : OUTPUTFORMAT
    ;
  
  EndStepTerminal
    : ENDSTEP
    ;
  
  ChainOfThoughtTerminal
    : CHAINOFTHOUGHT
    ;
```
