# Productos API Web

Este es un proyecto completo que permite **gestionar productos** a través de una API REST desarrollada con **Java Spring Boot**, **PostgreSQL** y un frontend simple en **HTML, CSS y JavaScript**.

 📦 Tecnologías utilizadas

 Backend:
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- ModelMapper
- Validaciones con Jakarta Bean Validation
- Arquitectura en capas (DTO, Entity, Service, Repository, Controller)
- Gestión de errores personalizada

### Frontend:
- HTML, CSS y JS Vanilla
- Bootstrap 5 para estilos
- Fetch API para peticiones HTTP

---

## 🗂️ Estructura del proyecto

productos-api/
│
├── src/
│ ├── controller/
│ ├── dto/
│ ├── entity/
│ ├── exception/
│ ├── mapper/
│ ├── repository/
│ ├── service/
│ └── config/
│
├── resources/
│ ├── static/ ← Contiene index.html y JS
│ └── application.properties
│
└── ProductosApiApplication.java

---

## 🛢️ Base de datos

Este proyecto utiliza **PostgreSQL** como base de datos relacional. Al iniciar la aplicación, las tablas se generan automáticamente gracias a Hibernate (DDL auto).  

**Configuración esperada por defecto** (en el archivo `application.properties`):

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/productosbd
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

📌 Asegúrate de tener una base de datos creada con el nombre `productosbd` en tu servidor PostgreSQL local antes de ejecutar la aplicación.

🧱 Crear base de datos manualmente:

```sql
CREATE DATABASE productosbd;
```

---

## 🚀 ¿Cómo ejecutar el proyecto?

### Opción 1: Desde un IDE (IntelliJ IDEA / VS Code)
1. Clona este repositorio o descarga el ZIP.
2. Abre el proyecto en tu IDE.
3. Verifica que PostgreSQL esté corriendo y que la DB `productosbd` exista.
4. Ejecuta la clase principal: `com.productosapi.ProductosApiApplication`
5. Accede desde el navegador a: [http://localhost:8080/index.html](http://localhost:8080/index.html)

### Opción 2: Desde la línea de comandos (con Maven)
```bash
git clone https://github.com/tu-usuario/productos-api.git
cd productos-api
mvn spring-boot:run
```

---

## 🌐 ¿Cómo probar las APIs?

Puedes usar Postman, Insomnia o directamente el frontend (index.html).

| Método | Endpoint                | Descripción              |
|--------|--------------------------|--------------------------|
| GET    | /api/productos          | Listar productos         |
| POST   | /api/productos          | Crear producto           |
| PUT    | /api/productos/{id}     | Editar producto          |
| DELETE | /api/productos/{id}     | Eliminar producto        |
| GET    | /api/productos/{id}     | Obtener producto por ID  |

---
📫 Endpoints y uso en Postman
1. 🔍 Obtener todos los productos

GET http://localhost:8080/api/productos

📤 Respuesta (Si es que ya se agrego almenos un producto):

        json
        [
        {
            "id": 1,
            "nombre": "Producto Agregado",
            "precio": 150000,
            "stock": 10
        },
  
]
2. ➕ Crear un producto

POST http://localhost:8080/api/productos

📥 Body:

        json
        {
        "nombre": "Test 1",
        "precio": 120000,
        "stock": 5
        }
📤 Respuesta:

        json
        {
        "mensaje": "Producto guardado correctamente"
        }
❗ Si faltan datos, devolverá un error 400 con el detalle del campo inválido.

3. 📝 Actualizar un producto

PUT http://localhost:8080/api/productos/{id} (cargar id del producto)

📥 Body:

        json
        {
        "nombre": "Tinta Bio",
        "precio": 180000,
        "stock": 12
        }
📤 Respuesta:

        json
        {
        "mensaje": "Producto actualizado correctamente"
        }
4. ❌ Eliminar un producto

DELETE http://localhost:8080/api/productos/{id} (cargar id del producto)

📤 Respuesta:

        json
        {
        "mensaje": "Producto eliminado correctamente"
        }
5. 🔎 Obtener producto por ID

GET http://localhost:8080/api/productos/{id} (cargar id del producto)

📤 Respuesta:

        json
        {
        "id": 1,
        "nombre": "Tinta Bio",
        "precio": 180000,
        "stock": 12
        }


## 🧪 Validaciones

- Nombre obligatorio (`@NotBlank`)
- Precio mínimo 0 (`@Min`)
- Stock mínimo 0 (`@Min`)

---

## 💡 Funcionalidades del Frontend

- Crear, editar y eliminar productos
- Mostrar métricas: total, inventario, stock bajo
- Interfaz amigable y responsive

---

## 🔜 Mejoras futuras posibles

- Autenticación con JWT
- Filtros, búsqueda, ordenamiento
- Auditoría de cambios

---

## 🛠️ Autor

**Eduardo Balbuena**  
Este proyecto fue desarrollado como parte de un **test técnico solicitado por la empresa Seguros Patria** para evaluar mis habilidades en desarrollo backend. El objetivo fue construir una API funcional.

---

## ✅ Estado del proyecto

✅ Backend completo  
✅ Frontend funcional  
✅ Validaciones  
✅ Conexión estable con PostgreSQL  
✅ Listo para producción o pruebas locales
