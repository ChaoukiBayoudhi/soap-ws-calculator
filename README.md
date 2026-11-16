# SOAP ws calculator

A soap project based on spring-boot.

## Tech stack

- Java 11, built with Maven
- Spring Boot 2.2.0.RELEASE
- Spring Web (REST controllers)
- Spring Web Services (SOAP)
- Spring Boot Actuator
- Lombok
- WSDL4J

## Concepts covered

SOAP endpoint, inheritance, static/final members.

## Project structure

- `com.isg.soa.wscalculator`: ServletInitializer, WsCalculatorApplication
- `com.isg.soa.wscalculator.Config`: webServiceConfig
- `com.isg.soa.wscalculator.EndPoint`: calulatorEndPoint
- `isg.soa.calculator.schema`: AddRequest, AddResponse, DivisionRequest, DivisionResponse, MinusRequest, MultipResponse, MultiplicationRequest, MunisResponse, ObjectFactory, package-info
- Tests: 1 test class
- Contract: `src/main/resources/Calculator.xsd`

## How to run

Requirements: a JDK 11+ and Maven (or the included Maven wrapper).

```bash
./mvnw spring-boot:run
```

The API then listens on `http://localhost:1122`.

---

Author: [Chaouki Bayoudhi](https://github.com/ChaoukiBayoudhi)
