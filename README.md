# Arya Banking API Gateway

Reactive Spring Cloud Gateway — the single entry point for all HTTP traffic. Handles JWT validation, request routing, and load balancing.

## Quick Start

```powershell
mvn clean package -DskipTests
docker build -t arya-banking-api-gateway .
docker run -p 8085:8085 arya-banking-api-gateway
```

Or run via the [infra Docker Compose stack](https://github.com/Event-Based-Banking-Application/arya-banking-infra).

## Links

- [Local Development Setup](https://event-based-banking-application.github.io/arya-banking/docs/local-development/)
- [API Gateway Docs](https://event-based-banking-application.github.io/arya-banking/docs/api-gateway/)
