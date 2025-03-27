# Shipment Company Management System

Shipment management system built with Spring Boot. This system helps companies manage their shipping operations, from user registering, order processing to delivery tracking.

## Features

- Customer Management: Register customer information and shipping notification preference.
- Order Management**: Create, track, and manage shipping orders
- API Integration: RESTful API for integration with frontend

## Tech Stack

- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- PostgreSQL
- Flyway - Database Migrations
- Docker Compose
- Maven

## Prerequisites
- Java 21 or later
- Docker and Docker Compose

## Getting Started

1. Clone the repository:
```bash
git clone https://github.com/yourusername/shipment-company.git
cd shipment-company
```

1. Start the database using Docker Compose:
```bash
docker-compose up -d
```

1. Start the backend:
```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`

## API Interaction

A Postman collection is available in the root directory (`Shipment_company.postman_collection.json`) for testing the API endpoints.

## Database

The application uses PostgreSQL as its primary database. Database migrations are handled by Flyway.