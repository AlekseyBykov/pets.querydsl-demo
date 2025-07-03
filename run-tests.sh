#!/bin/bash

echo "======================================="
echo " Starting tests for pets-querydsl-demo"
echo "======================================="

# Fail on first error
set -e

# Clean and run tests with Maven
mvn clean test

echo "======================================="
echo " Tests completed successfully"
echo "======================================="
