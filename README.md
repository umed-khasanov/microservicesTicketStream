#TicketStream - High-Load Event-Driven Ticket Booking System

TicketStream is a backend platform designed to handle high-traffic ticket booking request spikes (e.g., major concert ticket drops in Dublin). Built using a clean layered architecture, **Spring Boot 3**, **Apache Kafka**, and **PostgreSQL** inside **Docker**.

The system utilizes an asynchronous flow where booking requests are buffered through a message broker to prevent database gridlocks under concurrent loads.

---

##Architectural Overview & Design Patterns

The project follows a **Layered Enterprise Architecture** with strict isolation between distinct application responsibilities:

1. **REST Controller Layer (`/controller`):** Exposes HTTP end-points (`GET` and `POST`) returning clean JSON payloads.
2. **DTO (Data Transfer Object) Pattern (`/dto`):** Isolates the internal database schema. Validates incoming user inputs at the system entry point.
3. **Service Layer (`/service`):** Contains core business logic, including email uniqueness verification and dynamic tier price matrices.
4. **Data Access Layer (`/repository` & `/entity`):** Models database entities and communicates with PostgreSQL using Spring Data JPA repository abstractions.
5. **Infrastructure Layer:** Apache Kafka environment running in containerized background modes.

---

##Tech Stack

- **Backend Framework:** Spring Boot 3
- **Data Persistence:** Spring Data JPA / Hibernate
- **Database:** PostgreSQL 15
- **Message Broker Infrastructure:** Apache Kafka / Zookeeper (Confluent Platform)
- **Containerization:** Docker & Docker Compose
- **Boilerplate Reduction:** Lombok (`@Data`, `@RequiredArgsConstructor`)
- **Input Validation:** Jakarta Validation (JSR-380)

---

##Input Validations & Business Logic Rules

The application enforces strict data compliance rules before processing payloads:
- **Irish Mobile Validation:** Regulated via strict geographical regex layout (`^\+353(83|85|87|89)\d{7}$`).
- **Strong Password Checks:** Enforces robust criteria requiring uppercase letters, digits, and unique special characters.
- **Dynamic Tier Pricing:** Automatically handles immutable `BigDecimal` calculation matrices mapping across distinct categories (`STANDARD`, `VIP`, `LUXURY`).

---

Verify inside your **Docker Desktop** dashboard that all three containers (`unique_ticket_db`, `ticket_stream_zookeeper`, and `ticket_stream_kafka`) are healthy and running green.
