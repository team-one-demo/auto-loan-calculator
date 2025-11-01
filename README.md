# Auto Loan Calculator (acalc)

A REST API for calculating auto loan payments.

## Overview

This application provides a REST endpoint that calculates monthly payments and total amount paid for an auto loan based on:
- Car price
- Repayment term in years
- Interest rate

## API Usage

### Calculate Loan

**Endpoint:** POST /api/loan/calculate

**Request Body:**
```json
{
  "carPrice": 20000.0,
  "repaymentYears": 5,
  "interestRate": 4.5
}
```

**Response Body:**
```json
{
  "monthlyPayment": 372.86,
  "totalPayment": 22371.6
}
```

# Coding Standards

## Naming Conventions

- Classes should use PascalCase (e.g., CustomerService)
- Methods and variables should use camelCase (e.g., getUserData())
- Constants should use UPPER_SNAKE_CASE (e.g., MAX_RETRY_COUNT)
- Package names should use lowercase (e.g., com.company.project)

## Formatting

- Indentation should be 4 spaces (not tabs)
- Line length should not exceed 80-120 characters
- Closing curly braces should always be alone in a single line
- Use a space before opening curly braces
- Use spaces around operators (e.g., x = y + z)

## Documentation

- All public classes and methods should have Javadoc comments
- Use @param, @return, and @throws tags in method documentation

## Code Organization

- One class per file
- Group related methods together
- Order class members logically (constants, fields, constructors, methods)
- Keep methods short and focused on a single responsibility

## Best Practices

- Always use braces for control statements, even for single-line blocks
- Avoid magic numbers; use named constants
- Handle exceptions appropriately; never use empty catch blocks
- Always override toString(), equals(), and hashCode() when appropriate
- Use interfaces for type declarations when possible

## Null Handling

- Use Optional<T> for values that might be absent
- Validate parameters with Objects.requireNonNull()
- Document nullable parameters and return values

## Resource Management

- Always close resources using try-with-resources
- Prefer try-with-resources over finally blocks
