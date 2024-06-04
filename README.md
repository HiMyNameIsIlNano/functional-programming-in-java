# Takes on Functional Programming

Difference between `Statements` and `Expressions`:

- `Statements` do some work and return nothing
- `Expressions` do some work and return a result

Thus `Statements` must cause side effects and mutate memory to fulfill their purpose, whereas `Expressions` do not
cause any side effect. In functional programming `Expressions` have to be favoured over `Statements`. `Statements` cannot
be composed whereas `Expressions` can as the output of the first statement is passed on to the next one until the end of
the chain.