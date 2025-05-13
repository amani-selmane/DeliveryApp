
# 🍽️ Online Food Delivery System

## 📌 Description

The **Online Food Delivery System** is a full-stack application powered by **Spring Boot** on the backend and **Angular** on the frontend. It is designed to replicate real-world food ordering platforms like **Swiggy** or **Uber Eats**. This system enables users to browse restaurants, explore menus, place orders, track deliveries, and make payments — all through a clean and modular architecture.

---

## 🚀 Key Features

- 👥 **User Registration & Authentication** (Clients and Delivery Personnel)
- 🏬 **Restaurant Management**: Add, view, and manage restaurant profiles and their menus
- 🛒 **Order Management**: Place orders, view order history, and manage status
- 📦 **Real-Time Order Tracking**: Track delivery progress
- 🧍‍♂️ **Delivery Management**: Manage and assign delivery personnel
- 💳 **Payment Gateway Integration** *(for future integration)*
- 📊 **Admin Dashboard**: Monitor system activity, user metrics, and restaurant performance

---

## 🛠️ Tech Stack

- **Backend**: Java 17, Spring Boot, JPA, Hibernate
- **Frontend**: Angular
- **Database**: MySQL or H2 (configurable)
- **Testing Tools**: Postman, JUnit

---

## 📦 Installation & Setup

### 🔧 Backend (Spring Boot)

```bash
# Clone the repository
git clone https://github.com/your-username/online-food-delivery.git

# Navigate to the backend project directory
cd online-food-delivery

# Build the project
mvn clean install

# Run the application
java -jar target/online-food-delivery.jar
```

### 🌐 Frontend (Angular)

```bash
# Navigate to Angular folder
cd frontend

# Install dependencies
npm install

# Run the app
ng serve
```

---

## 📬 API Usage – Insert JSON Data with Postman

1. Open **Postman**.
2. Choose **POST** request.
3. URL: `http://localhost:8080/api/restaurants` (example endpoint)
4. In the **Body** tab, select `raw` → `JSON`, and paste your JSON:
```json
{
  "name": "Pizza House",
  "location": "Downtown City",
  "cuisineType": "Italian",
  "rating": 4.5
}
```
5. Click **Send**.
6. Check the database or use a **GET** request to verify insertion.

---

## 📂 Folder Structure (Simplified)

```
online-food-delivery/
├── src/
│   ├── main/
│   │   ├── java/com/example/
│   │   │   ├── controllers/
│   │   │   ├── services/
│   │   │   ├── entities/
│   │   │   └── repositories/
│   ├── resources/
│       ├── application.properties
├── frontend/
│   ├── src/app/
│   │   ├── components/
│   │   ├── services/
│   │   └── models/
```

---

## 🤝 Contributing

Contributions are welcome!  
Feel free to fork this repository, submit issues, or create pull requests to improve the system.

---

## 📄 License

This project is licensed under the **MIT License** – see the [LICENSE](LICENSE) file for details.
